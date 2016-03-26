/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.monotalk.social.mixcloud;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import org.seasar.framework.util.tiger.GenericUtil;
import xyz.monotalk.social.mixcloud.data.MixCloudResult;
import xyz.monotalk.social.mixcloud.internal.Console;
import xyz.monotalk.social.mixcloud.internal.JacksonUtils;

/**
 * Direct
 *
 * @author kensakurai
 * @param <R>
 */
public class Direct<R> extends AbstractDirect<R> implements RequesterBuilder {

    private String url;

    private Class<R> clazz;

    /**
     * Constructor
     *
     * @param url
     */
    public Direct(String url) {
        if (isValidURL(url)) {
            throw new IllegalArgumentException(url);
        }
        this.url = url;

        Map<TypeVariable<?>, Type> map = GenericUtil.getTypeVariableMap(getClass());

        for (Class<?> c = getClass(); c != Object.class; c = c.getSuperclass()) {
            if (c.getSuperclass() == AbstractDirect.class) {
                Type type = c.getGenericSuperclass();
                Type[] arrays = GenericUtil.getGenericParameter(type);

                Console.println(">>>>>>>>>>");
                Console.println(String.valueOf(arrays.length));
                Console.println("<<<<<<<<<<");

                Console.println(">>>>>>>>>>");
                Console.println(map.toString());
                Console.println("<<<<<<<<<<");
                clazz = (Class<R>) GenericUtil.getActualClass(arrays[0], map);
                break;
            }
        }
    }

    @Override
    public String toPath() {
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        return sb.toString();
    }

    @Override
    public R newResponse(String body) {
        if (clazz == MixCloudResult.class) {
            return (R) JacksonUtils.readResultValue(body, clazz);
        }
        return JacksonUtils.readValue(body, clazz);
    }

    @Override
    public Requester<R> build() {
        return new Requester<>(this);
    }

    private boolean isValidURL(String url) {

        URL u;

        try {
            u = new URL(url);
        } catch (MalformedURLException e) {
            return false;
        }

        try {
            u.toURI();
        } catch (URISyntaxException e) {
            return false;
        }

        return url.startsWith("https://www.mixcloud.com") || url.startsWith("http://www.mixcloud.com");
    }
}
