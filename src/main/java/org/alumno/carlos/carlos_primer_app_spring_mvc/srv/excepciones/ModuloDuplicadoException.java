package org.alumno.carlos.carlos_primer_app_spring_mvc.srv.excepciones;

import org.alumno.carlos.carlos_primer_app_spring_mvc.model.*;

public class ModuloDuplicadoException extends Exception{
		
		private Modulo nuevo;
		private Modulo existente;

		public ModuloDuplicadoException(Modulo nuevo, Modulo existente) {
			super();
			this.nuevo = nuevo;
			this.existente = existente;
		}

		@Override
		public String toString() {
			return "ERROR, Se ha intentado insertar un modulo que está duplicado [{Existente: ID=" + nuevo.getId() + ", Nombre=" + nuevo.getNombre() + ", Horas="
					+ nuevo.getHoras() + ", Abreviatura=" + nuevo.getAbreviatura() + "}"
					+ ", {Nuevo: ID=" + existente.getId() + ", Nombre=" + existente.getNombre() + ", Horas="
					+ existente.getHoras() + ", Abreviatura=" + existente.getAbreviatura() + "}]";
		}
	}


