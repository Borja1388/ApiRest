package com.example.demo.persistence.dao.impl;

import com.example.demo.core.exception.BusinessException;
import com.example.demo.domain.Producto;
import com.example.demo.persistence.HibernateUtil;
import com.example.demo.persistence.dao.ProductoDAO;
import org.hibernate.Session;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class ProductoDAOImplHibernate<T, ID extends Serializable> extends GenericDAOImplHibernate<Producto, Integer> implements ProductoDAO<T,ID> {

    @Override
    public List<T> findProducts(ID id) throws BusinessException {
        List<T> entities;
        Session session;

        session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        entities = session.createQuery("SELECT entity FROM " + getEntityClass().getName() + " entity  WHERE idSubcategoria= " + id).list();
        session.getTransaction().commit();
        //session.close();

        return entities;
    }

    @Override
    public List<T> myProducts(ID id) throws BusinessException {
        List<T> entities;
        Session session;

        session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        entities = session.createQuery("SELECT id,nombre,descripcion,imagen FROM " + getEntityClass().getName() + " entity  WHERE idPropietario= " + id).list();
        session.getTransaction().commit();
        //session.close();

        return entities;
    }

    @Override
    public boolean deleteMyProduct(ID idProducto,ID idPropietario) {
        boolean response = false;
        Session session;
        T entity=getMyProduct(idProducto,idPropietario);
        if(entity != null){
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
            response = true;
        }
        return response;
    }

    @Override
    public T getMyProduct(ID idProducto, ID idPropietario) {
        T entity=null;
        Session session;
        if(idProducto != null && idPropietario != null){
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            entity = (T) session.createQuery("SELECT entity FROM " + getEntityClass().getName()+ " entity WHERE id= " + idProducto + " AND idPropietario = " +idPropietario).getSingleResult();
            session.getTransaction().commit();
        }
        return entity;
    }

    @Override
    public List<T> getProductVisible(ID idPropietario) {
        List<T> products= null;
        Session session;
        if(idPropietario!=null){
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            products =  session.createQuery("SELECT id FROM " + getEntityClass().getName()+ " entity WHERE idPropietario= " + idPropietario + " AND visible = 1").list();
            session.getTransaction().commit();
        }
        return products;
    }


    private Class<T> getEntityClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}


