package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ISuscripcionRepo;
import com.example.demo.repository.model.Estudiante;
import com.example.demo.repository.model.Suscripcion;
import com.example.demo.service.to.EstudianteTO;
import com.example.demo.service.to.SuscripcionTO;

@Service
public class SuscripcionServiceImpl implements ISuscripcionService{

	@Autowired
	private ISuscripcionRepo suscripcionRepo;
	
	@Autowired
	private IEstudianteService estudianteService;
	
	@Override
	public Suscripcion buscarCodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.suscripcionRepo.buscarCodigo(codigo);
	}

	@Override
	public void create(Suscripcion suscripcion) {
		// TODO Auto-generated method stub
		this.suscripcionRepo.create(suscripcion);
	}

	@Override
	public Suscripcion buscarId(Integer id) {
		// TODO Auto-generated method stub
		return this.suscripcionRepo.read(id);
	}

	@Override
	public void update(Suscripcion suscripcion) {
		// TODO Auto-generated method stub
		this.suscripcionRepo.update(suscripcion);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.suscripcionRepo.delete(id);
	}

	

	@Override
	public List<Suscripcion> buscarTodos() {
		// TODO Auto-generated method stub
		return this.suscripcionRepo.buscarTodos();
	}

	@Override
	public List<SuscripcionTO> buscarTodosTO() {
		// TODO Auto-generated method stub
		List<Suscripcion> lista=this.suscripcionRepo.buscarTodos();

		return lista.stream().map(e->this.convertirTO(e)).collect(Collectors.toList());
	}
	
	
	private SuscripcionTO convertirTO(Suscripcion suscripcion) {
		
		SuscripcionTO suscri=new SuscripcionTO();
		suscri.setApellidoEstudiante(suscripcion.getEstudiante().getApellido());
		suscri.setCedulaEstudiante(suscripcion.getEstudiante().getCedula());
		suscri.setFecha(suscripcion.getFecha());
		suscri.setCodigo(suscripcion.getCodigo());
		suscri.setNombreEstudiante(suscripcion.getEstudiante().getNombre());
		suscri.setCorreoElectronico(suscripcion.getCodigo());
		
		return suscri;
	}

	@Override
	public void suscribirse(SuscripcionTO suscripcion) {
		// TODO Auto-generated method stub
		
		Suscripcion suscri=new Suscripcion();
		Estudiante estu;
		try {
			estu=this.estudianteService.buscarCedula(suscripcion.getCedulaEstudiante());
		} catch (Exception e) {
			// TODO: handle exception
			estu=new Estudiante();
			estu.setApellido(suscripcion.getApellidoEstudiante());
			estu.setCedula(suscripcion.getCedulaEstudiante());
			estu.setNombre(suscripcion.getNombreEstudiante());
			estu.setSemestre(suscripcion.getSemestreEstudiante());
			//this.estudianteService.create(estu);
		}
		
		suscri.setEstudiante(estu);
		suscri.setFecha(LocalDate.now());
		suscri.setCodigo(suscripcion.getCodigo());
		suscri.setCorreoElectronico(suscripcion.getCorreoElectronico());
		
		this.create(suscri);
	}
	/*
private Suscripcion convertir(SuscripcionTO suscripcion) {
		
		Suscripcion suscri=new Suscripcion();
		Estudiante estu;
		try {
			estu=this.estudianteService.buscarCedula(suscripcion.getCedulaEstudiante());
		} catch (Exception e) {
			// TODO: handle exception
			estu=new Estudiante();
			estu.setApellido(suscripcion.getApellidoEstudiante());
			estu.setCedula(suscripcion.getCedulaEstudiante());
			estu.setNombre(suscripcion.getNombreEstudiante());
			//this.estudianteService.create(estu);
		}
		
		suscri.setEstudiante(estu);
		suscri.setFecha(suscripcion.getFecha());
		suscri.setCodigo(suscripcion.getCodigo());
		suscri.setCarrera(suscripcion.getCarrera());
		suscri.setCorreoElectronico(suscripcion.getCorreoElectronico());
		
		return suscri;
	}*/
	
 
}
