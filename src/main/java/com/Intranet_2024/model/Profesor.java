package com.Intranet_2024.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "cod_profesor")
public class Profesor extends Persona {

	@Column(name="salario_pro")
	private double salario;
	@Column(name="horas_trabajadas")
	private int horas;
	
	@ManyToMany(mappedBy = "profesores")
	private List<Curso> cursos;

	public Profesor() {
		super();
	}

	public Profesor(Integer codigoPersona, String nombrePersona, String paternoPersona, String maternoPersona,
			int celularPersona, String correoPersona, String dniPersona, LocalDate fechaNacimientoPersona,
			String sexoPersona, String direccionPersona, Sede sede, List<Curso> cursos) {
		super(codigoPersona, nombrePersona, paternoPersona, maternoPersona, celularPersona, correoPersona, dniPersona,
				fechaNacimientoPersona, sexoPersona, direccionPersona, sede);
		this.cursos = cursos;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
	public double getPAgo(double salario, int horas) {
		return salario*horas;
	}
	
}
