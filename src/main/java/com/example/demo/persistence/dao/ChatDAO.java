package com.example.demo.persistence.dao;

import com.example.demo.domain.Chat;

import java.io.Serializable;
import java.util.List;

public interface ChatDAO<T,ID extends Serializable> extends GenericDAO<Chat, Integer> {
    List<T> getIdUsers(ID idUsuario);

}
