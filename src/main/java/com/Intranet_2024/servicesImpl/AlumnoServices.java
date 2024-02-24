package com.Intranet_2024.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.Intranet_2024.model.Alumno;
import com.Intranet_2024.repository.AlumnoRepository;

@Service
public class AlumnoServices extends ICRUDImpl<Alumno, Integer>{

	@Autowired
	private AlumnoRepository repo;
	
	@Override
	public JpaRepository<Alumno, Integer> getRepository() {
		return repo;
	}

}
