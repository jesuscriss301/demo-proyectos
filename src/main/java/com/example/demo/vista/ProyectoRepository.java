package com.example.demo.vista;

public interface ProyectoRepository extends org.springframework.data.jpa.repository.JpaRepository<com.example.demo.modelo.Proyecto, java.lang.Integer> ,org.springframework.data.jpa.repository.JpaSpecificationExecutor<com.example.demo.modelo.Proyecto> {
}