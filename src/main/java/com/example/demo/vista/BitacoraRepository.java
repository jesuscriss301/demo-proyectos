package com.example.demo.vista;

import com.example.demo.modelo.Bitacora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BitacoraRepository extends JpaRepository<Bitacora, Integer> {
}