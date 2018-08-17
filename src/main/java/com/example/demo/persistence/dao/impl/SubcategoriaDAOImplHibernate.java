package com.example.demo.persistence.dao.impl;

import com.example.demo.core.exception.BusinessException;
import com.example.demo.domain.Subcategoria;
import com.example.demo.persistence.HibernateUtil;
import com.example.demo.persistence.dao.SubcategoriaDAO;
import org.hibernate.Session;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class SubcategoriaDAOImplHibernate<T,ID extends Serializable> extends GenericDAOImplHibernate<Subcategoria, Integer> implements SubcategoriaDAO<T,ID> {

    @Override
    public List<T> getSubcategoryById(ID id) throws BusinessException {
        List<T> entities;
        Session session;

        session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        entities = session.createQuery("SELECT id,nombre FROM " + getEntityClass().getName() + " entity  WHERE idCategoria= " + id).list();
        session.getTransaction().commit();
        //session.close();

        return entities;

    }

    private Class<T> getEntityClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
