package com.example.demo.repository;

import com.example.demo.repository.model.Foro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
public class ForoRepositoryImpl implements IForoRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void create(Foro foroDiscusion) {
        this.entityManager.persist(foroDiscusion);
    }

    @Override
    public void update(Foro foroDiscusion) {
        this.entityManager.merge(foroDiscusion);
    }

    @Override
    public List<Foro> readAll() {
        TypedQuery<Foro> myQuery=this.entityManager.createQuery("SELECT f FROM Foro f",Foro.class);
        return myQuery.getResultList();
    }

    @Override
    public Foro readById(Integer id) {
        return this.entityManager.find(Foro.class,id);
    }
}
