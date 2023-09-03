package com.example.demo.repository.model;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "suscripcion")
public class Suscripcion {

    @Id
    @Column(name ="susc_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "susc_id_seq")
    @SequenceGenerator(name = "susc_id_seq", sequenceName = "susc_id_seq", allocationSize = 1)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    private Estudiante estudiante;

    @Column(name ="susc_correo_electronico")
    private String correoElectronico;



    @Column(name ="susc_codigo")
    private String codigo;

    @Column(name = "susc_fecha")
    private LocalDate fecha;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
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






}
