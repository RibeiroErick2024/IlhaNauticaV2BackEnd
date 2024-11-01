package com.example.testsa.converter;

import java.util.List;

import com.example.testsa.dto.req.CadastroUsuarioDTO;
import com.example.testsa.dto.res.MarinheiroDTORes;
import com.example.testsa.dto.res.UsuarioDTORes;
import com.example.testsa.dto.res.UsuarioGeralDTORes;
import com.example.testsa.entities.Usuario;

public interface UsuarioConverter {

    public static UsuarioDTORes usuarioConverterLocador(Usuario entity){
        UsuarioDTORes all = new UsuarioDTORes();
        all.setId(entity.getId());
        all.setNomeCompleto(entity.getNomeCompleto());
        all.setCpf(entity.getCpf());
        all.setDataNascimento(entity.getDataNascimento());
        all.setGenero(entity.getGenero());

        List<MarinheiroDTORes> listMarinheiros = entity.getMarinheiro()
        .stream().map(a -> MarinheiroConverter.marinheiroDTORes(a)).toList();

        all.setMarinheiro(listMarinheiros);

        return all;
    }

    public static UsuarioGeralDTORes usuarioConverterGeral(Usuario entity){
        UsuarioGeralDTORes all = new UsuarioGeralDTORes();
        all.setId(entity.getId());
        all.setNomeCompleto(entity.getNomeCompleto());
        all.setCpf(entity.getCpf());
        all.setDataNascimento(entity.getDataNascimento());
        all.setGenero(entity.getGenero());

        return all;
    }

       public static Usuario dtoConverterUsuario(CadastroUsuarioDTO u){
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNomeCompleto(u.getNomeCompleto());
        novoUsuario.setEmail(u.getEmail());
        novoUsuario.setSenha(u.getSenha());

        return novoUsuario;  
    }

   
}

