/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.monotalk.social.mixcloud;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import xyz.monotalk.social.mixcloud.data.Response;

/**
 * Requester
 *
 * @author Kem
 * @param <R>
 */
public class Requester<R extends Response> {

    private final Pathable<R> pathable;
    private boolean appendMetadata;

    public Requester(Pathable<R> pathable) {
        this.pathable = pathable;
    }

    public Requester<R> metadata() {
        appendMetadata = true;
        return this;
    }

    /**
     * GET method
     *
     * @return
     */
    public R get() {
        // new instance
        HttpClient httpClient = newHttpClient();
        HttpGet httpGet = new HttpGet();
        try {
            return (R) httpClient.execute(httpGet, (HttpContext) new MixCloudResponseHandler<>(pathable));
        } catch (IOException ex) {
            throw new MixCloudResponseRuntimeException(ex);
        }

    }

    /**
     * POST method
     *
     * @return
     */
    public R post() {
        HttpClient httpClient = newHttpClient();
        HttpPost method = new HttpPost();
        List<NameValuePair> requestParams = new ArrayList<>();
        requestParams.add(new BasicNameValuePair("foo", "var"));
        String body = null;
        try {
            method.setEntity(new UrlEncodedFormEntity(requestParams));
            HttpResponse response = httpClient.execute(method);
            int responseStatus = response.getStatusLine().getStatusCode();
            body = EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Requester.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ParseException ex) {
            Logger.getLogger(Requester.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pathable.newResponse(body);
    }

    /**
     * newHttpClient
     *
     * @return
     */
    private HttpClient newHttpClient() {

        // configurations
        int socketTimeout = 3;
        int connectionTimeout = 3;
        String userAgent = "My Http Client 0.1";

        // request configuration
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(connectionTimeout)
                .setSocketTimeout(socketTimeout)
                .build();

        // headers
        List<Header> headers = new ArrayList<>();
        headers.add(new BasicHeader("Accept-Charset", "utf-8"));
        headers.add(new BasicHeader("Accept-Language", "ja, en;q=0.8"));
        headers.add(new BasicHeader("User-Agent", userAgent));

        // create client
        HttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(requestConfig)
                .setDefaultHeaders(headers).build();
        return httpClient;

    }
}
