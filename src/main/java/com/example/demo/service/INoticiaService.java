package com.example.demo.service;

import com.example.demo.repository.model.Noticia;
import com.example.demo.service.to.NoticiaTO;
import org.aspectj.weaver.ast.Not;

import java.util.List;

public interface INoticiaService {
    public Noticia create(Noticia noticia);
    public NoticiaTO read(Integer id);
    public List<NoticiaTO>readAll();
}
