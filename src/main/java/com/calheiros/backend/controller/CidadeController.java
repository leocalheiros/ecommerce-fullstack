package com.calheiros.backend.controller;

import com.calheiros.backend.entity.Cidade;
import com.calheiros.backend.entity.Estado;
import com.calheiros.backend.service.CidadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cidade")
@RequiredArgsConstructor
public class CidadeController {
    private final CidadeService cidadeService;

    @GetMapping("/")
    public List<Cidade> findAll(){
        return cidadeService.findAll();
    }

    @PostMapping("/")
    public Cidade insert(@RequestBody Cidade cidade){
        return cidadeService.insert(cidade);
    }

    @PutMapping("/")
    public Cidade update(@RequestBody Cidade cidade){
        return cidadeService.update(cidade);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        cidadeService.delete(id);
        return ResponseEntity.ok().build();
    }
}

