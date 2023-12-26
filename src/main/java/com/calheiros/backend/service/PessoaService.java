package com.calheiros.backend.service;
import java.util.Date;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calheiros.backend.entity.Pessoa;
import com.calheiros.backend.repository.PessoaRepository;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public Pessoa insert(Pessoa objeto) {
        objeto.setDataCriacao(new Date());
        Pessoa objetoNovo = pessoaRepository.saveAndFlush(objeto);
        return objetoNovo;
    }

    public Pessoa update(Pessoa objeto) {
        objeto.setDataAtualizacao(new Date());
        return pessoaRepository.saveAndFlush(objeto);
    }

    public void delete(Long id) {
        Pessoa objeto = pessoaRepository.findById(id).get();
        pessoaRepository.delete(objeto);
    }
}