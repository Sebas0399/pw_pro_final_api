package com.example.demo.controller;

import com.example.demo.repository.model.Foro;
import com.example.demo.repository.model.Noticia;
import com.example.demo.service.IForoService;
import com.example.demo.service.to.NoticiaTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    public ResponseEntity<List<Foro>> obtenerTodos(){
        try {
            var foros = this.foroService.readAll();
            if (!foros.isEmpty()) {
                return new ResponseEntity<>(foros, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Foro> obtenerForo(@PathVariable Integer id) {
        var foro = this.foroService.readById(id);
        if (foro != null) {
            return new ResponseEntity<>(foro, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Foro> postear(@RequestBody Foro foro) {
        try {
            Foro nuevoForo = this.foroService.create(foro);
            return new ResponseEntity<>(nuevoForo, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }




}
