package com.example.demo.persistence.dao;


import com.example.demo.core.exception.BusinessException;
import com.example.demo.domain.Producto;
import java.util.List;

public interface ProductoDAO<T, ID> extends GenericDAO<Producto, Integer>  {
    List<T> findProducts(ID id) throws BusinessException;
    List<T> myProducts(ID id) throws BusinessException;
    boolean deleteMyProduct(ID idProducto, ID idPropietario);
    T getMyProduct(ID idProducto, ID idPropietario);
    List<T> getProductVisible(ID idPropietario);

}
