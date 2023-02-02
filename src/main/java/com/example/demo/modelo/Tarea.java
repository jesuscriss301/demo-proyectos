package com.example.demo.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "tarea")
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTarea", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idProyecto", nullable = false)
    private Proyecto idProyecto;

    @Column(name = "nombreTarea", nullable = false, length = 30)
    private String nombreTarea;

    @Lob
    @Column(name = "descripcionTarea", nullable = false)
    private String descripcionTarea;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idEtapa", nullable = false)
    private Etapa idEtapa;

    @Column(name = "completado", nullable = false)
    private Boolean completado = false;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;


}