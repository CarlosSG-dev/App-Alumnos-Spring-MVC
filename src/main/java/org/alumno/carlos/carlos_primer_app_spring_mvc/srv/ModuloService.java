package org.alumno.carlos.carlos_primer_app_spring_mvc.srv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.alumno.carlos.carlos_primer_app_spring_mvc.model.Modulo;
import org.alumno.carlos.carlos_primer_app_spring_mvc.model.order.*;
import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.excepciones.ModuloDuplicadoException;
import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.excepciones.ModuloExcepcionesFormulario;
import org.springframework.stereotype.Service;


@Service
public class ModuloService {

	
private static List<Modulo> modulos = new ArrayList<Modulo>();
	
	static {
		modulos.add(new Modulo(1,"Programación",8,"PROG"));
		modulos.add(new Modulo(2,"Desarrollo Web en Entorno Servidor",8,"DWES"));
		
	}
	
	public static List<Modulo> listaModulos(String orden) {
		switch(orden) {
		case "nombre":
			Collections.sort(modulos, new ComparatorNombreMod());
			break;
		case "abreviatura":
			Collections.sort(modulos, new ComparatorAbreviatura());
			break;
		case "horas":
			Collections.sort(modulos, new ComparatorHoras());
			break;
		default:
			Collections.sort(modulos, new ComparatorId());
			break;
		
		}
		for(Modulo a : modulos) {
			System.out.println(a + " ");
		}
		return modulos;
	}
	public static boolean addModulo(Modulo modulo) throws Exception {
		if(existeModulo(modulo)) {
			Modulo existe = encontrarModuloPorId(modulo.getId());
			throw new ModuloDuplicadoException(existe, modulo);
		}
		if(modulo.getNombre().length() == 0) {
			throw new ModuloExcepcionesFormulario("El nombre no puede contener 0 carácteres");
		}else if(modulo.getNombre().length() < 5) {
			throw new ModuloExcepcionesFormulario("El nombre no puede contener menos de 5 carácteres");
		}
		return modulos.add(modulo);
	}
	
	public static void delModulo(int id) {
		for (int i = 0; i < modulos.size(); i++) {
			if(modulos.get(i).getId() == id) {
				modulos.remove(i);
			}
		}
	}
	
	public static boolean existeModulo(Modulo modulo) {
			
		
		for (Modulo nuevo : modulos) {
			if(nuevo.getId() == (modulo.getId())) {
				return true;
			}
		}
		return false;
		
		
		
	}
	
	public static Modulo encontrarModuloPorId(int id) {
		for (Modulo mod : modulos) {
			if(mod.getId() == id) {
				return mod;
			}
		}
		return null;

		
	}
}
