package com.Intranet_2024.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.Intranet_2024.model.Tarea;
import com.Intranet_2024.repository.TareaRepository;

@Service
public class TareaServices extends ICRUDImpl<Tarea, Integer> {

	@Autowired
	private TareaRepository repo;

	@Override
	public JpaRepository<Tarea, Integer> getRepository() {
		// TODO Auto-generated method stub
		return repo;
	}

}
