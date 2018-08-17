package com.example.demo.presentation;


import com.example.demo.core.exception.BusinessException;
import com.example.demo.domain.Deseado;
import com.example.demo.persistence.dao.DeseadoDAO;
import com.example.demo.persistence.dao.impl.DeseadoDAOImplHibernate;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class DeseadoController {

    DeseadoDAO deseadoDAO;
    Gson gson;

    public DeseadoController() {
        deseadoDAO = new DeseadoDAOImplHibernate();
        gson = new Gson();
    }

    @PostMapping("/Deseado")
    public Deseado insert(@RequestBody String jsonBody) throws BusinessException {
        Deseado requestDeseado = gson.fromJson(jsonBody, Deseado.class);

        Deseado deseado = (Deseado) deseadoDAO.insert(requestDeseado);


        return deseado;
    }

    @GetMapping("/Deseado/{idUsuario}")
    public  List<Deseado> getDesired(@PathVariable  Integer idUsuario){
        List<Deseado> entities;
        entities= deseadoDAO.getDesired(idUsuario);
        return entities;

    }

    @DeleteMapping("/Deseado")
    public boolean deleteDesired(@RequestBody String jsonBody) throws BusinessException {
        boolean response = false;
        Deseado requestDeseado = gson.fromJson(jsonBody, Deseado.class);
        if(requestDeseado != null){
            deseadoDAO.deleteDesired(requestDeseado);
            response = true;
        }
        return response;
    }





}
