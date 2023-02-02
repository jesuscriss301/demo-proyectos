package com.example.demo.modelo;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "bitacora")
public class Bitacora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBitacora", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idProyecto", nullable = false)
    private Proyecto idProyecto;

    @Lob
    @Column(name = "descripcionBitacora", nullable = false)
    private String descripcionBitacora;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idFoto", nullable = false)
    private Idfotografia idFoto;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Proyecto getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Proyecto idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getDescripcionBitacora() {
        return descripcionBitacora;
    }

    public void setDescripcionBitacora(String descripcionBitacora) {
        this.descripcionBitacora = descripcionBitacora;
    }

    public Idfotografia getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(Idfotografia idFoto) {
        this.idFoto = idFoto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

}