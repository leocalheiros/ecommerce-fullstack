package com.calheiros.backend.service;

import com.calheiros.backend.entity.Pessoa;
import com.calheiros.backend.entity.Produto;
import com.calheiros.backend.entity.ProdutoImagens;
import com.calheiros.backend.repository.PessoaRepository;
import com.calheiros.backend.repository.ProdutoImagemRepository;
import com.calheiros.backend.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoImagensService {
    private final ProdutoImagemRepository produtoImagemRepository;
    private final ProdutoRepository produtoRepository;


    public List<ProdutoImagens> findAll() {
        return produtoImagemRepository.findAll();
    }

    public ProdutoImagens insert(Long idProduto, MultipartFile file) {
        Produto produto = produtoRepository.findById(idProduto).get();
        ProdutoImagens objeto = new ProdutoImagens();

        try {
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                String nomeImagem = String.valueOf(produto.getId()) + file.getOriginalFilename();

                // Obtenha o diretório home do usuário
                String diretorioHome = System.getProperty("user.home");

                // Construa o caminho completo
                Path caminho = Paths.get(diretorioHome, "Desktop", "imagens", nomeImagem);

                // Crie o diretório, se não existir
                Files.createDirectories(caminho.getParent());

                // Escreva o arquivo
                Files.write(caminho, bytes);

                objeto.setNome(nomeImagem);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        objeto.setProduto(produto);
        objeto.setDataCriacao(new Date());
        objeto = produtoImagemRepository.saveAndFlush(objeto);
        return objeto;
    }

    public ProdutoImagens update(ProdutoImagens objeto) {
        objeto.setDataAtualizacao(new Date());
        return produtoImagemRepository.saveAndFlush(objeto);
    }

    public void delete(Long id) {
        ProdutoImagens objeto = produtoImagemRepository.findById(id).get();
        produtoImagemRepository.delete(objeto);
    }
}
