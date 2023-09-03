package com.example.demo.repository;

import com.example.demo.repository.model.Queja;

import java.util.List;

public interface IQuejaRepository {


    public void insertar(Queja formulario);

    public List<Queja> buscarTodos();

    public Queja buscarID(Integer id);
}