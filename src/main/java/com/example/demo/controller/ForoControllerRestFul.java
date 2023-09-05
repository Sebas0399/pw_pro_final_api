package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IForoService;
import com.example.demo.service.to.ForoTO;

@RestController
@RequestMapping("/foros")
@CrossOrigin
public class ForoControllerRestFul {

	@Autowired
	private IForoService foroService;

	@GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ForoTO> obtenerForo(@PathVariable Integer id) {
		var foro = this.foroService.readById(id);
		if (foro != null) {
			return new ResponseEntity<>(foro, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ForoTO> postear(@RequestBody ForoTO foro) {
		try {
			ForoTO nuevoForo = this.foroService.create(foro);
			return new ResponseEntity<>(nuevoForo, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ForoTO> actualizar(@RequestBody ForoTO foro) {
		try {
			ForoTO nuevoForo = this.foroService.update(foro);
			return new ResponseEntity<>(nuevoForo, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ForoTO>> obtenerTodos() {
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

}
