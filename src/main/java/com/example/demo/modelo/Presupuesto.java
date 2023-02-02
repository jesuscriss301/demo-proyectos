package com.example.demo.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "presupuesto")
public class Presupuesto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProyecto", nullable = false)
    private Integer id;

    @Column(name = "cotizacion", nullable = false)
    private Integer cotizacion;

    @Lob
    @Column(name = "personal", nullable = false)
    private String personal;

    @Lob
    @Column(name = "material", nullable = false)
    private String material;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;


}