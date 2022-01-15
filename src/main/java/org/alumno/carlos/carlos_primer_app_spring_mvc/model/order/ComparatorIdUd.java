package org.alumno.carlos.carlos_primer_app_spring_mvc.model.order;

import java.util.Comparator;

import org.alumno.carlos.carlos_primer_app_spring_mvc.model.Modulo;
import org.alumno.carlos.carlos_primer_app_spring_mvc.model.Ud;

public class ComparatorIdUd implements Comparator<Ud>{
	
	@Override
	public int compare(Ud mod1, Ud mod2) {
		return mod1.getId() - mod2.getId();
	}
}
