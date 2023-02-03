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
@Table(name = "presupuesto")
public class Presupuesto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_presupuesto")
    private Integer id;

    @Column(name = "cotizacion")
    private Integer cotizacion;

    @Column(name = "personal")
    private String personal;

    @Column(name = "material")
    private String material;

    @Column(name = "fecha")
    private LocalDate fecha;

}