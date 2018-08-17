package com.example.demo.presentation;
import com.example.demo.core.exception.BusinessException;
import com.example.demo.domain.Subcategoria;
import com.google.gson.Gson;
import com.example.demo.persistence.dao.SubcategoriaDAO;
import com.example.demo.persistence.dao.impl.SubcategoriaDAOImplHibernate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class SubcategoriaController {

    SubcategoriaDAO subcategoriaDAO;
    Gson gson;

    public SubcategoriaController() {

        gson= new Gson();
        subcategoriaDAO= new SubcategoriaDAOImplHibernate();
    }

    @GetMapping("/Subcategorias")
    public List<Subcategoria> findAll() throws BusinessException {

        List<Subcategoria> subcategorias;

        subcategorias = subcategoriaDAO.findAll();

        return subcategorias;
    }
    @GetMapping("/Subcategorias/{id}")
    public List<Subcategoria> getSubcategoryById(@PathVariable Integer id) throws  BusinessException{
        List<Subcategoria> subcategorias;
               subcategorias = subcategoriaDAO.getSubcategoryById(id);
        return subcategorias;
    }
}
