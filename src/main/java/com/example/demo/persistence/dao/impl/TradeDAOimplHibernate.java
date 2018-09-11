package com.example.demo.persistence.dao.impl;

import com.example.demo.core.exception.BusinessException;
import com.example.demo.domain.Trade;
import com.example.demo.persistence.HibernateUtil;
import com.example.demo.persistence.dao.TradeDAO;
import org.hibernate.Session;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class TradeDAOimplHibernate<T,ID extends Serializable> extends GenericDAOImplHibernate<Trade, Integer> implements TradeDAO<T,ID> {
    @Override
    public List<T> trades(ID idUsuario, ID idUsuario2) throws BusinessException {
        List<T> entities=null;
        Session session;
        if(idUsuario!=null && idUsuario2!=null){


            session = HibernateUtil.getSessionFactory().openSession();

            session.beginTransaction();
            entities= session.createQuery("SELECT P.id, P.nombre,P.imagen,T.usuario1Acepta,P2.id, P2.nombre,P2.imagen,T.usuario2Acepta,T.idTrade" +
                    " FROM Trade T" +
                    " INNER JOIN Producto P" +
                    " ON P.id = T.idProducto1" +
                    " INNER JOIN Producto P2" +
                    " ON P2.id = T.idProducto2" +
                    " WHERE T.idUsuario1 = "+ idUsuario +" and T.idUsuario2 = " + idUsuario2 +
                    " OR T.idUsuario1="+ idUsuario2 +" and T.idUsuario2="+ idUsuario).list();
            session.getTransaction().commit();
            //session.close();
        }

        return entities;
    }

    private Class<T> getEntityClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
