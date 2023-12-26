package com.calheiros.backend.service;

import java.util.Date;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calheiros.backend.entity.Permissao;
import com.calheiros.backend.entity.PermissaoPessoa;
import com.calheiros.backend.entity.Pessoa;
import com.calheiros.backend.repository.PermissaoPessoaRepository;
import com.calheiros.backend.repository.PermissaoRepository;

@Service
@RequiredArgsConstructor
public class PermissaoPessoaService {

    private final PermissaoPessoaRepository permissaoPessoaRepository;


    private final PermissaoRepository permissaoRepository;


    public void vincularPessoaPermissaoCliente(Pessoa pessoa){
        List<Permissao> listaPermissao = permissaoRepository.findByNome("cliente");
        if(listaPermissao.size()>0){
            PermissaoPessoa permissaoPessoa = new PermissaoPessoa();
            permissaoPessoa.setPessoa(pessoa);
            permissaoPessoa.setPermissao(listaPermissao.get(0));
            permissaoPessoa.setDataCriacao(new Date());
            permissaoPessoaRepository.saveAndFlush(permissaoPessoa);
        }
    }

}