package com.Intranet_2024.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.Intranet_2024.model.Curso;
import com.Intranet_2024.repository.CursoRepository;

@Service
public class CursoServices extends ICRUDImpl<Curso, Integer> {

	@Autowired
	private CursoRepository repo;
	@Override
	public JpaRepository<Curso, Integer> getRepository() {
		return repo;
	}

}
