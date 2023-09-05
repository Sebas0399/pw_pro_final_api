package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.model.Foro;
import com.example.demo.service.IForoService;
import com.example.demo.service.to.ForoTO;

@RestController
@RequestMapping("/foros")
@CrossOrigin
public class ForoControllerRestFul {
    @Autowired
    private IForoService foroService;
    @GetMapping
    public List<ForoTO> obtenerTodos(){
        return this.foroService.readAll();
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<ForoTO> obtenerForo(@PathVariable Integer id){
        var foro=this.foroService.readById(id);
        return new ResponseEntity<>(foro,null,200);
    }
    @PostMapping
    public ResponseEntity<ForoTO> postear(@RequestBody ForoTO foro){
        this.foroService.create(foro);
        return new ResponseEntity<>(foro,null,200);
    }

    @PutMapping
    public ResponseEntity<ForoTO> actualizar(@RequestBody ForoTO foro){
        this.foroService.update(foro);
        return new ResponseEntity<>(foro,null,200);
    }
}
