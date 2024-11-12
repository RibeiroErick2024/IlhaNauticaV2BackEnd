package com.example.testsa.converter;

import com.example.testsa.dto.res.Marinheiro.MarinheiroComUsuarioDTO;
import com.example.testsa.dto.res.Marinheiro.MarinheiroDTORes;
import com.example.testsa.entities.Marinheiro;

public class MarinheiroConverter {

    public static MarinheiroDTORes entidadeParaMarinheiroDTO(Marinheiro entity) {
        MarinheiroDTORes marinheiro = new MarinheiroDTORes();
        marinheiro.setIdMarinheiro(entity.getIdMarinheiro());
        marinheiro.setNome(entity.getNome());
        marinheiro.setRegistroMaritimo(entity.getRegistroMaritimo());
        marinheiro.setAnosExperiencia(entity.getAnosExperiencia());
        marinheiro.setCategoria(entity.getCategoria());
        marinheiro.setDisponibilidade(entity.getDisponibilidade());

        return marinheiro;

    }

    public static MarinheiroComUsuarioDTO entidadeParaMarinheiroComUsuarioDTO(Marinheiro entity) {
        MarinheiroComUsuarioDTO marinheiro = new MarinheiroComUsuarioDTO();
        marinheiro.setIdMarinheiro(entity.getIdMarinheiro());
        marinheiro.setNome(entity.getNome());
        marinheiro.setRegistroMaritimo(entity.getRegistroMaritimo());
        marinheiro.setAnosExperiencia(entity.getAnosExperiencia());
        marinheiro.setCategoria(entity.getCategoria());
        marinheiro.setDisponibilidade(entity.getDisponibilidade());
        marinheiro.setUsuario(UsuarioConverter.usuarioConverterSimples(entity.getUsuario()));

        return marinheiro;

    }

    public static Marinheiro dtoParaEntidade(MarinheiroDTORes entity) {
        Marinheiro marinheiro = new Marinheiro();
        marinheiro.setIdMarinheiro(entity.getIdMarinheiro());
        marinheiro.setNome(entity.getNome());
        marinheiro.setRegistroMaritimo(entity.getRegistroMaritimo());
        marinheiro.setAnosExperiencia(entity.getAnosExperiencia());
        marinheiro.setCategoria(entity.getCategoria());
        marinheiro.setDisponibilidade(entity.getDisponibilidade());
        // marinheiro.setUsuario(UsuarioConverter.dtoConverterUsuario(entity.getUsuario()));

        return marinheiro;

    }
}
