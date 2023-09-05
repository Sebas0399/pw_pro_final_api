package com.example.demo.service;

import com.example.demo.repository.model.Queja;
import com.example.demo.service.to.QuejaTO;

import java.util.List;

public interface IQuejaService {
    public void insertar(Queja formulario);

    public List<QuejaTO> buscarTodos();

    public QuejaTO buscarID(Integer id);
}
