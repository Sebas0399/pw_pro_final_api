package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IForoRepository;
import com.example.demo.repository.model.Foro;
import com.example.demo.service.to.ForoTO;
@Service
public class ForoServiceImpl implements IForoService{
	
    @Autowired
    private IForoRepository foroRepository;
    
    @Override
    public ForoTO create(ForoTO foroDiscusion) {
        Foro a=this.convertir(foroDiscusion);
        this.foroRepository.create(a);
        return foroDiscusion;
    }

    @Override
    public ForoTO update(ForoTO foroDiscusion) {
    	Foro a=this.convertir(foroDiscusion);
        this.foroRepository.update(a);
        return foroDiscusion;
    }

    @Override
    public List<ForoTO> readAll() {
    	List<Foro> a=this.foroRepository.readAll();
        return a.stream().map(e->this.convertirTO(e)).collect(Collectors.toList());
    }

    @Override
    public ForoTO readById(Integer id) {
    	Foro a=this.foroRepository.readById(id);
        return this.convertirTO(a);
    }
    
    private ForoTO convertirTO(Foro foro) {
    	ForoTO foroto=new ForoTO();
    	foroto.setId(foro.getId());
    	foroto.setComentarios(foro.getComentarios());
    	foroto.setTema(foro.getTema());
    	return foroto;
    }
    
    private Foro convertir(ForoTO foroto) {
    	Foro foro=new Foro();
    	foro.setId(foroto.getId());
    	foro.setTema(foroto.getTema());
    	foro.setComentarios(foroto.getComentarios());
    	return foro;
    }
}
