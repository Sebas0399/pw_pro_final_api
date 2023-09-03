package com.example.demo.repository.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "estudiante")
public class Estudiante {

    @Id
    @Column(name ="estu_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estu_id_seq")
    @SequenceGenerator(name = "estu_id_seq", sequenceName = "estu_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "estu_nombre")
    private String nombre;

    @Column(name = "estu_apellido")
    private String apellido;

    @Column(name = "estu_cedula")
    private String cedula;

    @Column(name = "estu_provincia")
    private String provincia;

    @Column(name = "estu_fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name ="estu_semestre")
    private String semestre;

    @OneToOne(mappedBy = "estudiante")
    @JoinColumn(name = "estu_fk_suscr_id")
    private Suscripcion suscripcion;

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }


    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Suscripcion getSuscripcion() {
        return suscripcion;
    }

    public void setSuscripcion(Suscripcion suscripcion) {
        this.suscripcion = suscripcion;
    }



}