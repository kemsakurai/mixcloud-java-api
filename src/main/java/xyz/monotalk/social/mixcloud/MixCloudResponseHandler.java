/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.monotalk.social.mixcloud;

import java.io.IOException;
import java.text.MessageFormat;
import lombok.NonNull;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.StatusLine;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;
import xyz.monotalk.social.mixcloud.data.MixCloudError;
import xyz.monotalk.social.mixcloud.data.Response;
import xyz.monotalk.social.mixcloud.internal.JacksonUtils;

/**
 * MixCloudResponseHandler
 *
 * @author kensakurai
 * @param <R>
 */
public class MixCloudResponseHandler<R extends Response> implements ResponseHandler<R> {

    private Pathable<R> pathable = null;

    /**
     * MixCloudResponseHandler
     *
     * @param pathable
     */
    public MixCloudResponseHandler(@NonNull Pathable<R> pathable) {
        this.pathable = pathable;
    }

    @Override
    public R handleResponse(@NonNull HttpResponse response) {

        // StatusLine
        StatusLine statusLine = response.getStatusLine();

        // 200 OK
        if (HttpStatus.SC_OK == statusLine.getStatusCode()) {
            String body = getBodyOrThrow(response);
            // Return Response
            return pathable.newResponse(body);
        }

        // 403 Error
        if (HttpStatus.SC_FORBIDDEN == statusLine.getStatusCode()) {
            // Header [Retry-After]
            Header header = response.getFirstHeader("Retry-After");
            if (header.getValue() == null || header.getValue().length() == 0) {
                // Throw Exception
                throwNewException(statusLine);
            }
            String body = getBodyOrThrow(response);
            MixCloudError error = JacksonUtils.readValue(body, MixCloudError.class);
            throw new MixCloudRateLimitException(error);
        }
        // Throw Exception
        throwNewException(statusLine);
        return null;
    }

    protected String getBodyOrThrow(HttpResponse response) throws MixCloudResponseRuntimeException {
        String body = null;
        try {
            HttpEntity entity = response.getEntity();
            body = EntityUtils.toString(entity, "UTF-8");
        } catch (IOException | ParseException ex) {
            // throw Exception
            throw new MixCloudResponseRuntimeException(ex);
        }
        return body;
    }

    /**
     * throwNewException
     *
     * @param statusLine
     */
    protected void throwNewException(StatusLine statusLine) throws MixCloudResponseRuntimeException {
        // new Meaage
        String msg = MessageFormat.format("Error Http Status : {0} ReasonPhrase : {1}", statusLine.getStatusCode(), statusLine.getReasonPhrase());
        // Throw Exception
        throw new MixCloudResponseRuntimeException(msg);
    }
}
