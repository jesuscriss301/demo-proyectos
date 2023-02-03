package com.example.demo.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Data
@Table(name = "diseño")
public class Diseño {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name = "nombreDiseño")
    private String nombreDiseño;

    @Column(name = "direccionCarpeta")
    private String direccionCarpeta;

    @Column(name = "fechaDiseño")
    private LocalDate fechaDiseño;

    @Column(name = "aprovado")
    private Boolean aprovado = false;


}