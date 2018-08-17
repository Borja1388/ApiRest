package com.example.demo.persistence.dao.impl;

import com.example.demo.core.exception.BusinessException;
import com.example.demo.core.exception.BusinessMessage;
import com.example.demo.persistence.HibernateUtil;
import com.example.demo.persistence.dao.GenericDAO;
import org.hibernate.Session;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class GenericDAOImplHibernate<T, ID extends Serializable> implements GenericDAO<T, ID> {

    //protected SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public T get(ID id) throws BusinessException {
        T entity;
        Session session;

        //session = sessionFactory.openSession();
        session = HibernateUtil.getSessionFactory().openSession();
        entity = (T) session.get(getEntityClass(), id);
        //session.close();

        return entity;
    }

    @Override
    public T insert(T entity) throws BusinessException {
        Session session;
        try {
            //session = sessionFactory.openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
            //session.close();

            return entity;
        } catch (javax.validation.ConstraintViolationException cve) {
            throw new BusinessException(cve);
        } catch (org.hibernate.exception.ConstraintViolationException cve) {
            throw new BusinessException(cve);
        }
    }

    @Override
    public T update(T entity) throws BusinessException {
        Session session;
        try {
            //session = sessionFactory.openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
            //session.close();

            return entity;
        } catch (javax.validation.ConstraintViolationException cve) {
            throw new BusinessException(cve);
        } catch (org.hibernate.exception.ConstraintViolationException cve) {
            throw new BusinessException(cve);
        }
    }

    @Override
    public boolean delete(ID id) throws BusinessException {
        T entity;
        Session session;
        boolean result;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            //session = sessionFactory.openSession();

            entity = get(id);
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

    @Override
    public List<T> findAll() throws BusinessException {
        List<T> entities;
        Session session;

        session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        entities = session.createQuery("SELECT entity FROM " + getEntityClass().getName() + " entity").list();
        session.getTransaction().commit();
        //session.close();

        return entities;
    }

    private Class<T> getEntityClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

}