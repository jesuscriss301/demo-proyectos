package com.example.demo.vista;

import com.example.demo.modelo.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<Tarea, Integer> {
}