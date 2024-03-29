package com.Intranet_2024.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Intranet_2024.model.Rol;

import java.util.Optional;

public interface IRolesRepository extends JpaRepository<Rol, Integer> {
    //Método para buscar un role por su nombre en nuestra base de datos
    Optional<Rol> findByDescripcion(String name);
}
