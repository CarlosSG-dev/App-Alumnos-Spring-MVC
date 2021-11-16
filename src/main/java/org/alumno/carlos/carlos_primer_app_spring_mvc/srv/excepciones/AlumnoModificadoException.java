package org.alumno.carlos.carlos_primer_app_spring_mvc.srv.excepciones;

import org.alumno.carlos.carlos_primer_app_spring_mvc.model.Alumno;

public class AlumnoModificadoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Alumno alumno;

	public AlumnoModificadoException(Alumno alumno) {
		super();
		this.alumno = alumno;
	}

	@Override
	public String toString() {
		return "AlumnoModificadoException [alumno=" + alumno + "]";
	}

	
}
