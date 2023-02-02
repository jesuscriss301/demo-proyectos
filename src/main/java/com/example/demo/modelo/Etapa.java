package com.example.demo.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "etapa")
public class Etapa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEtapa", nullable = false)
    private Integer id;

    @Column(name = "nombreEtapa", nullable = false, length = 20)
    private String nombreEtapa;




}