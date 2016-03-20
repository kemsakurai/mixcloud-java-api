/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.monotalk.social.mixcloud.internal;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * JacksonUtils
 *
 * @author kensakurai
 */
public class JacksonUtils {

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
}
