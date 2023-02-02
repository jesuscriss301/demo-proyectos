package com.example.demo.modelo;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "proyecto")
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProyecto", nullable = false)
    private Integer id;

    @Column(name = "nombreProyecto", nullable = false, length = 30)
    private String nombreProyecto;

    @Lob
    @Column(name = "descripcionProyecto", nullable = false)
    private String descripcionProyecto;

    @Column(name = "responsable", nullable = false, length = 30)
    private String responsable;

    @Column(name = "areaTerreno", nullable = false)
    private Integer areaTerreno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`diseño`")
    private Diseño diseño;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "presupuesto")
    private Presupuesto presupuesto;

    @OneToMany(mappedBy = "idProyecto")
    private Set<Bitacora> bitacoras = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idProyecto")
    private Set<Tarea> tareas = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getDescripcionProyecto() {
        return descripcionProyecto;
    }

    public void setDescripcionProyecto(String descripcionProyecto) {
        this.descripcionProyecto = descripcionProyecto;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public Integer getAreaTerreno() {
        return areaTerreno;
    }

    public void setAreaTerreno(Integer areaTerreno) {
        this.areaTerreno = areaTerreno;
    }

    public Diseño getDiseño() {
        return diseño;
    }

    public void setDiseño(Diseño diseño) {
        this.diseño = diseño;
    }

    public Presupuesto getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Presupuesto presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Set<Bitacora> getBitacoras() {
        return bitacoras;
    }

    public void setBitacoras(Set<Bitacora> bitacoras) {
        this.bitacoras = bitacoras;
    }

    public Set<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(Set<Tarea> tareas) {
        this.tareas = tareas;
    }

}