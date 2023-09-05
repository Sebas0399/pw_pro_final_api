package com.example.demo.service;

import com.example.demo.repository.IQuejaRepository;
import com.example.demo.repository.model.Queja;
import com.example.demo.service.to.QuejaTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuejaServiceImpl implements IQuejaService{

    @Autowired
    private IQuejaRepository quejaRepository;

    @Override
    public void insertar(Queja formulario) {
        this.quejaRepository.insertar(formulario);
    }

    @Override
    public List<QuejaTO> buscarTodos() {
        return this.quejaRepository.buscarTodos().stream().map(x->convertir(x)).toList();
    }

    @Override
    public QuejaTO buscarID(Integer id) {
        return convertir(this.quejaRepository.buscarID(id));
    }
    public QuejaTO convertir(Queja queja) {
    	QuejaTO quejato= new QuejaTO();
    	quejato.setCorreo(queja.getCorreo());
    	quejato.setDescripcion(queja.getDescripcion());
    	quejato.setId(queja.getId());
    	quejato.setNombre(queja.getNombre());
    	return quejato;
    	
    }

}