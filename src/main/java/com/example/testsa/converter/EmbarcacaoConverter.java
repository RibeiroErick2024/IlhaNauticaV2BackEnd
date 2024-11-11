package com.example.testsa.converter;

import java.util.List;

import com.example.testsa.dto.req.EmbarcacaoDTOReq;
import com.example.testsa.dto.res.ImagemEmbarcacaoDTORes;
import com.example.testsa.dto.res.Embarcacao.EmbarcacaoDTORes;
import com.example.testsa.dto.res.Embarcacao.EmbarcacaoSimplesDTORes;
import com.example.testsa.entities.Embarcacao;

public class EmbarcacaoConverter {
     public static EmbarcacaoDTORes embarcacaoConverterDTO(Embarcacao embarcacao) {
        EmbarcacaoDTORes dto = new EmbarcacaoDTORes();
        dto.setIdEmbarcacao(embarcacao.getIdEmbarcacao());
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
        dto.setEndereco(EnderecoConverter.entidadeParaDto(embarcacao.getEndereco()));
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
        dto.setIdEmbarcacao(entidade.getIdEmbarcacao());
        dto.setNome(entidade.getNome());
     
        return entidade;
    }
}
