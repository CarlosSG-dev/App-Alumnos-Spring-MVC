package org.alumno.carlos.carlos_primer_app_spring_mvc.model.order;
import java.util.Comparator;

import org.alumno.carlos.carlos_primer_app_spring_mvc.model.*;

public class ComparatorNombreUd implements Comparator<Ud> {

	@Override
	public int compare(Ud mod1, Ud mod2) {
		return mod1.getNombre().compareTo(mod2.getNombre());
	}

}
