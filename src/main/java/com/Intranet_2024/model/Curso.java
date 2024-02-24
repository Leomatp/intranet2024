package com.Intranet_2024.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Curso {
	@Id
	@Column(name = "cod_curso")
	private Integer codigoCurso;
	@Column(name = "nom_curso")
	private String nombreCurso;
	@Column(name = "cre_curso")
	private int creditos;

	@ManyToMany
	@JoinTable(name = "profesor_curso", joinColumns = @JoinColumn(name = "cod_curso"), inverseJoinColumns = @JoinColumn(name = "cod_profesor"))
	private List<Profesor> profesores;

	public Integer getCodigoCurso() {
		return codigoCurso;
	}

	public void setCodigoCurso(Integer codigoCurso) {
		this.codigoCurso = codigoCurso;
	}

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public List<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(List<Profesor> profesores) {
		this.profesores = profesores;
	}
	
	
}
