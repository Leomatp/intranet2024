package com.Intranet_2024.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Intranet_2024.model.Profesor;
import com.Intranet_2024.servicesImpl.ProfesorServices;
import com.Intranet_2024.utils.NotFoundException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/profesor")
public class ProfesorController {

	@Autowired
	private ProfesorServices servicioProfesor;

	@GetMapping("/lista")
	public ResponseEntity<List<Profesor>> lista() {
		return new ResponseEntity<>(servicioProfesor.listarTodos(), HttpStatus.OK);

	}

	@PostMapping("/registrar")
	public ResponseEntity<Profesor> registrar(@RequestBody Profesor bean) {
		Profesor obj = servicioProfesor.registrar(bean);
		return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}

	@PutMapping("/actualizar")
	public ResponseEntity<Profesor> actualizar(@RequestBody Profesor bean) {
		Profesor pro = servicioProfesor.buscarPorID(bean.getCodigoPersona());
		if (pro == null)
			throw new NotFoundException();
		else
			pro = servicioProfesor.actualizar(bean);

		return new ResponseEntity<>(pro, HttpStatus.OK);
	}

	@DeleteMapping("/eliminar/{codigo}")
	public ResponseEntity<Void> eliminar(@PathVariable("codigo") Integer cod) {
		// buscar còdigo
		Profesor pro = servicioProfesor.buscarPorID(cod);
		// validar
		if (pro == null)
			throw new NotFoundException();
		else
			servicioProfesor.eliminarPorID(cod);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	// anotaciòn (direcciòn URL)para buscar empleado segùn còdigo
	@GetMapping("/buscar/{cod}")
	public ResponseEntity<Profesor> buscar(@PathVariable("cod") Integer codi) {
		// buscar còdigo
		Profesor pro = servicioProfesor.buscarPorID(codi);
		// validar
		if (pro == null)
			throw new NotFoundException();
		else
			pro = servicioProfesor.buscarPorID(codi);

		return new ResponseEntity<>(pro, HttpStatus.OK);
	}
}
