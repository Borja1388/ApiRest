package com.example.demo.persistence.dao;

import com.example.demo.core.exception.BusinessException;
import com.example.demo.domain.Subcategoria;
import java.util.List;

public interface SubcategoriaDAO<T,ID> extends GenericDAO<Subcategoria,Integer>{
    List<T> getSubcategoryById(ID id) throws BusinessException;
}
