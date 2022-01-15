package org.alumno.carlos.carlos_primer_app_spring_mvc.srv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.alumno.carlos.carlos_primer_app_spring_mvc.model.Ud;
import org.alumno.carlos.carlos_primer_app_spring_mvc.model.Ud;
import org.alumno.carlos.carlos_primer_app_spring_mvc.model.order.*;
import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.excepciones.ModuloDuplicadoException;
import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.excepciones.ModuloExcepcionesFormulario;
import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.excepciones.UdDuplicadaException;
import org.springframework.stereotype.Service;


@Service
public class UdService {

	
private static List<Ud> udsModulos = new ArrayList<Ud>();
	
static {
	//Ud(Integer id,String nombre, Integer orden, Integer idModulo,Integer horas)
	udsModulos.add(new Ud(1,"Introducción",1,1,20)); //1º ud del modulo 1
	udsModulos.add(new Ud(2,"Introducción",1,2,24));//1º ud del modulo 2
	udsModulos.add(new Ud(3,"Modelo Vista Controlador",2,2,30));//2º ud del
	
	}
	
	public static List<Ud> listaUds(String orden) {
		switch(orden) {
		case "nombre":
			Collections.sort(udsModulos, new ComparatorNombreUd());
			break;
		case "id":
			Collections.sort(udsModulos, new ComparatorIdUd());
			break;
		
		default:
			Collections.sort(udsModulos, new ComparatorIdUd());
			break;
		
		}
		for(Ud a : udsModulos) {
			System.out.println(a + " ");
		}
		return udsModulos;
	}
	public static boolean addUds(Ud ud) throws Exception {
		if(existeUd(ud)) {
			Ud existe = encontrarUdPorId(ud.getId());
			throw new UdDuplicadaException(existe, ud);
		}
		if(ud.getNombre().length() == 0) {
			throw new ModuloExcepcionesFormulario("El nombre no puede contener 0 carácteres");
		}else if(ud.getNombre().length() < 5) {
			throw new ModuloExcepcionesFormulario("El nombre no puede contener menos de 5 carácteres");
		}
		return udsModulos.add(ud);
	}
	
	public static void delUds(int id) {
		for (int i = 0; i < udsModulos.size(); i++) {
			if(udsModulos.get(i).getId() == id) {
				udsModulos.remove(i);
			}
		}
	}
	
	public static boolean existeUd(Ud ud) {
			
		
		for (Ud nuevo : udsModulos) {
			if(nuevo.getId() == (ud.getId())) {
				return true;
			}
		}
		return false;
		
		
		
	}
	
	public static Ud encontrarUdPorId(int id) {
		for (Ud mod : udsModulos) {
			if(mod.getId() == id) {
				return mod;
			}
		}
		return null;

		
	}
}
