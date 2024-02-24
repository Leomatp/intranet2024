package com.Intranet_2024.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_matricula")
public class Matricula {
	@Id
	@Column(name="num_matri")
	private Integer numeroMatricula;
	
}