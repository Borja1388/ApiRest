package com.example.demo.persistence.dao;


import com.example.demo.core.exception.BusinessException;
import com.example.demo.domain.Deseado;

import java.io.Serializable;
import java.util.List;


public interface DeseadoDAO<T,ID extends Serializable> extends GenericDAO<Deseado, Integer> {
 List<T> getDesired(ID idUsuario);
 boolean deleteDesired(T entity) throws BusinessException;

}
