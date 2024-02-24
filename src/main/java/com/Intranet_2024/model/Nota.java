package com.Intranet_2024.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Nota {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoNota;
	private int nota;

	 
	@ManyToOne
	@JoinColumn(name = "codigoAlumno", nullable = false)
	private Alumno alumno;

	public Integer getCodigoNota() {
		return codigoNota;
	}

	public void setCodigoNota(Integer codigoNota) {
		this.codigoNota = codigoNota;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

}
