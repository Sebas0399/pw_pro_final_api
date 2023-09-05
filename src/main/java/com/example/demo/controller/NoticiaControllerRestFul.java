package com.example.demo.controller;

import com.example.demo.repository.model.Noticia;
import com.example.demo.service.INoticiaService;
import com.example.demo.service.to.NoticiaTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/noticias")
@CrossOrigin
public class NoticiaControllerRestFul {
    @Autowired
    private INoticiaService noticiaService;
    @PostMapping
    public ResponseEntity<NoticiaTO> postear(@RequestBody NoticiaTO noticia){
        this.noticiaService.create(noticia);
        return new ResponseEntity<>(noticia,null,200);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<NoticiaTO>>leerTodas(){
        var noticias=this.noticiaService.readAll();
        return new ResponseEntity<>(noticias,null,200);
    }



}
