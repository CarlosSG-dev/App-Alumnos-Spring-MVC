package org.alumno.carlos.carlos_primer_app_spring_mvc.model;

import java.io.Serializable;



public class Modulo implements Serializable, Comparable<Modulo>{
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private int horas;
	private String abreviatura;
	
	public Modulo(int id, String nombre, int horas, String abreviatura) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.horas = horas;
		this.abreviatura = abreviatura;
	}

	public Modulo() {
		super();
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	@Override
	public int compareTo(Modulo m1) {
		// TODO Auto-generated method stub
		return this.id-m1.getId();
	}
	
	
	
	
}
