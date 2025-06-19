package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Inventario;

public interface IInventarioRepository extends JpaRepository<Inventario, Integer> {
}
