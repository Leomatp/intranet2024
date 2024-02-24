package com.Intranet_2024.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_persona")
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_persona")
	private Integer codigoPersona;
	@Column(name="nom_persona",nullable = false,length = 25)
	private String nombrePersona;
	@Column(name="pat_persona",nullable = false,length = 30)
	private String paternoPersona;
	@Column(name="mat_persona",nullable = false,length = 30)
	private String maternoPersona;
	@Column(name="cel_persona",nullable = false)
	private int celularPersona;
	@Column(name="ema_persona",nullable = false,length = 20)
	private String correoPersona;
	@Column(name="dni_persona",nullable = false,length = 8)
	private String dniPersona;
	@Column(name="fec_nac_persona",nullable = false)
	private LocalDate fechaNacimientoPersona;
	@Column(name="sex_persona",nullable = false,length = 12)
	private String sexoPersona;
	@Column(name="dir_persona",nullable = false,length = 80)
	private String direccionPersona;
	
	@ManyToOne
	@JoinColumn(name = "cod_sede")
	private Sede sede;
	
	public Persona() {
		super();
	}

	public Persona(Integer codigoPersona, String nombrePersona, String paternoPersona, String maternoPersona,
			int celularPersona, String correoPersona, String dniPersona, LocalDate fechaNacimientoPersona,
			String sexoPersona, String direccionPersona, Sede sede) {
		super();
		this.codigoPersona = codigoPersona;
		this.nombrePersona = nombrePersona;
		this.paternoPersona = paternoPersona;
		this.maternoPersona = maternoPersona;
		this.celularPersona = celularPersona;
		this.correoPersona = correoPersona;
		this.dniPersona = dniPersona;
		this.fechaNacimientoPersona = fechaNacimientoPersona;
		this.sexoPersona = sexoPersona;
		this.direccionPersona = direccionPersona;
		this.sede=sede;
	}

	public Integer getCodigoPersona() {
		return codigoPersona;
	}

	public void setCodigoPersona(Integer codigoPersona) {
		this.codigoPersona = codigoPersona;
	}

	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public String getPaternoPersona() {
		return paternoPersona;
	}

	public void setPaternoPersona(String paternoPersona) {
		this.paternoPersona = paternoPersona;
	}

	public String getMaternoPersona() {
		return maternoPersona;
	}

	public void setMaternoPersona(String maternoPersona) {
		this.maternoPersona = maternoPersona;
	}

	public int getCelularPersona() {
		return celularPersona;
	}

	public void setCelularPersona(int celularPersona) {
		this.celularPersona = celularPersona;
	}

	public String getCorreoPersona() {
		return correoPersona;
	}

	public void setCorreoPersona(String correoPersona) {
		this.correoPersona = correoPersona;
	}

	public String getDniPersona() {
		return dniPersona;
	}

	public void setDniPersona(String dniPersona) {
		this.dniPersona = dniPersona;
	}

	public LocalDate getFechaNacimientoPersona() {
		return fechaNacimientoPersona;
	}

	public void setFechaNacimientoPersona(LocalDate fechaNacimientoPersona) {
		this.fechaNacimientoPersona = fechaNacimientoPersona;
	}

	public String getSexoPersona() {
		return sexoPersona;
	}

	public void setSexoPersona(String sexoPersona) {
		this.sexoPersona = sexoPersona;
	}

	public String getDireccionPersona() {
		return direccionPersona;
	}

	public void setDireccionPersona(String direccionPersona) {
		this.direccionPersona = direccionPersona;
	}

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}
	
	

}
