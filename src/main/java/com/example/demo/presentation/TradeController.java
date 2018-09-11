package com.example.demo.presentation;

import com.example.demo.core.exception.BusinessException;
import com.example.demo.domain.Trade;
import com.example.demo.persistence.dao.TradeDAO;
import com.example.demo.persistence.dao.impl.TradeDAOimplHibernate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class TradeController {
    TradeDAO tradedao;

    public TradeController() {
        tradedao = new TradeDAOimplHibernate();
    }

    @GetMapping("/Trade/{idUsuario}/{idUsuario2}")
    public List<Trade> trades(@PathVariable Integer idUsuario, @PathVariable Integer idUsuario2) throws BusinessException {
        List<Trade> trades= null;
        if(idUsuario!=null && idUsuario2!=null){
            trades= tradedao.trades(idUsuario,idUsuario2);
        }
        return trades;
    }
}
