package com.Intranet_2024.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "cod_alumno")
public class Alumno extends Persona {
	
	private String ciclo;
	
	@JsonIgnore
	@OneToMany(mappedBy = "alumno")
    private List<Nota> notas;

	public Alumno() {
		super();
	}
	
	
	
	
	public Alumno(Integer codigoPersona, String nombrePersona, String paternoPersona, String maternoPersona,
			int celularPersona, String correoPersona, String dniPersona, LocalDate fechaNacimientoPersona,
			String sexoPersona, String direccionPersona, Sede sede, String ciclo, List<Nota> notas) {
		super(codigoPersona, nombrePersona, paternoPersona, maternoPersona, celularPersona, correoPersona, dniPersona,
				fechaNacimientoPersona, sexoPersona, direccionPersona, sede);
		this.ciclo = ciclo;
		this.notas = notas;
	}




	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}
	
	public double promedio(List<Nota> notas) {
		
		if (notas == null || notas.isEmpty()) {
	        return 0.0;  // o algún valor predeterminado si la lista está vacía
	    }

	    double average = 0.0;
	    
	    // Asumiendo que las notas tienen un método para obtener su valor, por ejemplo, getValor()
	    average += notas.get(0).getNota() * 0.2 + notas.get(1).getNota() * 0.35 + notas.get(2).getNota() * 0.45;

	    return average;
	}
	public int notaFinal() {
		double nota= promedio(notas);
		double parteDecimal = nota - Math.floor(nota);

	    // Redondear hacia arriba si la parte decimal es 0.5 o mayor
	    if (parteDecimal >= 0.5) {
	        return (int) Math.ceil(nota);
	    } else {
	        return (int) Math.floor(nota);
	    }
	}
}
