package org.alumno.carlos.carlos_primer_app_spring_mvc.srv.excepciones;

import org.alumno.carlos.carlos_primer_app_spring_mvc.model.Alumno;

public class AlumnoDuplicadoException extends Exception{
	
	private Alumno nuevo;
	private Alumno existente;

	public AlumnoDuplicadoException(Alumno nuevo, Alumno existente) {
		super();
		this.nuevo = nuevo;
		this.existente = existente;
	}

	@Override
	public String toString() {
		return "AlumnoDuplicadoException, DNI Duplicado: [{Existente: Nombre=" + nuevo.getNombre() + ", Dni=" + nuevo.getDni() + ", Edad="
				+ nuevo.getEdad() + ", Curso=" + nuevo.getCurso() + ", Modulo=" + nuevo.getCiclo() + "}"
				+ ", {Nuevo: Nombre=" + existente.getNombre() + ", Dni=" + existente.getDni() + ", Edad="
				+ existente.getEdad() + ", Curso=" + existente.getCurso() + ", Modulo=" + existente.getCiclo() + "}]";
	}
}
