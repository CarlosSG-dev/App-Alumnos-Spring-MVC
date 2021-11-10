package org.alumno.carlos.carlos_primer_app_spring_mvc.model.order;

import java.util.Comparator;

import org.alumno.carlos.carlos_primer_app_spring_mvc.model.*;

public class ComparatorNombre implements Comparator<Alumno>{

		@Override
		public int compare(Alumno a1, Alumno a2) {
			return a1.getNombre().compareTo(a2.getNombre());
		}
}
