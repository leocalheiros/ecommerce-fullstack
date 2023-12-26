package com.calheiros.backend.service;
import java.util.Date;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calheiros.backend.entity.Marca;
import com.calheiros.backend.repository.MarcaRepository;

@Service
@RequiredArgsConstructor
public class MarcaService {

    private final MarcaRepository marcaRepository;

    public List<Marca> findAll() {
        return marcaRepository.findAll();
    }

    public Marca insert(Marca objeto) {
        objeto.setDataCriacao(new Date());
        Marca objetoNovo = marcaRepository.saveAndFlush(objeto);
        return objetoNovo;
    }

    public Marca update(Marca objeto) {
        objeto.setDataAtualizacao(new Date());
        return marcaRepository.saveAndFlush(objeto);
    }

    public void delete(Long id) {
        Marca objeto = marcaRepository.findById(id).get();
        marcaRepository.delete(objeto);
    }
}
