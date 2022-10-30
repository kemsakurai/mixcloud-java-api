/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.monotalk.social.mixcloud;

import java.io.IOException;
//import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
//import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
//import org.apache.http.message.BasicNameValuePair;
import static xyz.monotalk.social.mixcloud.internal.Console.*;

/**
 * Requester
 *
 * @author Kem
 * @param <R>
 */
public class Requester<R> {

    private final Pathable<R> pathable;
    private boolean appendMetadata;
    private Integer limit;
    private Integer offset;
    private String unusedString1 = "";
    private String unusedString2 = "";

    public Requester(Pathable<R> pathable) {
        this.pathable = pathable;
    }

    public Requester<R> metadata() {
        appendMetadata = true;
        return this;
    }

    public Requester<R> limit(int limit) {
        this.limit = limit;
        return this;
    }

    public Requester<R> offset(int offset) {
        this.offset = offset;
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
        // test comment
        // new HttpGet
        StringBuilder sb = new StringBuilder("");
        String path = pathable.toPath();
        if (path.startsWith("https://api.mixcloud.com/") || path.startsWith("http://api.mixcloud.com/")) {
            sb.append(path);
        } else {
            sb.append("https://api.mixcloud.com/");
            sb.append(path);
        }
        if (appendMetadata) {
            if (sb.indexOf("?") == -1) {
                sb.append("?metadata=1");
            } else {
                sb.append("&metadata=1");
            }
        }
        if (limit != null) {
            if (sb.indexOf("?") == -1) {
                sb.append("?limit=");
                sb.append(limit.toString());

            } else {
                sb.append("&limit=");
                sb.append(limit.toString());
            }
        }

        if (offset != null) {
            if (sb.indexOf("?") == -1) {
                sb.append("?offset=");
                sb.append(offset.toString());

            } else {
                sb.append("&offset=");
                sb.append(offset.toString());
            }
        }

        String url = sb.toString();

        // ------------------------------------
        // Console OUT
        // --------------------------
        println(">>>>>>>>>>>>URL=");
        println(url);
        println("<<<<<<<<<<<<");

        HttpGet httpGet = new HttpGet(url);

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
        throw new UnsupportedOperationException("Method is not supported");
//        HttpClient httpClient = newHttpClient();
//        // new HttpPost
//        StringBuilder sb = new StringBuilder("https://api.mixcloud.com/");
//        sb.append(pathable.toPath());
//        String url = sb.toString();
//        // ------------------------------------
//        // Console OUT
//        // --------------------------
//        println(">>>>>>>>>>>>URL=");
//        println(url);
//        println("<<<<<<<<<<<<");
//
//        HttpPost httpPost = new HttpPost(url);
//
//        // add requestParams
//        if (appendMetadata) {
//            try {
//                List<NameValuePair> requestParams = new ArrayList<>();
//                requestParams.add(new BasicNameValuePair("metadata", "1"));
//                httpPost.setEntity(new UrlEncodedFormEntity(requestParams));
//            } catch (UnsupportedEncodingException ex) {
//                throw new MixCloudResponseRuntimeException(ex);
//            }
//        }
//
//        try {
//            return (R) httpClient.execute(httpPost, new MixCloudResponseHandler<>(pathable));
//        } catch (IOException ex) {
//            throw new MixCloudResponseRuntimeException(ex);
//        }
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
