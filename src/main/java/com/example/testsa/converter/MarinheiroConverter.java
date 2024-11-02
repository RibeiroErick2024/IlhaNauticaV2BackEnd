package com.example.testsa.converter;

import com.example.testsa.dto.res.MarinheiroDTORes;
import com.example.testsa.entities.Marinheiro;

public class MarinheiroConverter {
         public static MarinheiroDTORes marinheiroDTORes(Marinheiro entity){
        MarinheiroDTORes marinheiro = new MarinheiroDTORes();
        marinheiro.setId_marinheiro(entity.getId_marinheiro());
        marinheiro.setRegistroMaritimo(entity.getRegistroMaritimo());
        marinheiro.setAnosExperiencia(entity.getAnosExperiencia());
        marinheiro.setCategoria(entity.getCategoria());
        marinheiro.setDisponibilidade(entity.getDisponibilidade());

        return marinheiro;

    }
}
