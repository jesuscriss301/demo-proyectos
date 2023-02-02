package com.example.demo.modelo;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "idfotografia")
public class Idfotografia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFoto", nullable = false)
    private Integer id;

    @Column(name = "nombreFoto", nullable = false)
    private Integer nombreFoto;

    @Column(name = "direccionCarpeta", nullable = false, length = 500)
    private String direccionCarpeta;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @OneToMany(mappedBy = "idFoto")
    private Set<Bitacora> bitacoras = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNombreFoto() {
        return nombreFoto;
    }

    public void setNombreFoto(Integer nombreFoto) {
        this.nombreFoto = nombreFoto;
    }

    public String getDireccionCarpeta() {
        return direccionCarpeta;
    }

    public void setDireccionCarpeta(String direccionCarpeta) {
        this.direccionCarpeta = direccionCarpeta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Set<Bitacora> getBitacoras() {
        return bitacoras;
    }

    public void setBitacoras(Set<Bitacora> bitacoras) {
        this.bitacoras = bitacoras;
    }

}