package com.example.demo.service.to;

import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.time.LocalDate;

public class SuscripcionTO extends RepresentationModel<SuscripcionTO> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;



    private String nombreEstudiante;

    private String apellidoEstudiante;

    private String cedulaEstudiante;


    private String correoElectronico;


    private String carrera;


    private String codigo;
    private String semestreEstudiante;


    private LocalDate fecha;


    public String getNombreEstudiante() {
        return nombreEstudiante;
    }


    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }


    public String getApellidoEstudiante() {
        return apellidoEstudiante;
    }



    public void setApellidoEstudiante(String apellidoEstudiante) {
        this.apellidoEstudiante = apellidoEstudiante;
    }


    public String getCedulaEstudiante() {
        return cedulaEstudiante;
    }


    public void setCedulaEstudiante(String cedulaEstudiante) {
        this.cedulaEstudiante = cedulaEstudiante;
    }


    public String getCorreoElectronico() {
        return correoElectronico;
    }


    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }


    public String getCarrera() {
        return carrera;
    }


    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }


    public String getCodigo() {
        return codigo;
    }


    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public LocalDate getFecha() {
        return fecha;
    }


    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }


    public String getSemestreEstudiante() {
        return semestreEstudiante;
    }


    public void setSemestreEstudiante(String semestreEstudiante) {
        this.semestreEstudiante = semestreEstudiante;
    }






}