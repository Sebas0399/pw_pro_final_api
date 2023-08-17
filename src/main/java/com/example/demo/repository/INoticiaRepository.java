package com.example.demo.repository;

import com.example.demo.repository.model.Noticia;

import java.util.List;

public interface INoticiaRepository {
    public void create(Noticia noticia);
    public Noticia read(Integer id);
    public List<Noticia>realAll();
}
