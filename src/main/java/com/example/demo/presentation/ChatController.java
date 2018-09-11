package com.example.demo.presentation;

import com.example.demo.domain.Chat;
import com.example.demo.persistence.dao.ChatDAO;
import com.example.demo.persistence.dao.impl.ChatDAOImplHibernate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ChatController {
    ChatDAO chatdao;

    public ChatController() {
        chatdao = new ChatDAOImplHibernate();
    }

    @GetMapping("/Chat/{idUsuario}")
    public List<Chat> geIdUsers(@PathVariable Integer idUsuario){
        List<Chat> idUsers= null;
        if(idUsuario !=null){
            idUsers=chatdao.getIdUsers(idUsuario);
        }
        return idUsers;
    }
}
