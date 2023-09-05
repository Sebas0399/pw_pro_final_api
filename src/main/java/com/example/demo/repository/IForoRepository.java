package com.example.demo.repository;

import com.example.demo.repository.model.Foro;

import java.util.List;

public interface IForoRepository {
    public Foro create(Foro foroDiscusion);
    public void update(Foro foroDiscusion);
    public List<Foro> readAll();
    public Foro readById(Integer id);
}
