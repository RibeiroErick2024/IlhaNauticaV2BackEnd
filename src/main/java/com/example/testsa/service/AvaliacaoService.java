// package com.example.testsa.service;

// import java.util.List;
// import java.util.Optional;
// import java.util.UUID;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.testsa.entities.Avaliacao;
// import com.example.testsa.entities.Embarcacao;
// import com.example.testsa.entities.Usuario;
// import com.example.testsa.repositories.AvaliacaoRepository;

// import jakarta.transaction.Transactional;

// @Service
// public class AvaliacaoService {

//     @Autowired
//     AvaliacaoRepository avaliacaoRepository;

//     public List<Avaliacao> getAllAvaliacoes() {
//         return avaliacaoRepository.findAll();
//     }

//     @Transactional
//     public Avaliacao createAvaliacao(Avaliacao avaliacao) {

//         return avaliacaoRepository.save(avaliacao);
//     }

//      public Avaliacao getAvaliacaoById(UUID id_avaliacao) {
//         return avaliacaoRepository.findById(id_avaliacao)
//                 .orElseThrow(() -> new RuntimeException("Embarcação com ID " + id_avaliacao + " não encontrada."));
//     }


//    @Transactional
//    public  Avaliacao updateAvaliacao(UUID id_avaliacao, Avaliacao updateAvaliacao){
//             Avaliacao avaliacaoToUpdate =  getAvaliacaoById(id_avaliacao);
    
//             avaliacaoToUpdate.setComentario(updateAvaliacao.getComentario());
//             avaliacaoToUpdate.setNotaMarinheiro(updateAvaliacao.getNotaMarinheiro());
//             avaliacaoToUpdate.setEmbarcacao(updateAvaliacao.getEmbarcacao());
//             avaliacaoToUpdate.setNotaAgendamento(updateAvaliacao.getNotaAgendamento());

//             return avaliacaoRepository.save(avaliacaoToUpdate);
//    }


   


// }
