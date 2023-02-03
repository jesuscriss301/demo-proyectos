package com.example.demo.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
@Table(name = "proyecto")
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name = "nombreProyecto")
    private String nombreProyecto;

    @Column(name = "descripcionProyecto")
    private String descripcionProyecto;

    @Column(name = "responsable")
    private String responsable;

    @Column(name = "areaTerreno")
    private Integer areaTerreno;

    @ManyToOne
    @JoinColumn(name = "diseño")
    private Diseño diseno;

    @ManyToOne
    @JoinColumn(name = "presupuesto")
    private Presupuesto presupuesto;



}