package com.example.demo.presentation;

import com.example.demo.core.exception.BusinessException;
import com.example.demo.domain.Administrador;
import com.example.demo.persistence.dao.AdministradorDAO;
import com.example.demo.persistence.dao.impl.AdministradorDAOImplHibernate;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
public class AdministradorController {

    Gson gson;


    AdministradorDAO administradorDAO;

    public AdministradorController(){
        administradorDAO  = new AdministradorDAOImplHibernate();
        gson = new Gson();

    }

    @GetMapping("/Administradores")
    public List<Administrador> findAll() throws BusinessException{

        List<Administrador> administradores;

        administradores = administradorDAO.findAll();

        return administradores;
    }

    @GetMapping("/Administradores/{id}")
    public Administrador get(@PathVariable Integer id) throws BusinessException{
        Administrador admin;
        admin=administradorDAO.get(id);
        return admin;

    }

    @PostMapping("/Administradores")
    public Administrador insert(
         @RequestBody String jsonBody) throws BusinessException {

        Administrador requestAdministrador = gson.fromJson(jsonBody, Administrador.class);

        Administrador admin =
                administradorDAO.insert(requestAdministrador);

        return admin;
    }

    @PutMapping("/Administradores")
    public Administrador update(@RequestBody String jsonBody) throws BusinessException {
        Administrador requestAdministrador =gson.fromJson(jsonBody,Administrador.class);
        Administrador admin =
                administradorDAO.update(requestAdministrador);
        return admin;
    }



}
