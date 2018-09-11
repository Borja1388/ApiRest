package com.example.demo.persistence.dao.impl;

import com.example.demo.domain.Chat;
import com.example.demo.persistence.HibernateUtil;
import com.example.demo.persistence.dao.ChatDAO;
import org.hibernate.Session;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class ChatDAOImplHibernate<T,ID extends Serializable> extends GenericDAOImplHibernate<Chat, Integer> implements ChatDAO<T,ID> {

    @Override
    public List<T> getIdUsers(ID idUsuario) {
        List<T> entities= null;
        Session session;
        String clase= getEntityClass().getName() + " C ";
        if(idUsuario !=null){
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            entities=session.createQuery("SELECT U.id, U.nombre, U.imagen, U2.id, U2.nombre, U2.imagen" +
                    " FROM "+ clase +
                    " INNER JOIN Usuario U" +
                    " ON C.idUsuario1=U.id" +
                    " INNER JOIN Usuario U2" +
                    " ON C.idUsuario2=U2.id" +
                    " WHERE C.idUsuario1=" + idUsuario + " OR C.idUsuario2=" + idUsuario).list();
        }
        return entities;
    }

    private Class<T> getEntityClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

}
