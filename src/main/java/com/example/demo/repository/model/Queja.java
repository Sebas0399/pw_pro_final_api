package com.example.demo.repository.model;

import jakarta.persistence.*;

@Entity
@Table(name = "formulario")
public class Queja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "form_id", nullable = false)
    private Integer id;

    @Column(name = "form_nombre")
    private String nombre;

    @Column(name = "form_correo")
    private String correo;

    @Column(name = "form_descripcion")
    private String descripcion;

    //GET & SET

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }






}