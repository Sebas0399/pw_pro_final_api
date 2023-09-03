package com.example.demo.controller;

import com.example.demo.service.ISuscripcionService;
import com.example.demo.service.to.SuscripcionTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/suscripciones")
@CrossOrigin
public class SuscripcionControllerRestFull {

    @Autowired
    ISuscripcionService suscripcionService;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void suscribirse(@RequestBody SuscripcionTO suscripcionTO) {
        System.out.println("Controller: "+suscripcionTO.getApellidoEstudiante());
        this.suscripcionService.suscribirse(suscripcionTO);
    }
}
