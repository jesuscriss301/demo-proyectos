package com.example.demo.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "idfotografia")
public class Idfotografia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFoto", nullable = false)
    private Integer id;

    @Column(name = "nombreFoto", nullable = false, length = 50)
    private String nombreFoto;

    @Column(name = "direccionCarpeta", nullable = false, length = 500)
    private String direccionCarpeta;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;


}