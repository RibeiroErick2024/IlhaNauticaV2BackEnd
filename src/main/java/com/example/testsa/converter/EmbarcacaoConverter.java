package com.example.testsa.converter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.example.testsa.dto.req.EmbarcacaoDTOReq;
import com.example.testsa.dto.res.ImagemEmbarcacaoDTORes;
import com.example.testsa.dto.res.Embarcacao.EmbarcacaoCardDTO;
import com.example.testsa.dto.res.Embarcacao.EmbarcacaoDTORes;
import com.example.testsa.dto.res.Embarcacao.EmbarcacaoSimplesDTORes;
import com.example.testsa.entities.Embarcacao;
import com.example.testsa.entities.Usuario;

public class EmbarcacaoConverter {

    private static final String IMAGEM_PADRAO_PATH = "./src/main/resources/static/parati.jpg";

    public static EmbarcacaoDTORes embarcacaoConverterDTO(Embarcacao embarcacao) {
        EmbarcacaoDTORes dto = new EmbarcacaoDTORes();
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
        // dto.setEndereco(
        //         embarcacao.getEndereco() != null ? EnderecoConverter.entidadeParaDto(embarcacao.getEndereco()) : null);

          // Verificar se as imagens são nulas ou vazias
        if (embarcacao.getImagem() != null && !embarcacao.getImagem().isEmpty()) {
            List<ImagemEmbarcacaoDTORes> listaImagens = embarcacao.getImagem()
                    .stream().map(imagem -> ImagemEmbarcacaoConverter.entidadeParaDtoSemImagem(imagem)).toList();
            dto.setImagem(listaImagens);
        } else {
            // Caso a lista de imagens seja null ou vazia, insira uma imagem padrão
            List<ImagemEmbarcacaoDTORes> listaImagensPadrao = new ArrayList<>();
            
            // Criar uma imagem padrão a partir de um arquivo
            ImagemEmbarcacaoDTORes imagemPadrao = new ImagemEmbarcacaoDTORes();
            try {
                // Carregar o arquivo de imagem em um byte array
                byte[] imagemBytes = Files.readAllBytes(Paths.get(IMAGEM_PADRAO_PATH));
                
                imagemPadrao.setId_imagem(1L);
                imagemPadrao.setImagem(imagemBytes);
                imagemPadrao.setFormato("jpeg");  // Supondo que a imagem seja no formato JPEG
                imagemPadrao.setNome("Imagem Padrão");

                listaImagensPadrao.add(imagemPadrao);
            } catch (IOException e) {
                // Em caso de erro ao carregar a imagem, você pode lançar uma exceção ou definir uma imagem vazia
                e.printStackTrace();
                // Aqui você pode adicionar um tratamento para caso o arquivo não seja encontrado
            }

            dto.setImagem(listaImagensPadrao);
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
