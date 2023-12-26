package com.calheiros.backend.service;

import com.calheiros.backend.entity.Cidade;
import com.calheiros.backend.entity.Estado;
import com.calheiros.backend.repository.CidadeRepository;
import com.calheiros.backend.repository.EstadoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CidadeService {
    private final CidadeRepository cidadeRepository;

    public List<Cidade> findAll(){
        return cidadeRepository.findAll();
    }

    @Transactional
    public Cidade insert(Cidade cidade){
        cidade.setDataCriacao(new Date());
        return cidadeRepository.saveAndFlush(cidade);
    }

    public Cidade update(Cidade cidade){
        cidade.setDataAtualizacao(new Date());
        return cidadeRepository.saveAndFlush(cidade);
    }

    public void delete(Long id){
        Cidade cidade = cidadeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cidade não encontrada com ID: " + id));
        cidadeRepository.delete(cidade);
    }
}
