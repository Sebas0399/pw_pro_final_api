package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.INoticiaRepository;
import com.example.demo.repository.model.Noticia;
import com.example.demo.service.to.NoticiaTO;

@Service
public class NoticiaServiceImpl implements INoticiaService {
	
	@Autowired
	private INoticiaRepository noticiaRepository;

	@Override

	public NoticiaTO create(NoticiaTO noticia) {
		Noticia n = this.convertirTO(noticia);
		this.noticiaRepository.create(n);
		return noticia;
	}

	@Override
	public NoticiaTO read(Integer id) {
		return convertir(this.noticiaRepository.read(id));
	}

	@Override
	public List<NoticiaTO> readAll() {

		return this.noticiaRepository.realAll().stream().map(x -> convertir(x)).toList();
	}

	private NoticiaTO convertir(Noticia noticia) {
		NoticiaTO noticiaTO = new NoticiaTO();
		noticiaTO.setFecha(noticia.getFecha());
		noticiaTO.setId(noticia.getId());
		noticiaTO.setImagen(noticia.getImagen());
		noticiaTO.setTexto(noticia.getTexto());
		noticiaTO.setVideo(noticia.getVideo());
		noticiaTO.setTitulo(noticia.getTitulo());
		noticiaTO.setAutor(noticia.getAutor());
	

		return noticiaTO;
	}

	private Noticia convertirTO(NoticiaTO noticiaTO) {
		Noticia n = new Noticia();
		n.setId(noticiaTO.getId());
		n.setFecha(noticiaTO.getFecha());
		n.setImagen(noticiaTO.getImagen());
		n.setTexto(noticiaTO.getTexto());
		n.setTitulo(noticiaTO.getTitulo());
		n.setVideo(noticiaTO.getVideo());
		n.setAutor(noticiaTO.getAutor());
		return n;
	}

}
