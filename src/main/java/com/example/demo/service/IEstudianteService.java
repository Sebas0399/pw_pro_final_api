package com.example.demo.service;

import com.example.demo.repository.model.Estudiante;
import com.example.demo.service.to.EstudianteTO;

import java.util.List;

public interface IEstudianteService {

    public Estudiante buscarCedula(String cedula);
    public void create(Estudiante estudiante);

    public Estudiante buscarId(Integer id);

    public void update(Estudiante estudiante);
    public void delete(Integer id);

    public void partialUpdate(String cedulaActual, String cedulaNueva);
    public List<Estudiante> buscarTodos();

    public List<Estudiante> buscarProvincia(String provincia);

    public List<EstudianteTO> buscarTodosTO();
}
