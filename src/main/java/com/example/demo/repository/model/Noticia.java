package com.example.demo.repository.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "noticia")
public class Noticia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "noti_id", nullable = false)
    private Integer id;

    @Column(name = "noti_texto", length = 10000)
    private String texto;
    
    @Column(name = "noti_titulo", length = 5000)
    private String titulo;

    @Column(name = "noti_resumen", length = 8000)
    private String resumen;
    
    @Column(name = "noti_video")
    private String video;

    @Column(name = "noti_imagen")
    private String imagen;

    @Column(name = "noti_fecha")
    private LocalDateTime fecha;

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
