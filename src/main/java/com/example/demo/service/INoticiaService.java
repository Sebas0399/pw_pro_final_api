package com.example.demo.service;

import java.util.List;

import com.example.demo.service.to.NoticiaTO;

public interface INoticiaService {
    public void create(NoticiaTO noticia);
    public NoticiaTO read(Integer id);
    public List<NoticiaTO>readAll();
}
