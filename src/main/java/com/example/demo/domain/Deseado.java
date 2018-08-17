package com.example.demo.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="deseados")
public class Deseado implements Serializable {
    @Id
    private Integer idUsuario;

    @Id
    private Integer idProducto;

    public Deseado() {
    }

    public Deseado(Integer idUsuario, Integer idProducto) {
        this.idUsuario = idUsuario;
        this.idProducto = idProducto;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }




}


