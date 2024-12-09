package com.example.testsa.converter;

import java.util.List;

import com.example.testsa.dto.req.EmbarcacaoDTOReq;
import com.example.testsa.dto.res.ImagemEmbarcacaoDTORes;
import com.example.testsa.dto.res.Embarcacao.EmbarcacaoCardDTO;
import com.example.testsa.dto.res.Embarcacao.EmbarcacaoDTORes;
import com.example.testsa.dto.res.Embarcacao.EmbarcacaoSimplesDTORes;
import com.example.testsa.entities.Embarcacao;
import com.example.testsa.entities.Usuario;

public class EmbarcacaoConverter {

    public static EmbarcacaoDTORes embarcacaoConverterDTO(Embarcacao embarcacao) {
        EmbarcacaoDTORes dto = new EmbarcacaoDTORes();
        System.out.println("Embarcacao Completa");
        dto.setUsuario(UsuarioConverter.usuarioConverterSimples(embarcacao.getUsuario()));
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
        dto.setUsuario(UsuarioConverter.usuarioConverterSimples(embarcacao.getUsuario()));
        System.out.println(dto.getUsuario().getId());
        // dto.setEndereco(
        //         embarcacao.getEndereco() != null ? EnderecoConverter.entidadeParaDto(embarcacao.getEndereco()) : null);

          // Verificar se as imagens são nulas ou vazias
        if (embarcacao.getImagem() != null && !embarcacao.getImagem().isEmpty()) {
            List<ImagemEmbarcacaoDTORes> listaImagens = embarcacao.getImagem()
                    .stream().map(imagem -> ImagemEmbarcacaoConverter.entidadeParaDtoSemImagem(imagem)).toList();
            dto.setImagem(listaImagens);
        } 
            

        // dto.setImagem(listaImagensPadrao);
        
        return dto;
    }

    public static EmbarcacaoCardDTO embarcacaoConverterCardDTO(Embarcacao embarcacao) {
        EmbarcacaoCardDTO dto = new EmbarcacaoCardDTO();
        System.out.println("Embarcacao Card");

        dto.setIdEmbarcacao(embarcacao.getIdEmbarcacao());
        dto.setAnoFabricacao(embarcacao.getAnoFabricacao());
        dto.setNome(embarcacao.getNome());
        dto.setFabricante(embarcacao.getFabricante());
        dto.setTamanho(embarcacao.getTamanho());
        dto.setPotencia(embarcacao.getPotencia());
        dto.setCapacidade(embarcacao.getCapacidade());
        dto.setCategoria(embarcacao.getCategoria());
        dto.setPet(embarcacao.getPet());
        dto.setPreco(embarcacao.getPreco());
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
        System.out.println("Embarcacao Entidade");

        entidade.setNome(dto.getNome());
        entidade.setFabricante(dto.getFabricante());
        entidade.setPotencia(dto.getPotencia());
        entidade.setAnoFabricacao(dto.getAnoFabricacao());
        entidade.setTamanho(dto.getTamanho());
        entidade.setCapacidade(dto.getCapacidade());
        entidade.setCategoria(dto.getCategoria());
        entidade.setEnderecoEmbarque(dto.getEnderecoEmbarque());
        entidade.setDisponibilidade(dto.getDisponibilidade());
        entidade.setQuantidadeBanheiro(dto.getQuantidadeBanheiro());
        entidade.setQuantidadeCabines(dto.getQuantidadeCabines());
        entidade.setInscricao(dto.getInscricao());
        entidade.setBandeira(dto.getBandeira());
        entidade.setPreco(dto.getPreco());
        entidade.setRegras(dto.getRegras());
        entidade.setDescricao(dto.getDescricao());

        Usuario usuario = new Usuario();
        usuario.setId(dto.getUsuario().getId());
        entidade.setUsuario(usuario);
        return entidade;
    }
}
