package com.example.demo.vista;

import com.example.demo.modelo.Presupuesto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PresupuestoRepository extends JpaRepository<Presupuesto, Integer> {
}