package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.models.Inventario;
import com.example.demo.repositories.ICategoriaRepository;
import com.example.demo.repositories.IInventarioRepository;
import com.example.demo.repositories.IProductoRepository;

@Controller
@RequestMapping("/inventarios")
public class InventarioController {

	@Autowired
	private IInventarioRepository inventarioRepo;

	@Autowired
	private IProductoRepository productoRepo;

	@Autowired
	private ICategoriaRepository categoriaRepo;

	
	@GetMapping("/listado")
	public String listado(Model model) {
		List<Inventario> lista = inventarioRepo.findAll().stream()
				.sorted((a, b) -> b.getNumero().compareTo(a.getNumero())).collect(Collectors.toList());

		model.addAttribute("lista", lista);
		return "inventarios/listadoPrimerApellido";
	}

	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		model.addAttribute("inventario", new Inventario());
		model.addAttribute("productos", productoRepo.findAll());
		model.addAttribute("categorias", categoriaRepo.findAll()); 
		return "inventarios/nuevoPrimerApellido";
	}

	@GetMapping("/editar/{id}")
	public String editarInventario(@PathVariable("id") Integer id, Model model) {
		Optional<Inventario> opt = inventarioRepo.findById(id);
		if (opt.isEmpty()) {
			return "redirect:/inventarios/listado"; 
		}

		model.addAttribute("inventario", opt.get());
		model.addAttribute("productos", productoRepo.findAll());
		model.addAttribute("categorias", categoriaRepo.findAll());
		return "inventarios/edicionPrimerApellido";
	}

	@PostMapping("/guardar")
	public String guardar(@ModelAttribute("inventario") Inventario inv, RedirectAttributes redirect) {
		boolean esNuevo = (inv.getNumero() == null);
		Inventario saved = inventarioRepo.save(inv);

		String mensaje = esNuevo ? "Inventario Nro. " + saved.getNumero() + " registrado."
				: "Inventario Nro. " + saved.getNumero() + " actualizado.";

		redirect.addFlashAttribute("alert", "<script>Swal.fire('Éxito', '" + mensaje + "', 'success');</script>");
		return "redirect:/inventarios/listado";
	}
}
