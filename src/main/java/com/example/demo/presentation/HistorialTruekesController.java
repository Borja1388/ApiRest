package com.example.demo.presentation;

import com.example.demo.core.exception.BusinessException;
import com.example.demo.domain.HistorialTruekes;
import com.example.demo.persistence.dao.HistorialTruekesDAO;
import com.example.demo.persistence.dao.impl.HistorialTruekesDAOimplHibernate;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController

public class HistorialTruekesController {

    HistorialTruekesDAO historialTruekesDAO;
    Gson gson;

    public HistorialTruekesController() {
        historialTruekesDAO = new HistorialTruekesDAOimplHibernate();
        gson = new Gson();
    }

    @GetMapping("/historial/{idUsuario}")
    public List<HistorialTruekes> getTruekes(@PathVariable Integer idUsuario) throws BusinessException {
        List<HistorialTruekes> truekes = null;
        if(idUsuario!=null) {
            truekes = historialTruekesDAO.getTruekes(idUsuario);
        }
        return truekes;
   }
}
