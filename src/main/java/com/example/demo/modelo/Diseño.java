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
    @SequenceGenerator(name="diseño_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="diseño_id_seq")
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