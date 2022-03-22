package com.musula.backend.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtil {
    private static ObjectMapper objectMapper;

    public static synchronized ObjectMapper getInstance() {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
        return objectMapper;
    }
}
