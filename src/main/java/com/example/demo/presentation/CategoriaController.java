package com.example.demo.presentation;

import com.example.demo.core.exception.BusinessException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.persistence.dao.impl.CategoriaDAOImplHibernate;
import com.example.demo.persistence.dao.CategoriaDAO;
import com.example.demo.domain.Categoria;
import com.google.gson.Gson;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class CategoriaController {

        Gson gson;
        CategoriaDAO categoriaDAO;

    public CategoriaController() {
        gson= new Gson();
        categoriaDAO = new CategoriaDAOImplHibernate();
    }

    @GetMapping("/Categorias")
    public List<Categoria> findAll() throws BusinessException {

        List<Categoria> categorias;

        categorias = categoriaDAO.findAll();

        return categorias;
    }
}
