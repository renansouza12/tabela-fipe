package com.renan.tabelafipe.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class DataConverter {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public <T> List<T> getList(String json, Class<T> clazz) throws IOException {
        return objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, clazz));
    }

    public <T> T getData(String json, Class<T> clazz) throws IOException {
        return objectMapper.readValue(json, clazz);
    }
}
