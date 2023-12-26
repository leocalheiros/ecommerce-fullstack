package com.calheiros.backend.controller;

import com.calheiros.backend.entity.Categoria;
import com.calheiros.backend.entity.ProdutoImagens;
import com.calheiros.backend.service.CategoriaService;
import com.calheiros.backend.service.ProdutoImagensService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/produtoimagens")
@CrossOrigin
@RequiredArgsConstructor
public class ProdutoImagensController {

    private final ProdutoImagensService produtoImagensService;

    @GetMapping("/")
    public List<ProdutoImagens> findAll(){
        return produtoImagensService.findAll();
    }

    @PostMapping("/")
    public ProdutoImagens insert(@RequestParam("idProduto") Long idProduto, @RequestParam MultipartFile file){
        return produtoImagensService.insert(idProduto, file);
    }

    @PutMapping("/")
    public ProdutoImagens alterar(@RequestBody ProdutoImagens objeto){
        return produtoImagensService.update(objeto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        produtoImagensService.delete(id);
        return ResponseEntity.ok().build();
    }

}