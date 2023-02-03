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
@Table(name = "idfotografia")
public class Idfotografia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_foto")
    private Integer id;

    @Column(name = "nombreFoto")
    private String nombreFoto;

    @Column(name = "direccionCarpeta")
    private String direccionCarpeta;

    @Column(name = "fecha")
    private LocalDate fecha;

}