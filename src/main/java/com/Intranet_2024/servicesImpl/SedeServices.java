package com.Intranet_2024.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.Intranet_2024.model.Sede;
import com.Intranet_2024.repository.SedeRepository;

@Service
public class SedeServices extends ICRUDImpl<Sede, Integer> {
	
	@Autowired
	private SedeRepository repo;

	@Override
	public JpaRepository<Sede, Integer> getRepository() {
		return repo;
	}
	
	

}
