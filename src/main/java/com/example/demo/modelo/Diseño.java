package com.example.demo.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "`diseño`")
public class Diseño {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`idDiseño`", nullable = false)
    private Integer id;

    @Column(name = "`nombreDiseño`", nullable = false, length = 50)
    private String nombreDiseño;

    @Column(name = "direccionCarpeta", nullable = false, length = 500)
    private String direccionCarpeta;

    @Column(name = "`fechaDiseño`", nullable = false)
    private LocalDate fechaDiseño;

    @Column(name = "aprovado", nullable = false)
    private Boolean aprovado = false;

}