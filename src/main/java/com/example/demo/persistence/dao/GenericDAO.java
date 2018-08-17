package com.example.demo.persistence.dao;

import com.example.demo.core.exception.BusinessException;

import java.util.List;

public interface GenericDAO<T, ID> {
    T get(ID id) throws BusinessException;
    T insert(T entity) throws BusinessException;
    T update(T entity) throws BusinessException;
    boolean delete(ID id) throws BusinessException;
    List<T> findAll() throws BusinessException;
}
