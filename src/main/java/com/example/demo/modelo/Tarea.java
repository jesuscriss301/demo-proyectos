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
@Table(name = "tarea")
public class Tarea {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Tarea")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_Proyecto")
    private Proyecto idProyecto;

    @Column(name = "nombreTarea")
    private String nombreTarea;

    @Lob
    @Column(name = "descripcionTarea")
    private String descripcionTarea;

    @OneToOne
    @JoinColumn(name = "id_etapa")
    private Etapa idEtapa;

    @Column(name = "completado")
    private Boolean completado;

    @Column(name = "fecha")
    private LocalDate fecha;

}