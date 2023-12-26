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

import com.calheiros.backend.entity.Marca;
import com.calheiros.backend.service.MarcaService;

@RestController
@RequestMapping("/api/marca")
@CrossOrigin
@RequiredArgsConstructor
public class MarcaController {

    private final MarcaService marcaService;

    @GetMapping("/")
    public List<Marca> findAll(){
        return marcaService.findAll();
    }

    @PostMapping("/")
    public Marca insert(@RequestBody Marca objeto){
        return marcaService.insert(objeto);
    }

    @PutMapping("/")
    public Marca update(@RequestBody Marca objeto){
        return marcaService.update(objeto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        marcaService.delete(id);
        return ResponseEntity.ok().build();
    }

}