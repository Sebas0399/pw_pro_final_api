package com.example.demo.service;

import com.example.demo.repository.model.Suscripcion;
import com.example.demo.service.to.SuscripcionTO;

import java.util.List;

public interface ISuscripcionService {

    public Suscripcion buscarCodigo(String codigo);
    public void create(Suscripcion suscripcion);

    public Suscripcion buscarId(Integer id);

    public void update(Suscripcion suscripcion);
    public void delete(Integer id);


    public List<Suscripcion> buscarTodos();



    public List<SuscripcionTO> buscarTodosTO();
    public void suscribirse(SuscripcionTO suscripcionTO);
}
