package com.example.demo.controller;

import com.example.demo.repository.model.Queja;
import com.example.demo.service.IQuejaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quejas")
@CrossOrigin
public class QuejaControllerRestFul {


    @Autowired
    private IQuejaService quejaService;

    @GetMapping
    public List<Queja> obtenerTodos(){
        return this.quejaService.buscarTodos();
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Queja> obtenerQueja(@PathVariable Integer id){
        var formulario = this.quejaService.buscarID(id);
        return new ResponseEntity<>(formulario, null,200);
    }
    @PostMapping
    public ResponseEntity<Queja> postear(@RequestBody Queja queja){
        this.quejaService.insertar(queja);
        return new ResponseEntity<>(queja,null,200);
    }
}