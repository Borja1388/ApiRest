package com.example.demo.domain;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="categorias")
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String imagen;
    private String icono;


    public Categoria() {

    }

    public Categoria(int id, String nombre, String imagen, String icono) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
        this.icono = icono;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", imagen='" + imagen + '\'' +
                ", icono='" + icono + '\'' +
                '}';
    }
}
