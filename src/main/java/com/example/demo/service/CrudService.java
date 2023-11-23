package com.example.demo.service;

import com.example.demo.entities.Tables;

import java.util.List;

public interface CrudService<T> {
    T save (T t) throws Exception;
    void delete (Long id) throws Exception;
    List<T> getAll() throws Exception;
    T getById(Long id) throws Exception;
}
