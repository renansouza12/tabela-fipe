package com.renan.tabelafipe.service;

import java.util.List;

public interface IDataConverter {

    <T> T getData(String json, Class<T> classe);  
    <T> List<T> getList(String json, Class<T> classe);
} 