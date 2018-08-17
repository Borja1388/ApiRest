package com.example.demo.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="productos")

public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer idSubcategoria;

    private Integer idPropietario;

    private String nombre;

    private String descripcion;

    private String imagen;

    private String imagenes;

    private String caracteristicas;

    private String visible;

    public Producto() {
    }

    public Producto(Integer id, Integer idSubcategoria, Integer idPropietario, String nombre, String descripcion, String imagen, String imagenes, String caracteristicas, String visible) {
        this.id = id;
        this.idSubcategoria = idSubcategoria;
        this.idPropietario = idPropietario;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.imagenes = imagenes;
        this.caracteristicas = caracteristicas;
        this.visible = visible;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setIdSubcategoria(Integer idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }

    public Integer getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(Integer idPropietario) {
        this.idPropietario = idPropietario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getImagenes() {
        return imagenes;
    }

    public void setImagenes(String imagenes) {
        this.imagenes = imagenes;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", idSubcategoria=" + idSubcategoria +
                ", idPropietario=" + idPropietario +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", imagen='" + imagen + '\'' +
                ", imagenes='" + imagenes + '\'' +
                ", caracteristicas='" + caracteristicas + '\'' +
                ", visible='" + visible + '\'' +
                '}';
    }
}
