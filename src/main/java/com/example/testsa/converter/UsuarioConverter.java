package com.example.testsa.converter;

import java.util.List;

import com.example.testsa.dto.res.MarinheiroDTORes;
import com.example.testsa.dto.res.UsuarioDTORes;
import com.example.testsa.entities.Marinheiro;
import com.example.testsa.entities.Usuario;

public interface UsuarioConverter {

    public static UsuarioDTORes usuarioConverterDTO(Usuario entity){
        UsuarioDTORes all = new UsuarioDTORes();
        all.setId(entity.getId());
        all.setNomeCompleto(entity.getNomeCompleto());
        all.setCpf(entity.getCpf());
        all.setDataNascimento(entity.getDataNascimento());
        all.setGenero(entity.getGenero());

        List<MarinheiroDTORes> listMarinheiros = entity.getMarinheiro()
        .stream().map(a -> marinheiroDTORes(a)).toList();

        all.setMarinheiro(listMarinheiros);

        return all;
    }

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

