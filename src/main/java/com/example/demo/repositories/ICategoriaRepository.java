package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Categoria;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {
	// Nada adicional si solo usarás findAll()
}
