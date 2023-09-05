package com.example.demo.repository;

import com.example.demo.repository.model.Noticia;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class NoticiaRepositoryImpl implements INoticiaRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Noticia create(Noticia noticia) {
        this.entityManager.persist(noticia);
        return noticia;
    }

    @Override
    public Noticia read(Integer id) {
        return this.entityManager.find(Noticia.class,id);
    }

    @Override
    public List<Noticia> realAll() {
        TypedQuery<Noticia>myQuery=this.entityManager.createQuery("SELECT n FROM Noticia n", Noticia.class);

        return myQuery.getResultList();
    }
}
