package com.example.demo.service;

import com.example.demo.repository.INoticiaRepository;
import com.example.demo.repository.model.Noticia;
import com.example.demo.service.to.NoticiaTO;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticiaServiceImpl implements INoticiaService{
    @Autowired
    private INoticiaRepository noticiaRepository;
    @Override
    public Noticia create(Noticia noticia) {

        return this.noticiaRepository.create(noticia);
    }

    @Override
    public NoticiaTO read(Integer id) {
        return convertir(this.noticiaRepository.read(id));
    }

    @Override
    public List<NoticiaTO> readAll() {

        return this.noticiaRepository.realAll().stream().map(x->convertir(x)).toList();
    }

    public NoticiaTO convertir(Noticia noticia){
        NoticiaTO noticiaTO=new NoticiaTO();
        noticiaTO.setFecha(noticia.getFecha());
        noticiaTO.setId(noticia.getId());
        noticiaTO.setImagen(noticia.getImagen());
        noticiaTO.setTexto(noticia.getTexto());
        noticiaTO.setVideo(noticia.getVideo());
        return noticiaTO;
    }
}
