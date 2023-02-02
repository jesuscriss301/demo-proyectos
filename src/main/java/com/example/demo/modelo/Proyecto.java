package com.example.demo.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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


}