package org.alumno.carlos.carlos_primer_app_spring_mvc.mvc;

import org.alumno.carlos.carlos_primer_app_spring_mvc.model.Modulo;
import org.alumno.carlos.carlos_primer_app_spring_mvc.model.Pagina;
import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.ModuloService;
import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.PaginaService;
import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.excepciones.ModuloDuplicadoException;
import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.excepciones.ModuloExcepcionesFormulario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("nombre")
public class ModuloController {

	
	@Autowired
	ModuloService moduloService;
	
	@Autowired
	PaginaService paginaService;
	
	@RequestMapping(value = "list-modulo", method = RequestMethod.GET)
	public String listarModulo(@RequestParam(required = false) String orden, ModelMap model) {
		model.put("modulos", moduloService.listaModulos(orden == null ? "" : orden));	
		paginaService.setPagina(new Pagina("Lista de modulos", "list-modulo"));
		model.put("pagina", paginaService.getPagina());
		model.addAttribute("modulo", new Modulo(3,"Matemáticas",4,"MAT"));
		
		return "list-modulo";
	
	}
	
	
	@RequestMapping(value = "add-modulo", method = RequestMethod.GET)
	public String mostrarModulo(ModelMap model) {
		paginaService.setPagina(new Pagina("Añadir modulo", "list-modulo"));
		model.put("pagina", paginaService.getPagina());
		model.addAttribute("modulo", new Modulo(3,"Matemáticas",4,"MAT"));
		return "list-modulo";
	}
	
	@RequestMapping(value="add-modulo", method = RequestMethod.POST)
	public String addAlumno(
			Modulo modulo,
			ModelMap model) {
		
		String errores="";
		paginaService.setPagina(new Pagina("Añadir modulo", "list-modulo"));
		model.addAttribute("pagina", paginaService.getPagina());
		model.addAttribute("modulo", new Modulo(3,"Matemáticas",4,"MAT"));
		try {
			moduloService.addModulo(modulo);
			
			model.clear();
			return "redirect:list-modulo";
		}catch(NumberFormatException e) {
			errores=e.getMessage();
			
		}catch(ModuloDuplicadoException e) {
			errores=e.toString();
		}catch(ModuloExcepcionesFormulario e){
			errores=e.toString();
		}
		
		catch(Exception e) {
			errores=e.getMessage();
		}
		
		model.addAttribute("errores", errores);
		return "list-modulo";
	}
	
	@RequestMapping(value = "del-modulo", method = RequestMethod.GET)
	public String eliminarModulo(@RequestParam int id, ModelMap model) {
		paginaService.setPagina(new Pagina("Añadir alumno", "list-alumno"));
		model.put("pagina", paginaService.getPagina());
		moduloService.delModulo(id);
		model.clear();
		return "redirect:list-modulo";
	}
}
