package com.calheiros.backend.service;

import com.calheiros.backend.entity.Estado;
import com.calheiros.backend.repository.EstadoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EstadoService {

    private final EstadoRepository estadoRepository;

    public List<Estado> findAll(){
        return estadoRepository.findAll();
    }

    @Transactional
    public Estado insert(Estado estado){
        estado.setDataCriacao(new Date());
        return estadoRepository.saveAndFlush(estado);
    }

    public Estado update(Estado estado){
        estado.setDataAtualizacao(new Date());
        return estadoRepository.saveAndFlush(estado);
    }

    public void delete(Long id){
        Estado estado = estadoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Estado não encontrado com ID: " + id));
        estadoRepository.delete(estado);
    }
}