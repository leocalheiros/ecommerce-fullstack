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

import com.calheiros.backend.entity.Pessoa;
import com.calheiros.backend.service.PessoaService;

@RestController
@RequestMapping("/api/pessoa")
@CrossOrigin
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService pessoaService;

    @GetMapping("/")
    public List<Pessoa> findAll(){
        return pessoaService.findAll();
    }

    @PostMapping("/")
    public Pessoa insert(@RequestBody Pessoa objeto){
        return pessoaService.insert(objeto);
    }

    @PutMapping("/")
    public Pessoa update(@RequestBody Pessoa objeto){
        return pessoaService.update(objeto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        pessoaService.delete(id);
        return ResponseEntity.ok().build();
    }

}