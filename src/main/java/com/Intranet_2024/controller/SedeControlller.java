package com.Intranet_2024.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Intranet_2024.model.Sede;
import com.Intranet_2024.servicesImpl.SedeServices;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/sede")
public class SedeControlller {
	
	@Autowired
	private SedeServices servicioSede;
	
	@GetMapping("/lista")
	public ResponseEntity<List<Sede>> lista() {
		return new ResponseEntity<>(servicioSede.listarTodos(), HttpStatus.OK);
		
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<Sede> registrar(@RequestBody Sede bean){
		Sede obj =servicioSede.registrar(bean);
		return new ResponseEntity<>(obj,HttpStatus.CREATED);
	}

}
