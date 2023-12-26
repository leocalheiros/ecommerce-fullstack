package com.calheiros.backend.service;
import java.util.Date;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calheiros.backend.entity.Permissao;
import com.calheiros.backend.repository.PermissaoRepository;

@Service
@RequiredArgsConstructor
public class PermissaoService {

    private final PermissaoRepository permissaoRepository;

    public List<Permissao> findAll() {
        return permissaoRepository.findAll();
    }

    public Permissao insert(Permissao objeto) {
        objeto.setDataCriacao(new Date());
        Permissao objetoNovo = permissaoRepository.saveAndFlush(objeto);
        return objetoNovo;
    }

    public Permissao update(Permissao objeto) {
        objeto.setDataAtualizacao(new Date());
        return permissaoRepository.saveAndFlush(objeto);
    }

    public void delete(Long id) {
        Permissao objeto = permissaoRepository.findById(id).get();
        permissaoRepository.delete(objeto);
    }
}
