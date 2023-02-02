package com.example.demo.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "bitacora")
public class Bitacora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBitacora", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idTarea", nullable = false)
    private Tarea idTarea;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idProyecto", nullable = false)
    private Proyecto idProyecto;

    @Lob
    @Column(name = "descripcionBitacora", nullable = false)
    private String descripcionBitacora;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idFoto", nullable = false)
    private Idfotografia idFoto;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;


}