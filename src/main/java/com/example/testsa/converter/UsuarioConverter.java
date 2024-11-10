package com.example.testsa.converter;

import java.util.List;

import com.example.testsa.dto.req.CadastroUsuarioDTO;
import com.example.testsa.dto.res.Marinheiro.MarinheiroDTORes;
import com.example.testsa.dto.res.Usuario.UsuarioGeralDTORes;
import com.example.testsa.dto.res.Usuario.UsuarioLocadorDTORes;
import com.example.testsa.dto.res.Usuario.UsuarioSimplesDTO;
import com.example.testsa.entities.Usuario;

public interface UsuarioConverter {
    
    public static UsuarioSimplesDTO usuarioConverterSimples(Usuario entity){
        UsuarioSimplesDTO dto = new UsuarioSimplesDTO();
        dto.setId(entity.getId());
        dto.setNomeCompleto(entity.getNomeCompleto());
        
        return dto;
    }
    public static UsuarioLocadorDTORes usuarioConverterLocador(Usuario entity){
        UsuarioLocadorDTORes all = new UsuarioLocadorDTORes();
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

       public static Usuario cadastroDTOConverterUsuario(CadastroUsuarioDTO u){
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNomeCompleto(u.getNomeCompleto());
        novoUsuario.setEmail(u.getEmail());
        novoUsuario.setSenha(u.getSenha());

        return novoUsuario;  
    }

   
}

