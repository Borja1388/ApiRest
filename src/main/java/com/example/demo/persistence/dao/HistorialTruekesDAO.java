package com.example.demo.persistence.dao;

import com.example.demo.core.exception.BusinessException;
import com.example.demo.domain.HistorialTruekes;

import java.util.List;

public interface HistorialTruekesDAO<T, ID> extends GenericDAO<HistorialTruekes, Integer> {
    List<T> getTruekes(ID idUsuario) throws BusinessException;
}
