package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_categoria")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String descripcion;

	@Column(name = "frecuencia_compra", length = 1)
	private char frecuenciaCompra; // A, M, B, O
}
