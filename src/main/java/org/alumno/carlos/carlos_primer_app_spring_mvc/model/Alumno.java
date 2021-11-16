package org.alumno.carlos.carlos_primer_app_spring_mvc.model;

import java.io.Serializable;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

public class Alumno implements Serializable, Comparable<Alumno>{
	private static final long serialVersionUID = 1L;
	@Size(min = 4, message = "El nombre debe tener almenos 4 carácteres")
	private String nombre;
	@Pattern(regexp = "[0-9]{8}[A-Za-z]{1}", message = "El dni debe tener 8 números y una letra")
	private String dni;
	@Digits(fraction = 0, integer = 2, message = "La edad debe ser igual o mayor a 18 y menor o igual a 99")
	@Range(min = 18, max = 99, message = "La edad debe ser igual o mayor a 18 y menor o igual a 99")
	private int edad;
	@Size(min = 3, message = "El ciclo debe tener almenos 3 carácteres")
	private String ciclo;
	@Digits(fraction = 0, integer = 1, message = "El curso debe ser 1 o 2")
	@Range(min = 1, max = 2, message = "El curso debe ser 1 o 2")
	private int curso;


	public Alumno(String nombre, String dni, int edad, String ciclo, int curso) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.edad = edad;
		this.ciclo = ciclo;
		this.curso = curso;
	}
	
	public Alumno() {
		super();
	}
	
	

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}

	public Alumno(String nombre) {
		super();
		this.nombre = nombre;
	}

	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", dni=" + dni + ", edad=" + edad + ", ciclo=" + ciclo + ", curso=" + curso
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Alumno a) {
		return this.nombre.compareTo(a.getNombre());
	}
	
	
}
