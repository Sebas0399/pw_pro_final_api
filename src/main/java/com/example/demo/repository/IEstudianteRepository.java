package com.example.demo.repository;

import com.example.demo.repository.model.Estudiante;

import java.util.List;

public interface IEstudianteRepository {

    public Estudiante buscarCedula(String cedula);
    public void create(Estudiante suscripcion);
    public Estudiante read(Integer id);
    public void update(Estudiante suscripcion);
    public void delete(Integer id);

    public void partialUpdate(String cedulaActual, String cedulaNueva);
    public List<Estudiante> buscarTodos();

    public List<Estudiante> buscarProvincia(String provincia);
}
