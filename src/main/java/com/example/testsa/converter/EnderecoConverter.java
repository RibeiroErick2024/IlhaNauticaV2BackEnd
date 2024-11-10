package com.example.testsa.converter;

import com.example.testsa.dto.res.EnderecoDTORes;
import com.example.testsa.entities.Endereco;

public interface EnderecoConverter {
    
       public static Endereco dtoParaEntidade(EnderecoDTORes dto) {
        Endereco endereco = new Endereco();
        endereco.setId_endereco(dto.getId_endereco());
        endereco.setRua(dto.getRua());
        endereco.setBairro(dto.getBairro());
        endereco.setCidade(dto.getCidade());
        endereco.setEstado(dto.getEstado());
        endereco.setNumero(dto.getNumero());
        endereco.setComplemento(dto.getComplemento());
        endereco.setLatitude(dto.getLatitude());
        endereco.setLongitude(dto.getLongitude());

        return endereco;

    }

    public static EnderecoDTORes entidadeParaDto(Endereco endereco) {
        EnderecoDTORes dto = new EnderecoDTORes();
    
        dto.setId_endereco(endereco.getId_endereco());
        dto.setRua(endereco.getRua());
        dto.setBairro(endereco.getBairro());
        dto.setCidade(endereco.getCidade());
        dto.setEstado(endereco.getEstado());
        dto.setNumero(endereco.getNumero());
        dto.setComplemento(endereco.getComplemento());
        dto.setLatitude(endereco.getLatitude());
        dto.setLongitude(endereco.getLongitude());
    
        return dto;
    }
}
