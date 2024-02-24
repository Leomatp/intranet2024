package com.Intranet_2024.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tarea {
	@Id
	@Column(name="cod_tarea")
	private Integer codigoTarea;
	private String titulo, asignacion,descripcion;
	
	
	public Integer getCodigoTarea() {
		return codigoTarea;
	}
	public void setCodigoTarea(Integer codigoTarea) {
		this.codigoTarea = codigoTarea;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAsignacion() {
		return asignacion;
	}
	public void setAsignacion(String asignacion) {
		this.asignacion = asignacion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion=descripcion;
	}

	
}
