package org.alumno.carlos.carlos_primer_app_spring_mvc.model.order;

import java.util.Comparator;

import org.alumno.carlos.carlos_primer_app_spring_mvc.model.*;

public class ComparatorId implements Comparator<Modulo>{
	
	@Override
	public int compare(Modulo mod1, Modulo mod2) {
		return mod1.getId() - mod2.getId();
	}
}
