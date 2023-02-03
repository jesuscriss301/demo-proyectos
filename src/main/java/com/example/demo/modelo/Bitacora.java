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
@Table(name = "bitacora")
public class Bitacora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bitacora")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_tarea")
    private Tarea idTarea;

    @Column(name = "descripcion_bitacora")
    private String descripcionBitacora;

    @ManyToOne
    @JoinColumn(name = "id_foto")
    private Idfotografia idFoto;

    @Column(name = "fecha")
    private LocalDate fecha;

}