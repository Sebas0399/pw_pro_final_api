package com.example.demo.service;

import com.example.demo.repository.IQuejaRepository;
import com.example.demo.repository.model.Queja;
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
    public List<Queja> buscarTodos() {
        return this.quejaRepository.buscarTodos();
    }

    @Override
    public Queja buscarID(Integer id) {
        return this.quejaRepository.buscarID(id);
    }

}