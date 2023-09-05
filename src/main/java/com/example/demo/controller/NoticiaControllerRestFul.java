package com.example.demo.controller;

import com.example.demo.repository.model.Noticia;
import com.example.demo.service.INoticiaService;
import com.example.demo.service.to.NoticiaTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Noticia> postear(@RequestBody Noticia noticia) {
        try {
            Noticia nuevaNoticia = this.noticiaService.create(noticia);
            return new ResponseEntity<>(nuevaNoticia, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<NoticiaTO>> leerTodas() {
        try {
            var noticias = this.noticiaService.readAll();
            if (!noticias.isEmpty()) {
                return new ResponseEntity<>(noticias, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
