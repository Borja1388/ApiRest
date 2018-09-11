package com.example.demo.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

@Entity
@Table(name="historialtruekes")

public class HistorialTruekes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHistorial;

    private Integer idUsuario1;

    private Integer idUsuario2;

    private Integer idProducto1;

    private Integer idProducto2;


    @Temporal(TemporalType.DATE)
    @Column(name= "fecha_inicio")
    private Date fechaInicio;

    @Temporal(TemporalType.DATE)
    @Column(name= "fecha_fin")
    private Date fechaFin;

    public HistorialTruekes() {

    }


    public HistorialTruekes(Integer idHistorial, Integer idUsuario1, Integer idUsuario2, Integer idProducto1, Integer idProducto2, Date fechaInicio, Date fechaFin) {
        this.idHistorial = idHistorial;
        this.idUsuario1 = idUsuario1;
        this.idUsuario2 = idUsuario2;
        this.idProducto1 = idProducto1;
        this.idProducto2 = idProducto2;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Integer getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(Integer idHistorial) {
        this.idHistorial = idHistorial;
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

    public Date getFechaInicio() throws ParseException {

        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return "HistorialTruekes{" +
                "idHistorial=" + idHistorial +
                ", idUsuario1=" + idUsuario1 +
                ", idUsuario2=" + idUsuario2 +
                ", idProducto1=" + idProducto1 +
                ", idProducto2=" + idProducto2 +
                ", fechaInicio='" + fechaInicio + '\'' +
                ", fechaFin='" + fechaFin + '\'' +
                '}';
    }
}
