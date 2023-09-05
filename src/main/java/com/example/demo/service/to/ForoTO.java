package com.example.demo.service.to;

import java.io.Serializable;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;

public class ForoTO extends RepresentationModel<ForoTO> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
    private String tema;
    
    private String autor;

    private List<String> comentarios;

    //GET AND SET
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public List<String> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<String> comentarios) {
		this.comentarios = comentarios;
	}
    
}
