package com.calheiros.backend.controller;

import com.calheiros.backend.entity.Estado;
import com.calheiros.backend.service.EstadoService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estado")
@RequiredArgsConstructor
public class EstadoController {

    private final EstadoService estadoService;

    @GetMapping("/")
    public List<Estado> findAll(){
        return estadoService.findAll();
    }

    @PostMapping("/")
    public Estado insert(@RequestBody Estado estado){
        return estadoService.insert(estado);
    }

    @PutMapping("/")
    public Estado update(@RequestBody Estado estado){
        return estadoService.update(estado);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        estadoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
