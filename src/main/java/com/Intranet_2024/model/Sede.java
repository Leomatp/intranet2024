package com.Intranet_2024.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Sede {
	@Id
	@Column(name="cod_sede")
	private Integer codigoSede;
	@Column(name="nom_sede",nullable = false,length = 25)
	private String nombreSede;
	//
	@JsonIgnore
	@OneToMany(mappedBy = "sede")
	private List<Persona> listaPersonas;
	
	
	
	public Integer getCodigoSede() {
		return codigoSede;
	}
	public void setCodigoSede(Integer codigoSede) {
		this.codigoSede = codigoSede;
	}
	public String getNombreSede() {
		return nombreSede;
	}
	public void setNombreSede(String nombreSede) {
		this.nombreSede = nombreSede;
	}
	public List<Persona> getListaPersonas() {
		return listaPersonas;
	}
	public void setListaPersonas(List<Persona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}
	
	
}
