package com.calheiros.backend.service;
import java.util.Date;
import java.util.List;

import com.calheiros.backend.entity.Produto;
import com.calheiros.backend.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto findById(Long id) {
        Produto objeto = produtoRepository.findById(id).get();
        return objeto;
    }

    public Produto insert(Produto objeto) {
        objeto.setDataCriacao(new Date());
        Produto objetoNovo = produtoRepository.saveAndFlush(objeto);
        return objetoNovo;
    }

    public Produto update(Produto objeto) {
        objeto.setDataAtualizacao(new Date());
        return produtoRepository.saveAndFlush(objeto);
    }

    public void delete(Long id) {
        Produto objeto = produtoRepository.findById(id).get();
        produtoRepository.delete(objeto);
    }


}
