package com.Intranet_2024.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.Intranet_2024.model.Profesor;
import com.Intranet_2024.repository.ProfesorRepository;

@Service
public class ProfesorServices extends ICRUDImpl<Profesor, Integer> {

	@Autowired
	private ProfesorRepository repo;
	
	@Override
	public JpaRepository<Profesor, Integer> getRepository() {
		return repo;
	}
	
	

}
