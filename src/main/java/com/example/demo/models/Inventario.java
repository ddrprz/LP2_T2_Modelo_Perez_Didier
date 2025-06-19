package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_inventario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numero;

	@Column(name = "fecha_vencimiento")
	private LocalDate fechaVencimiento;

	@ManyToOne
	@JoinColumn(name = "id_producto")
	private Producto producto;

	@Column(name = "costo_ingreso")
	private BigDecimal costoIngreso;

	private int cantidad;

	private String lote;

	@Column(name = "cod_estado", length = 1)
	private Character codEstado; // A, V, T, B
}
