package com.mingyuan.gaea.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Optional;

/**
 * @author limingyuan
 */
public class JsonUtil {

    private JsonUtil() {
        throw new Error("JsonUtil类不能被初始化");
    }

    public static Optional<String> format(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return Optional.of(objectMapper.writeValueAsString(object));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public static <T> Optional<T> parse(String json, Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return Optional.of(objectMapper.readValue(json, clazz));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
