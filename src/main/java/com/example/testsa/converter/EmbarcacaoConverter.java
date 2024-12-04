package com.example.testsa.converter;

import java.util.List;

import com.example.testsa.dto.req.EmbarcacaoDTOReq;
import com.example.testsa.dto.res.ImagemEmbarcacaoDTORes;
import com.example.testsa.dto.res.Embarcacao.EmbarcacaoCardDTO;
import com.example.testsa.dto.res.Embarcacao.EmbarcacaoDTORes;
import com.example.testsa.dto.res.Embarcacao.EmbarcacaoSimplesDTORes;
import com.example.testsa.entities.Embarcacao;

public class EmbarcacaoConverter {
    public static EmbarcacaoDTORes embarcacaoConverterDTO(Embarcacao embarcacao) {
        EmbarcacaoDTORes dto = new EmbarcacaoDTORes();
        dto.setIdEmbarcacao(embarcacao.getIdEmbarcacao());
        dto.setNome(embarcacao.getNome());
        dto.setFabricante(embarcacao.getFabricante());
        dto.setPotencia(embarcacao.getPotencia());
        dto.setAnoFabricacao(embarcacao.getAnoFabricacao());
        dto.setTamanho(embarcacao.getTamanho());
        dto.setCapacidade(embarcacao.getCapacidade());
        dto.setCategoria(embarcacao.getCategoria());
        dto.setEnderecoEmbarque(embarcacao.getEnderecoEmbarque());
        dto.setDisponibilidade(embarcacao.getDisponibilidade());
        dto.setPet(embarcacao.getPet());
        dto.setQuantidadeBanheiro(embarcacao.getQuantidadeBanheiro());
        dto.setQuantidadeCabines(embarcacao.getQuantidadeCabines());
        dto.setInscricao(embarcacao.getInscricao());
        dto.setBandeira(embarcacao.getBandeira());
        dto.setPreco(embarcacao.getPreco());
        dto.setRegras(embarcacao.getRegras());
        dto.setDescricao(embarcacao.getDescricao());
        dto.setEnderecoEmbarque(embarcacao.getEnderecoEmbarque());
        // dto.setEndereco(
        //         embarcacao.getEndereco() != null ? EnderecoConverter.entidadeParaDto(embarcacao.getEndereco()) : null);

        if (embarcacao.getImagem() != null) {
            List<ImagemEmbarcacaoDTORes> listaImagens = embarcacao.getImagem()
                    .stream().map(imagem -> ImagemEmbarcacaoConverter.entidadeParaDtoSemImagem(imagem)).toList();

            dto.setImagem(listaImagens);
        }

        return dto;
    }

    public static EmbarcacaoCardDTO embarcacaoConverterCardDTO(Embarcacao embarcacao) {
        EmbarcacaoCardDTO dto = new EmbarcacaoCardDTO();
        dto.setIdEmbarcacao(embarcacao.getIdEmbarcacao());
        dto.setAnoFabricacao(embarcacao.getAnoFabricacao());
        dto.setNome(embarcacao.getNome());
        dto.setFabricante(embarcacao.getFabricante());
        dto.setTamanho(embarcacao.getTamanho());
        dto.setPotencia(embarcacao.getPotencia());
        dto.setCapacidade(embarcacao.getCapacidade());
        dto.setCategoria(embarcacao.getCategoria());
        dto.setPet(embarcacao.getPet());
        dto.setQuantidadeBanheiro(embarcacao.getQuantidadeBanheiro());
        dto.setQuantidadeCabines(embarcacao.getQuantidadeCabines());
        dto.setEnderecoEmbarque(embarcacao.getEnderecoEmbarque());
        // if (embarcacao.getEndereco() != null) {
        //     dto.setEndereco(EnderecoConverter.entidadeParaDto(embarcacao.getEndereco()));

        // }
        List<ImagemEmbarcacaoDTORes> listaImagens = embarcacao.getImagem()
                .stream().map(imagem -> ImagemEmbarcacaoConverter.entidadeParaDto(imagem)).toList();

        dto.setImagem(listaImagens);

        return dto;
    }

    public static EmbarcacaoSimplesDTORes embarcacaoConverterDTOSimples(Embarcacao embarcacao) {
        EmbarcacaoSimplesDTORes dto = new EmbarcacaoSimplesDTORes();
        dto.setIdEmbarcacao(embarcacao.getIdEmbarcacao());
        dto.setNome(embarcacao.getNome());

        return dto;
    }

    public static Embarcacao dtoConverterEntidade(EmbarcacaoDTOReq dto) {
        Embarcacao entidade = new Embarcacao();
        entidade.setIdEmbarcacao(dto.getIdEmbarcacao());
        entidade.setNome(dto.getNome());
        entidade.setIdEmbarcacao(dto.getIdEmbarcacao());
        entidade.setAnoFabricacao(dto.getAnoFabricacao());
        entidade.setNome(dto.getNome());
        entidade.setFabricante(dto.getFabricante());
        entidade.setTamanho(dto.getTamanho());
        entidade.setPotencia(dto.getPotencia());
        entidade.setCapacidade(dto.getCapacidade());
        entidade.setCategoria(dto.getCategoria());
        entidade.setQuantidadeBanheiro(dto.getQuantidadeBanheiro());
        entidade.setQuantidadeCabines(dto.getQuantidadeCabines());

        return entidade;
    }
}
