package com.example.demo.modelo;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "`diseño`")
public class Diseño {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`idDiseño`", nullable = false)
    private Integer id;

    @Column(name = "`nombreDicseño`", nullable = false, length = 20)
    private String nombreDicseño;

    @Column(name = "direccionCarpeta", nullable = false, length = 500)
    private String direccionCarpeta;

    @Column(name = "`fechaDiceño`", nullable = false)
    private LocalDate fechaDiceño;

    @Column(name = "aprovado", nullable = false)
    private Boolean aprovado = false;

    @OneToMany(mappedBy = "diseño")
    private Set<Proyecto> proyectos = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreDicseño() {
        return nombreDicseño;
    }

    public void setNombreDicseño(String nombreDicseño) {
        this.nombreDicseño = nombreDicseño;
    }

    public String getDireccionCarpeta() {
        return direccionCarpeta;
    }

    public void setDireccionCarpeta(String direccionCarpeta) {
        this.direccionCarpeta = direccionCarpeta;
    }

    public LocalDate getFechaDiceño() {
        return fechaDiceño;
    }

    public void setFechaDiceño(LocalDate fechaDiceño) {
        this.fechaDiceño = fechaDiceño;
    }

    public Boolean getAprovado() {
        return aprovado;
    }

    public void setAprovado(Boolean aprovado) {
        this.aprovado = aprovado;
    }

    public Set<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(Set<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

}