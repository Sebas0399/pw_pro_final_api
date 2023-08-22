package com.example.demo.service;

import com.example.demo.repository.IForoRepository;
import com.example.demo.repository.model.Foro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ForoServiceImpl implements IForoService{
    @Autowired
    private IForoRepository foroRepository;
    @Override
    public void create(Foro foroDiscusion) {
        this.foroRepository.create(foroDiscusion);
    }

    @Override
    public void update(Foro foroDiscusion) {
        this.foroRepository.update(foroDiscusion);
    }

    @Override
    public List<Foro> readAll() {
        return this.foroRepository.readAll();
    }

    @Override
    public Foro readById(Integer id) {
        return this.foroRepository.readById(id);
    }
}
