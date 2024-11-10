package com.example.testsa.converter;

import com.example.testsa.dto.res.Marinheiro.MarinheiroComUsuarioDTO;
import com.example.testsa.dto.res.Marinheiro.MarinheiroDTORes;
import com.example.testsa.entities.Marinheiro;

public class MarinheiroConverter {

    public static MarinheiroDTORes marinheiroDTORes(Marinheiro entity) {
        MarinheiroDTORes marinheiro = new MarinheiroDTORes();
        marinheiro.setId_marinheiro(entity.getId_marinheiro());
        marinheiro.setRegistroMaritimo(entity.getRegistroMaritimo());
        marinheiro.setAnosExperiencia(entity.getAnosExperiencia());
        marinheiro.setCategoria(entity.getCategoria());
        marinheiro.setDisponibilidade(entity.getDisponibilidade());

        return marinheiro;

    }

    public static MarinheiroComUsuarioDTO marinheiroComUsuarioDTOResponse(Marinheiro entity) {
        MarinheiroComUsuarioDTO marinheiro = new MarinheiroComUsuarioDTO();
        marinheiro.setId_marinheiro(entity.getId_marinheiro());
        marinheiro.setRegistroMaritimo(entity.getRegistroMaritimo());
        marinheiro.setAnosExperiencia(entity.getAnosExperiencia());
        marinheiro.setCategoria(entity.getCategoria());
        marinheiro.setDisponibilidade(entity.getDisponibilidade());
        marinheiro.setUsuario(UsuarioConverter.usuarioConverterSimples(entity.getUsuario()));

        return marinheiro;

    }

    public static Marinheiro dtoParaEntidade(MarinheiroDTORes entity) {
        Marinheiro marinheiro = new Marinheiro();
        marinheiro.setId_marinheiro(entity.getId_marinheiro());
        marinheiro.setRegistroMaritimo(entity.getRegistroMaritimo());
        marinheiro.setAnosExperiencia(entity.getAnosExperiencia());
        marinheiro.setCategoria(entity.getCategoria());
        marinheiro.setDisponibilidade(entity.getDisponibilidade());
        // marinheiro.setUsuario(UsuarioConverter.dtoConverterUsuario(entity.getUsuario()));

        return marinheiro;

    }
}
