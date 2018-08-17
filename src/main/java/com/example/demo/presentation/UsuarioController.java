package com.example.demo.presentation;

import com.example.demo.core.exception.BusinessException;
import com.example.demo.domain.Administrador;
import com.example.demo.persistence.dao.UsuarioDAO;
import com.example.demo.domain.Usuario;
import com.example.demo.persistence.dao.impl.UsuarioDAOImplHibernate;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class UsuarioController {

    UsuarioDAO usuarioDAO;
    Gson gson;

    public UsuarioController(){
        usuarioDAO  = new UsuarioDAOImplHibernate();
        gson = new Gson();


    }

    @GetMapping("/Usuarios")
    public List<Usuario> findAll() throws BusinessException {

        List<Usuario> usuarios;

        usuarios = usuarioDAO.findAll();

        return usuarios;
    }

    @GetMapping("/Usuarios/{id}")
    public Usuario get(@PathVariable Integer id) throws BusinessException{
        Usuario user;
        user= usuarioDAO.get(id);
        return user;

    }

    @DeleteMapping("/Usuarios/{id}")
    public boolean delete(@PathVariable Integer id) throws BusinessException {
        boolean response = false;
        if(id!=null) {
            usuarioDAO.delete(id);
            response = true;

        }
        return response;
    }

    @PostMapping("/Usuarios")
    public Usuario insert(@RequestBody String jsonBody) throws BusinessException{
        Usuario requestUsuario =gson.fromJson(jsonBody,Usuario.class);
        Usuario user =
                usuarioDAO.insert(requestUsuario);
        return user;

    }

}
