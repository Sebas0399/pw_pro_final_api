package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.repository.model.Suscripcion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
public class SuscripcionRepoImpl  implements ISuscripcionRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Suscripcion buscarCodigo(String codigo) {
		// TODO Auto-generated method stub
		TypedQuery<Suscripcion> myQuery=this.entityManager.createQuery("Select s from Suscripcion s where s.codigo=:valor",Suscripcion.class);
		myQuery.setParameter("valor", codigo);
		return myQuery.getSingleResult();
	}

	@Override
	public void create(Suscripcion suscripcion) {
		// TODO Auto-generated method stub
		this.entityManager.persist(suscripcion);
	}

	@Override
	public Suscripcion read(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Suscripcion.class, id);
	}

	@Override
	public void update(Suscripcion suscripcion) {
		// TODO Auto-generated method stub
		this.entityManager.merge(suscripcion);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.read(id));
	}

	
	@Override
	public List<Suscripcion> buscarTodos() {
		TypedQuery<Suscripcion> myQuery=this.entityManager.createQuery("Select e from Suscripcion e", Suscripcion.class);
		
		return myQuery.getResultList();
	}

	
	

}
