package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Producto;

public interface IProductoRepository extends JpaRepository<Producto, Integer> {
	// No necesitas escribir métodos personalizados si solo usas findAll()
}
