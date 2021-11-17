package org.alumno.carlos.carlos_primer_app_spring_mvc.mvc;




import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.alumno.carlos.carlos_primer_app_spring_mvc.model.Alumno;
import org.alumno.carlos.carlos_primer_app_spring_mvc.model.Pagina;

import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.AlumnoService;
import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.PaginaService;
import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.excepciones.AlumnoDuplicadoException;
import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.excepciones.AlumnoModificadoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
		
		@InitBinder
		protected void initBinder(WebDataBinder binder) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		}
		
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
			model.addAttribute("alumno", new Alumno("Nuevo Alumno","",18,"DAW",2));
			return "add-alumno";
		}
		
		@RequestMapping(value="/add-alumno", method = RequestMethod.POST)
		public String addAlumno(
//				@RequestParam String dni,
//				@RequestParam String nombre,
//				@RequestParam String edad,
//				@RequestParam String ciclo,
//				@RequestParam String curso,
				
				@Valid Alumno alumno,
				ModelMap model, BindingResult validacion) {
			
				if(validacion.hasErrors()) {
					model.put("pagina", paginaService.getPagina());
					return "add-alumno";
				}
			
			String errores="";
			paginaService.setPagina(new Pagina("Añadir alumno", "list-alumno"));
			model.addAttribute("pagina", paginaService.getPagina());
			try {
				alumnoService.addAlumno(alumno);
				
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
		
		@RequestMapping(value = "update-alumno", method = RequestMethod.GET)
		public String modificarAlumno(ModelMap model, @RequestParam String dni) {
			
			paginaService.setPagina(new Pagina("Modificar alumno", "list-alumno"));
			model.put("pagina", paginaService.getPagina());
			Alumno modificado = alumnoService.encontrarAlumnoPorDni(dni);
			model.addAttribute("alumno", modificado);
			
			return "update-alumno";
		}
		
		@RequestMapping(value = "/update-alumno", method = RequestMethod.POST)
		public String procesaUpdateAlumnos(@Valid Alumno alumno, BindingResult validacion, ModelMap model) {
			paginaService.setPagina(new Pagina("Modificar alumno", "list-alumno"));
			model.put("pagina", paginaService.getPagina());
			if (validacion.hasErrors())
				return "update-alumno";

			String error = "";
			try {
				alumnoService.modificaAlumno(alumno, model.getAttribute("loginnickname").toString());
				model.clear();
				return "redirect:list-alumno";
			} catch (NumberFormatException e) {
				error = e.toString();
			} catch (AlumnoModificadoException e) {
				error = e.toString();
			}
			model.addAttribute("errores", error);
			return "update-alumno";
		}

		
		
		
}
