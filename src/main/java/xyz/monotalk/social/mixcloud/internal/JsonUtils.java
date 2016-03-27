/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.monotalk.social.mixcloud.internal;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;
import xyz.monotalk.social.mixcloud.data.MixCloudResult;

/**
 * JsonUtils
 *
 * @author kensakurai
 */
public class JsonUtils {

    /**
     * toMap
     *
     * @param obj
     * @return
     */
    public static Map<String, Object> toMap(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> objectAsMap = mapper.convertValue(obj, Map.class);
        return objectAsMap;
    }

    /**
     * readValue
     *
     * @param <T>
     * @param json
     * @param clazz
     * @return
     */
    public static <T> T readValue(String json, Class<T> clazz) {
        T result = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            result = mapper.readValue(json, clazz);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return result;
    }

    /**
     * readResultValue
     *
     * @param <T>
     * @param json
     * @param clazz
     * @return
     */
    public static <T> MixCloudResult<T> readResultValue(String json, Class<T> clazz) {
        MixCloudResult<T> result = null;
        ObjectMapper mapper = new ObjectMapper();
        JavaType type = mapper.getTypeFactory().constructParametrizedType(MixCloudResult.class, MixCloudResult.class, clazz);
        try {
            result = mapper.readValue(json, type);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return result;
    }
}
