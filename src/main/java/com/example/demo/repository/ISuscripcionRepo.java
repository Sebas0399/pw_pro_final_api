package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.model.Suscripcion;

public interface ISuscripcionRepo {

	public Suscripcion buscarCodigo(String codigo);
	public void create(Suscripcion suscripcion);
	public Suscripcion read(Integer id);
	public void update(Suscripcion suscripcion);
	public void delete(Integer id);
	
	//public void partialUpdate(String cedulaActual, String cedulaNueva);
	public List<Suscripcion> buscarTodos();
	
	
}
