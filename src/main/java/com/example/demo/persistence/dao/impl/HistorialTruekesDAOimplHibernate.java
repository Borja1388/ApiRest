package com.example.demo.persistence.dao.impl;

import com.example.demo.core.exception.BusinessException;
import com.example.demo.domain.HistorialTruekes;
import com.example.demo.persistence.HibernateUtil;
import com.example.demo.persistence.dao.HistorialTruekesDAO;
import org.hibernate.Session;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class HistorialTruekesDAOimplHibernate<T, ID extends Serializable> extends GenericDAOImplHibernate<HistorialTruekes, Integer> implements HistorialTruekesDAO<T,ID> {
    @Override
    public List<T> getTruekes(ID idUsuario) throws BusinessException {
        List<T> entities;
        Session session;
        String clase = getEntityClass().getName() + " T ";
        session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        entities = session.createQuery("SELECT U.nombre, U2.nombre, P.nombre, P.imagen, P2.nombre, P2.imagen, T.fechaInicio, T.fechaFin " +
                " FROM "+ clase +
                " INNER JOIN Usuario U " +
                " on T.idUsuario1=U.id " +
                " INNER JOIN Usuario U2 " +
                " on T.idUsuario2=U2.id" +
                " INNER JOIN Producto P " +
                " on T.idProducto1 = P.id " +
                " INNER JOIN Producto P2 " +
                " on T.idProducto2=P2.id " +
                " WHERE T.idUsuario1=" +idUsuario+ " OR T.idUsuario2=" + idUsuario).list();

        session.getTransaction().commit();
        //session.close();

        return entities;
    }

    private Class<T> getEntityClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
