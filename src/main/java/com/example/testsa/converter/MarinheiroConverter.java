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
        marinheiro.setCategoria(entity.getCategoria());
        marinheiro.setDisponibilidade(entity.getDisponibilidade());
        marinheiro.setCpf(entity.getCpf());
        marinheiro.setDataNascimento(entity.getDataNascimento());
        marinheiro.setGenero(entity.getGenero());
        marinheiro.setTelefone(entity.getTelefone());
        marinheiro.setEmail(entity.getEmail());

        return marinheiro;
    }

    public static MarinheiroComUsuarioDTO entidadeParaMarinheiroComUsuarioDTO(Marinheiro entity) {
        MarinheiroComUsuarioDTO marinheiro = new MarinheiroComUsuarioDTO();
        marinheiro.setIdMarinheiro(entity.getIdMarinheiro());
        marinheiro.setNome(entity.getNome());
        marinheiro.setRegistroMaritimo(entity.getRegistroMaritimo());
        marinheiro.setCategoria(entity.getCategoria());
        marinheiro.setDisponibilidade(entity.getDisponibilidade());
        marinheiro.setCpf(entity.getCpf());
        marinheiro.setDataNascimento(entity.getDataNascimento());
        marinheiro.setGenero(entity.getGenero());
        marinheiro.setTelefone(entity.getTelefone());
        marinheiro.setEmail(entity.getEmail());
        marinheiro.setUsuario(UsuarioConverter.usuarioConverterSimples(entity.getUsuario()));

        return marinheiro;
    }

    public static Marinheiro dtoParaEntidade(MarinheiroDTORes dto) {
        Marinheiro marinheiro = new Marinheiro();
        marinheiro.setIdMarinheiro(dto.getIdMarinheiro());
        marinheiro.setNome(dto.getNome());
        marinheiro.setRegistroMaritimo(dto.getRegistroMaritimo());
        marinheiro.setCategoria(dto.getCategoria());
        marinheiro.setDisponibilidade(dto.getDisponibilidade());
        marinheiro.setCpf(dto.getCpf());
        marinheiro.setDataNascimento(dto.getDataNascimento());
        marinheiro.setGenero(dto.getGenero());
        marinheiro.setTelefone(dto.getTelefone());
        marinheiro.setEmail(dto.getEmail());
        // marinheiro.setUsuario(UsuarioConverter.dtoConverterUsuario(dto.getUsuario()));

        return marinheiro;
    }
}