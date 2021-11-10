package org.alumno.carlos.carlos_primer_app_spring_mvc.mvc;




import org.alumno.carlos.carlos_primer_app_spring_mvc.model.Alumno;
import org.alumno.carlos.carlos_primer_app_spring_mvc.model.Pagina;

import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.AlumnoService;
import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.PaginaService;
import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.excepciones.AlumnoDuplicadoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("nombre")
public class AlumnoController {

		@Autowired
		AlumnoService alumnoService;
		
		@Autowired
		PaginaService paginaService;
		
		@RequestMapping(value = "list-alumno", method = RequestMethod.GET)
		public String listarAlumno(@RequestParam(required = false) String orden, ModelMap model) {
			model.put("alumnos", alumnoService.listaAlumnos(orden == null ? "" : orden));	
			paginaService.setPagina(new Pagina("Lista de alumnos", "list-alumno"));
			model.put("pagina", paginaService.getPagina());
			return "list-alumno";
		
		}
		
		
		@RequestMapping(value = "add-alumno", method = RequestMethod.GET)
		public String mostrarAlumno(ModelMap model) {
			paginaService.setPagina(new Pagina("Añadir alumno", "list-alumno"));
			model.put("pagina", paginaService.getPagina());
			return "add-alumno";
		}
		
		@RequestMapping(value="add-alumno", method = RequestMethod.POST)
		public String addAlumno(
				@RequestParam String dni,
				@RequestParam String nombre,
				@RequestParam String edad,
				@RequestParam String ciclo,
				@RequestParam String curso,
				
				ModelMap model) {
			
			String errores="";
			paginaService.setPagina(new Pagina("Añadir alumno", "list-alumno"));
			model.addAttribute("pagina", paginaService.getPagina());
			try {
				alumnoService.addAlumno(new Alumno(
						nombre,dni,Integer.parseInt(edad),
						ciclo, Integer.parseInt(curso)));
				
				model.clear();
				return "redirect:list-alumno";
			}catch(NumberFormatException e) {
				errores=e.getMessage();
				
			}catch(AlumnoDuplicadoException e) {
				errores=e.toString();
			}catch(Exception e) {
				errores=e.getMessage();
			}
			
			model.addAttribute("errores", errores);
			return "add-alumno";
		}
		
		@RequestMapping(value = "del-alumno", method = RequestMethod.GET)
		public String eliminarAlumno(@RequestParam String dni, ModelMap model) {
			paginaService.setPagina(new Pagina("Añadir alumno", "list-alumno"));
			model.put("pagina", paginaService.getPagina());
			alumnoService.delAlumno(dni);
			model.clear();
			return "redirect:list-alumno";
		}
		
}
