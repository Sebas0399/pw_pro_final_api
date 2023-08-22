package com.example.demo.service;

import com.example.demo.repository.model.Foro;

import java.util.List;

public interface IForoService {
    public void create(Foro foroDiscusion);
    public void update(Foro foroDiscusion);
    public List<Foro> readAll();
    public Foro readById(Integer id);
}
