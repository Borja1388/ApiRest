package com.example.demo.persistence.dao.impl;

import com.example.demo.core.exception.BusinessException;
import com.example.demo.core.exception.BusinessMessage;
import com.example.demo.domain.Deseado;
import com.example.demo.persistence.HibernateUtil;
import com.example.demo.persistence.dao.DeseadoDAO;
import org.hibernate.Session;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class DeseadoDAOImplHibernate<T,ID extends Serializable> extends GenericDAOImplHibernate<Deseado, Integer> implements DeseadoDAO<T,ID> {


    @Override
    public List<T> getDesired(ID idUsuario) {
        List<T> entities;
        Session session;

        session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        entities = session.createQuery("SELECT idProducto FROM " + getEntityClass().getName() + " entity  WHERE idUsuario= " + idUsuario).list();
        session.getTransaction().commit();
        //session.close();

        return entities;
    }

    @Override
    public boolean deleteDesired(T entity) throws BusinessException {
        Session session;
        boolean result;
       // T entity;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            if (entity != null) {
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
            result = true;
            } else {
            result = false;
            }

            //session.close();
            return result;
        } catch (javax.validation.ConstraintViolationException cve) {
            throw new BusinessException(new BusinessMessage("Restricción", "La base de datos no permite esta operación."));
        } catch (org.hibernate.exception.ConstraintViolationException cve) {
            throw new BusinessException(new BusinessMessage("Restricción", "La base de datos no permite esta operación."));
        }
    }

    private Class<T> getEntityClass() {
       return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }



}
