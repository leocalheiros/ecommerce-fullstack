package com.calheiros.backend.controller;

import java.util.List;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calheiros.backend.entity.Produto;
import com.calheiros.backend.service.ProdutoService;

@RestController
@RequestMapping("/api/produto")
@CrossOrigin
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping("/")
    public List<Produto> buscarTodos(){
        return produtoService.findAll();
    }

    @GetMapping("/{id}")
    public Produto findById(@PathVariable("id") Long id){
        return produtoService.findById(id);
    }

    @PostMapping("/")
    public Produto insert(@RequestBody Produto objeto){
        return produtoService.insert(objeto);
    }

    @PutMapping("/")
    public Produto update(@RequestBody Produto objeto){
        return produtoService.update(objeto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        produtoService.delete(id);
        return ResponseEntity.ok().build();
    }

}