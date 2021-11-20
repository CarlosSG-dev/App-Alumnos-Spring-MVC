package org.alumno.carlos.carlos_primer_app_spring_mvc.srv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.alumno.carlos.carlos_primer_app_spring_mvc.model.*;
import org.alumno.carlos.carlos_primer_app_spring_mvc.mvc.*;
import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.excepciones.AlumnoDuplicadoException;
import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.excepciones.AlumnoModificadoException;
import org.alumno.carlos.carlos_primer_app_spring_mvc.utils.Ts;
import org.alumno.carlos.carlos_primer_app_spring_mvc.model.order.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AlumnoService {
	
	@Autowired
	ModuloService modulosService;
	
	
	private static List<Alumno> alumnos = new ArrayList<Alumno>();
	
	private static List<String> interesadoEn = new ArrayList<String>();
	private static List<String> generoLista = new ArrayList<String>();
	private static List<String> horarioLista = new ArrayList<String>();
	private static HashMap<String, String> paisLista = new HashMap<String, String>();
	
	
	static {
		alumnos.add(new Alumno("Jose","20011223A",12,"DAW",1));
		alumnos.add(new Alumno("Pedro","20011223E",26,"DAW",2));
		alumnos.add(new Alumno("Juan","20011223F",32,"DAM",2));
		
		interesadoEn.add("Backend");
		interesadoEn.add("Frontend");
		generoLista.add("Hombre");
		generoLista.add("Mujer");
		horarioLista.add("Mañana");
		horarioLista.add("Tarde");
		paisLista.put("ES", "España");
		paisLista.put("IT", "Italia");
	}
	
	public static List<Alumno> listaAlumnos(String orden) {
		switch(orden) {
		case "ciclo":
			Collections.sort(alumnos, new ComparatorCiclo());
			break;
		case "curso":
			Collections.sort(alumnos, new ComparatorCurso());
			break;
		case "dni":
			Collections.sort(alumnos, new ComparatorDni());
			break;
		case "edad":
			Collections.sort(alumnos, new ComparatorEdad());
			break;
		default:
			Collections.sort(alumnos, new ComparatorNombre());
			break;
		
		}
		for(Alumno a : alumnos) {
			System.out.println(a + " ");
		}
		return alumnos;
	}
	public static boolean addAlumno(Alumno alumno) throws Exception {
		if(existeAlumno(alumno)) {
			Alumno existe = encontrarAlumnoPorDni(alumno.getDni());
			throw new AlumnoDuplicadoException(existe, alumno);
		}
		return alumnos.add(alumno);
	}
	
	public static void delAlumno(String dni) {
		for (int i = 0; i < alumnos.size(); i++) {
			if(alumnos.get(i).getDni().equals(dni)) {
				alumnos.remove(i);
			}
		}
	}
	
	public static boolean existeAlumno(Alumno alumno) {
			
		
		for (Alumno nuevo : alumnos) {
			if(nuevo.getDni().toLowerCase().equals(alumno.getDni().toLowerCase())) {
				return true;
			}
		}
		return false;
		
		
		
	}
	
	public static Alumno encontrarAlumnoPorDni(String dni) {
		Optional<Alumno> alumno = alumnos.stream().filter(alumn -> alumn.getDni().equals(dni)).findFirst();
		if(alumno.isPresent())
			return alumno.get();
		return null;
//		for (int i = 0; i < alumnos.size(); i++) {
//			if(alumnos.get(i).getDni().contentEquals(dni)) {
//				return ;
//			}
//		}
		
	}
	
	
	
	public void modificaAlumno(Alumno alumnoMod, String usuarioModificacion) throws AlumnoModificadoException {
		
		Alumno alumno = encontrarAlumnoPorDni(alumnoMod.getDni());
		
		if(null != alumno) {
			
			if (alumno.sePuedeModificarUtilizando(alumnoMod)) {
			for (int i = 0; i < alumnos.size(); i++) {
				if(alumnos.get(i).getDni().contentEquals(alumnoMod.getDni())) {
					
					
					
					alumnoMod.setTs(Ts.today());
					alumnoMod.setUser(usuarioModificacion);
					alumnos.set(i, alumnoMod);
//					delAlumno(alumnos.get(i).getDni());
//					alumnos.set(i, alumnoMod);
					
//					alumnos.get(i).setNombre(alumnoMod.getNombre());
//					alumnos.get(i).setDni(alumnoMod.getDni());
//					alumnos.get(i).setEdad(alumnoMod.getEdad());
//					alumnos.get(i).setCiclo(alumnoMod.getCiclo());
//					alumnos.get(i).setCurso(alumnoMod.getCurso());
					
					
					
					break;
				}
				}
			}
		}else {
			throw new AlumnoModificadoException(alumnoMod);
		}
		
	}
	
	public List<String> listaInteresadoEn() {
		return interesadoEn;
	}
	
	public List<String> listaGenero() {
		return generoLista;
	}

	public List<String> listaHorario() {
		return horarioLista;
	}
	
	public HashMap<String, String> listaPais() {
		return paisLista;
	}

	public List<Modulo> listaModulos() {
		return modulosService.listaModulos("");
	}

	
	
	
}
