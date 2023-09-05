package com.example.demo.service;

import java.util.List;

import com.example.demo.service.to.ForoTO;

public interface IForoService {
    public void create(ForoTO foroDiscusion);
    public void update(ForoTO foroDiscusion);
    public List<ForoTO> readAll();
    public ForoTO readById(Integer id);
}
