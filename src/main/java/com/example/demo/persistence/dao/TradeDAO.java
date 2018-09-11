package com.example.demo.persistence.dao;

import com.example.demo.core.exception.BusinessException;
import com.example.demo.domain.Trade;

import java.util.List;

public interface TradeDAO<T,ID> extends GenericDAO<Trade, Integer>{
    List<T> trades(ID idUsuario, ID idUsuario2 ) throws BusinessException;
}
