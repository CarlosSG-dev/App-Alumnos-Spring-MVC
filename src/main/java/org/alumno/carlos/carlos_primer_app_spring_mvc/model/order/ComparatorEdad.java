package org.alumno.carlos.carlos_primer_app_spring_mvc.model.order;

import java.util.Comparator;

import org.alumno.carlos.carlos_primer_app_spring_mvc.model.*;

public class ComparatorEdad implements Comparator<Alumno>{

	@Override
	public int compare(Alumno a1, Alumno a2) {
		int comparaEdad = a1.getEdad()-a2.getEdad();
		if(comparaEdad != 0) {
			return comparaEdad;
		}else {
			return a1.getNombre().compareTo(a2.getNombre());
		}
	}
}
