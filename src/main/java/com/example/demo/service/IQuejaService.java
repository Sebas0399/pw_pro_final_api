package com.example.demo.service;

import com.example.demo.repository.model.Queja;

import java.util.List;

public interface IQuejaService {
    public void insertar(Queja formulario);

    public List<Queja> buscarTodos();

    public Queja buscarID(Integer id);
}
