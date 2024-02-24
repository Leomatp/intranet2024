package com.Intranet_2024.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Intranet_2024.model.Tarea;
import com.Intranet_2024.servicesImpl.TareaServices;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tarea")
public class TareaController {
	@Autowired
	private TareaServices servicioTarea;

	@GetMapping("/lista")
	public ResponseEntity<List<Tarea>> lista() {
		return new ResponseEntity<>(servicioTarea.listarTodos(), HttpStatus.OK);
		
	}
}
