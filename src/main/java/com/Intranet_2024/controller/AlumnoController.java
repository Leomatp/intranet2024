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

import com.Intranet_2024.model.Alumno;
import com.Intranet_2024.servicesImpl.AlumnoServices;
import com.Intranet_2024.utils.NotFoundException;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/alumno")
public class AlumnoController {
	@Autowired
	private AlumnoServices servicioAlumno;
	
	@GetMapping("/lista")
	public ResponseEntity<List<Alumno>> lista() {
		return new ResponseEntity<>(servicioAlumno.listarTodos(), HttpStatus.OK);
		
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<Alumno> registrar(@RequestBody Alumno bean){
		Alumno obj =servicioAlumno.registrar(bean);
		return new ResponseEntity<>(obj,HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<Alumno> actualizar(@RequestBody Alumno bean) {
		Alumno lib = servicioAlumno.buscarPorID(bean.getCodigoPersona());
		if (lib == null)
			throw new NotFoundException();
		else
			lib = servicioAlumno.actualizar(bean);

		return new ResponseEntity<>(lib, HttpStatus.OK);
	}

	
	@DeleteMapping("/eliminar/{codigo}")
	public ResponseEntity<Void> eliminar(@PathVariable("codigo") Integer cod) {
		// buscar còdigo
		Alumno lib = servicioAlumno.buscarPorID(cod);
		// validar
		if (lib == null)
			throw new NotFoundException();
		else
			servicioAlumno.eliminarPorID(cod);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	// anotaciòn (direcciòn URL)para buscar empleado segùn còdigo
	@GetMapping("/buscar/{cod}")
	public ResponseEntity<Alumno> buscar(@PathVariable("cod") Integer codi) {
		// buscar còdigo
		Alumno lib = servicioAlumno.buscarPorID(codi);
		// validar
		if (lib == null)
			throw new NotFoundException();
		else
			lib = servicioAlumno.buscarPorID(codi);

		return new ResponseEntity<>(lib, HttpStatus.OK);
	}
	
}
