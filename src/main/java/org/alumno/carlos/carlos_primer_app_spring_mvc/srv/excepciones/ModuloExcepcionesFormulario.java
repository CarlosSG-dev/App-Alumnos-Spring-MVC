package org.alumno.carlos.carlos_primer_app_spring_mvc.srv.excepciones;
import org.alumno.carlos.carlos_primer_app_spring_mvc.model.*;

public class ModuloExcepcionesFormulario extends Exception{
	
			
			/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
			
			String error;
			public ModuloExcepcionesFormulario(String error) {
				super();
				this.error=error;
			}


			@Override
			public String toString() {
				return "ModuloExcepcionesFormulario [Error:]";
			}
			
			

			
		}




