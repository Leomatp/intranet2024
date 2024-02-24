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

import com.Intranet_2024.model.Curso;
import com.Intranet_2024.servicesImpl.CursoServices;
import com.Intranet_2024.utils.NotFoundException;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/curso")
public class CursoController {
	@Autowired
	private CursoServices servicioCurso;

	@GetMapping("/lista")
	public ResponseEntity<List<Curso>> lista() {
		return new ResponseEntity<>(servicioCurso.listarTodos(), HttpStatus.OK);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<Curso> registrar(@RequestBody Curso bean) {
		Curso obj = servicioCurso.registrar(bean);

		return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<Curso> actualizar(@RequestBody Curso bean) {
		Curso cur = servicioCurso.buscarPorID(bean.getCodigoCurso());
		if (cur == null)
			throw new NotFoundException();
		else
			cur = servicioCurso.actualizar(bean);

		return new ResponseEntity<>(cur, HttpStatus.OK);
	}

	
	@DeleteMapping("/eliminar/{codigo}")
	public ResponseEntity<Void> eliminar(@PathVariable("codigo") Integer cod) {
		// buscar còdigo
		Curso cur = servicioCurso.buscarPorID(cod);
		// validar
		if (cur == null)
			throw new NotFoundException();
		else
			servicioCurso.eliminarPorID(cod);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	// anotaciòn (direcciòn URL)para buscar empleado segùn còdigo
	@GetMapping("/buscar/{cod}")
	public ResponseEntity<Curso> buscar(@PathVariable("cod") Integer codi) {
		// buscar còdigo
		Curso cur = servicioCurso.buscarPorID(codi);
		// validar
		if (cur == null)
			throw new NotFoundException();
		else
			cur = servicioCurso.buscarPorID(codi);

		return new ResponseEntity<>(cur, HttpStatus.OK);
	}
	
}
