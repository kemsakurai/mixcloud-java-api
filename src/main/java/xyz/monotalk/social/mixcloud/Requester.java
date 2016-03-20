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
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
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
     * get method
     *
     * @return
     */
    public R get() {
        // new instance
        HttpClient httpClient = newHttpClient();

        // new HttpGet
        StringBuilder sb = new StringBuilder("https://api.mixcloud.com/");
        sb.append(pathable.toPath());
        if (appendMetadata) {
            sb.append("?metadata=1");
        }

        Logger.getLogger(Requester.class.getName()).log(Level.INFO, sb.toString());
        HttpGet httpGet = new HttpGet(sb.toString());

        try {
            return httpClient.execute(httpGet, new MixCloudResponseHandler<>(pathable));
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

        // new HttpPost
        StringBuilder sb = new StringBuilder("https://api.mixcloud.com/");
        sb.append(pathable.toPath());
        HttpPost httpPost = new HttpPost(sb.toString());

        // add requestParams
        if (appendMetadata) {
            try {
                List<NameValuePair> requestParams = new ArrayList<>();
                requestParams.add(new BasicNameValuePair("metadata", "1"));
                httpPost.setEntity(new UrlEncodedFormEntity(requestParams));
            } catch (UnsupportedEncodingException ex) {
                throw new MixCloudResponseRuntimeException(ex);
            }
        }
        try {
            return (R) httpClient.execute(httpPost, (HttpContext) new MixCloudResponseHandler<>(pathable));
        } catch (IOException ex) {
            throw new MixCloudResponseRuntimeException(ex);
        }
    }

    /**
     * newHttpClient
     *
     * @return
     */
    private HttpClient newHttpClient() {
        // request configuration
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(2000)
                .setSocketTimeout(2000)
                .build();

        // headers
        List<Header> headers = new ArrayList<>();
        headers.add(new BasicHeader("Accept-Charset", "utf-8"));
        headers.add(new BasicHeader("Accept-Language", "ja, en;q=0.8"));
        headers.add(new BasicHeader("User-Agent", "Mozilla/5.0"));

        // create client
        HttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(requestConfig)
                .setDefaultHeaders(headers).build();
        return httpClient;

    }
}
