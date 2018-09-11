package com.example.demo.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="chats")
public class Chat implements Serializable {

    @Id
    private Integer idUsuario1;
    @Id
    private Integer idUsuario2;

    public Chat(Integer idUsuario1, Integer idUsuario2) {
        this.idUsuario1 = idUsuario1;
        this.idUsuario2 = idUsuario2;
    }

    public Chat() {
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

    @Override
    public String toString() {
        return "Chat{" +
                "idUsuario1=" + idUsuario1 +
                ", idUsuario2=" + idUsuario2 +
                '}';
    }
}
