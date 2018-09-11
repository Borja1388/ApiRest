package com.example.demo.domain;

import org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="trades")
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTrade;

    private Integer idUsuario1;

    private Integer idUsuario2;

    private Integer idProducto1;

    private Integer idProducto2;

    private Integer usuario1Acepta;

    private Integer usuario2Acepta;

    @Temporal(TemporalType.DATE)
    @Column(name= "fecha")
    private Date fecha;

    private String estado;

    public Trade() {
    }

    public Trade(Integer idTrade, Integer idUsuario1, Integer idUsuario2, Integer idProducto1, Integer idProducto2, Integer usuario1Acepta, Integer usuario2Acepta, Date fecha, String estado) {
        this.idTrade = idTrade;
        this.idUsuario1 = idUsuario1;
        this.idUsuario2 = idUsuario2;
        this.idProducto1 = idProducto1;
        this.idProducto2 = idProducto2;
        this.usuario1Acepta = usuario1Acepta;
        this.usuario2Acepta = usuario2Acepta;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Integer getIdTrade() {
        return idTrade;
    }

    public void setIdTrade(Integer idTrade) {
        this.idTrade = idTrade;
    }

    public Integer getIdUsuario1() {
        return idUsuario1;
    }

    public void setIdUsuario1(Integer idUsuario1) {
        this.idUsuario1 = idUsuario1;
    }

    public Integer getIdUsuario2() {
        return idUsuario2;
    }

    public void setIdUsuario2(Integer idUsuario2) {
        this.idUsuario2 = idUsuario2;
    }

    public Integer getIdProducto1() {
        return idProducto1;
    }

    public void setIdProducto1(Integer idProducto1) {
        this.idProducto1 = idProducto1;
    }

    public Integer getIdProducto2() {
        return idProducto2;
    }

    public void setIdProducto2(Integer idProducto2) {
        this.idProducto2 = idProducto2;
    }

    public Integer getUsuario1Acepta() {
        return usuario1Acepta;
    }

    public void setUsuario1Acepta(Integer usuario1Acepta) {
        this.usuario1Acepta = usuario1Acepta;
    }

    public Integer getUsuario2Acepta() {
        return usuario2Acepta;
    }

    public void setUsuario2Acepta(Integer usuario2Acepta) {
        this.usuario2Acepta = usuario2Acepta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "idTrade=" + idTrade +
                ", idUsuario1=" + idUsuario1 +
                ", idUsuario2=" + idUsuario2 +
                ", idProducto1=" + idProducto1 +
                ", idProducto2=" + idProducto2 +
                ", usuario1Acepta=" + usuario1Acepta +
                ", usuario2Acepta=" + usuario2Acepta +
                ", fecha=" + fecha +
                ", estado='" + estado + '\'' +
                '}';
    }
}
