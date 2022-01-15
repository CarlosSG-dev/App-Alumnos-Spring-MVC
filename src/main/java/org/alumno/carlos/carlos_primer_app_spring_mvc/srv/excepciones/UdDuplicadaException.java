package org.alumno.carlos.carlos_primer_app_spring_mvc.srv.excepciones;

import org.alumno.carlos.carlos_primer_app_spring_mvc.model.*;

public class UdDuplicadaException extends Exception{
		
		private Ud nuevo;
		private Ud existente;

		public UdDuplicadaException(Ud nuevo, Ud existente) {
			super();
			this.nuevo = nuevo;
			this.existente = existente;
		}

		@Override
		public String toString() {
			return "ERROR, Se ha intentado insertar una unidad que está duplicada [{Existente: ID=" + nuevo.getId() + ", Nombre=" + nuevo.getNombre() + ", Horas="
					+ nuevo.getHoras() + ", idModulo=" + nuevo.getIdModulo()+ "}"
					+ ", {Nuevo: ID=" + existente.getId() + ", Nombre=" + existente.getNombre() + ", Horas="
					+ existente.getHoras() + ", idModulo="+existente.getIdModulo() + "}]";
		}
	}



