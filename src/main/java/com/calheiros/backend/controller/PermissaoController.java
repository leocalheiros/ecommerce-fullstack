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

import com.calheiros.backend.entity.Permissao;
import com.calheiros.backend.service.PermissaoService;

@RestController
@RequestMapping("/api/permissao")
@CrossOrigin
@RequiredArgsConstructor
public class PermissaoController {

    private final PermissaoService permissaoService;

    @GetMapping("/")
    public List<Permissao> findAll(){
        return permissaoService.findAll();
    }

    @PostMapping("/")
    public Permissao insert(@RequestBody Permissao objeto){
        return permissaoService.insert(objeto);
    }

    @PutMapping("/")
    public Permissao update(@RequestBody Permissao objeto){
        return permissaoService.update(objeto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        permissaoService.delete(id);
        return ResponseEntity.ok().build();
    }

}