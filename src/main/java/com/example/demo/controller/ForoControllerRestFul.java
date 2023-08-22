package com.example.demo.controller;

import com.example.demo.repository.model.Foro;
import com.example.demo.repository.model.Noticia;
import com.example.demo.service.IForoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foros")
@CrossOrigin
public class ForoControllerRestFul {
    @Autowired
    private IForoService foroService;
    @GetMapping
    public List<Foro> obtenerTodos(){
        return this.foroService.readAll();
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Foro> obtenerForo(@PathVariable Integer id){
        var foro=this.foroService.readById(id);
        return new ResponseEntity<>(foro,null,200);
    }
    @PostMapping
    public ResponseEntity<Foro> postear(@RequestBody Foro foro){
        this.foroService.create(foro);
        return new ResponseEntity<>(foro,null,200);
    }

    @PutMapping
    public ResponseEntity<Foro> actualizar(@RequestBody Foro foro){
        this.foroService.update(foro);
        return new ResponseEntity<>(foro,null,200);
    }
}
