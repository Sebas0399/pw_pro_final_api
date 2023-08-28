package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ISuscripcionService;
import com.example.demo.service.to.SuscripcionTO;

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
