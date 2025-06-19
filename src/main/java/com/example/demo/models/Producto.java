package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_producto")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nombre;

	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;

	@Column(name = "stock_maximo")
	private int stockMaximo;

	@Column(name = "stock_actual")
	private int stockActual;
}
