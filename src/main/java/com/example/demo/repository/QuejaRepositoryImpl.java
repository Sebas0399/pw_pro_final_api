package com.example.demo.repository;


import com.example.demo.repository.model.Queja;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class QuejaRepositoryImpl implements IQuejaRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertar(Queja formulario) {
        this.entityManager.persist(formulario);

    }

    @Override
    public List<Queja> buscarTodos() {
        TypedQuery<Queja> myQuery=this.entityManager.createQuery("SELECT q FROM Queja q", Queja.class);
        return myQuery.getResultList();
    }

    @Override
    public Queja buscarID(Integer id) {
        return this.entityManager.find(Queja.class, id);
    }

}
