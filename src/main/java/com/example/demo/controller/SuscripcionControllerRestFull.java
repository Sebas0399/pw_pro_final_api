package com.example.demo.controller;

import com.example.demo.mail.EmailService;
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


    @Autowired
    private EmailService correoService;
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void suscribirse(@RequestBody SuscripcionTO suscripcionTO) {
        System.out.println("Controller: "+suscripcionTO.getApellidoEstudiante());
        this.suscripcionService.suscribirse(suscripcionTO);
        
        
        //envio correo de confirmacion
        String asunto = "Confirmación de suscripción";
        String contenido = "¡Gracias por suscribirte a nuestra Asociacion!";
        correoService.enviarCorreo(suscripcionTO.getCorreoElectronico(), asunto, contenido);
        
    }
}
