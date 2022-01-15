package org.alumno.carlos.carlos_primer_app_spring_mvc.srv.excepciones;

import org.alumno.carlos.carlos_primer_app_spring_mvc.model.Alumno;
import org.alumno.carlos.carlos_primer_app_spring_mvc.model.Ud;

public class UdExcepcionesFormulario {

	
	private static final long serialVersionUID = 1L;
	private Ud ud;

	public UdExcepcionesFormulario(Ud ud) {
		super();
		this.ud = ud;
	}

	@Override
	public String toString() {
		return "AlumnoModificadoException [alumno=" + ud + "]";
	}

	
}
