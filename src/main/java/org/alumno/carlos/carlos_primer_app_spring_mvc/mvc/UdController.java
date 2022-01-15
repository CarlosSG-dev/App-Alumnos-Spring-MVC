package org.alumno.carlos.carlos_primer_app_spring_mvc.mvc;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.alumno.carlos.carlos_primer_app_spring_mvc.model.Alumno;
import org.alumno.carlos.carlos_primer_app_spring_mvc.model.FiltroAlumno;
import org.alumno.carlos.carlos_primer_app_spring_mvc.model.Pagina;
import org.alumno.carlos.carlos_primer_app_spring_mvc.model.Ud;
import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.AlumnoService;
import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.I18nService;
import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.ModuloService;
import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.PaginaService;
import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.UdService;
import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.excepciones.AlumnoDuplicadoException;
import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.excepciones.UdDuplicadaException;
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
public class UdController {

	@Autowired
	AlumnoService alumnoService;
	
	@Autowired
	ModuloService moduloService;
	
	@Autowired
	UdService udService;
	
	@Autowired
	PaginaService paginaService;
	Pagina pagina = new Pagina("Lista de uds","list-uds");
	
	
	@Autowired
	I18nService language = new I18nService();
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping(value = "list-uds", method = RequestMethod.GET)
	public String listarUds(@RequestParam(required = false) String orden, ModelMap model) {
		
		Pagina pagina = new Pagina("Lista de uds", "list-uds");
		pagina.setIdioma(language.getIdioma());
		paginaService.setPagina(pagina);		
		model.put("modulos", moduloService.listaModulos(orden == null ? "" : orden));	
		model.put("udsModulos", udService.listaUds(orden == null ? "" : orden));	
		paginaService.setPagina(pagina);
		model.put("pagina", paginaService.getPagina());
		
		return "list-uds";
	
	}
	
	
	@RequestMapping(value = "add-uds", method = RequestMethod.GET)
	public String mostrarUd(ModelMap model) {
		Pagina pagina = new Pagina("Añadir Ud", "add-uds");
		pagina.setIdioma(language.getIdioma());
		paginaService.setPagina(pagina);
		model.put("pagina", paginaService.getPagina());
		model.addAttribute("udsModulo", new Ud(1,"Trigonometria",1,6,1));
		return "add-uds";
	}
	
	@RequestMapping(value = "del-uds", method = RequestMethod.GET)
	public String eliminarUd(@RequestParam int id, ModelMap model) {
		paginaService.setPagina(new Pagina("Eliminar Ud", "list-uds"));
		model.put("pagina", paginaService.getPagina());
		udService.delUds(id);
		model.clear();
		return "redirect:list-uds";
	}
	
	@RequestMapping(value="/add-uds", method = RequestMethod.POST)
	public String addUd(
//			@RequestParam String dni,
//			@RequestParam String nombre,
//			@RequestParam String edad,
//			@RequestParam String ciclo,
//			@RequestParam String curso,
			
			@Valid Ud ud,
			ModelMap model, BindingResult validacion) {
		
			if(validacion.hasErrors()) {
				model.put("pagina", paginaService.getPagina());
				return "add-uds";
			}
		
		String errores="";
		paginaService.setPagina(new Pagina("Añadir ud", "list-uds"));
		model.addAttribute("pagina", paginaService.getPagina());
		try {
			udService.addUds(ud);
			
			model.clear();
			return "redirect:list-uds";
		}catch(NumberFormatException e) {
			errores=e.getMessage();
			
		}catch(UdDuplicadaException e) {
			errores=e.toString();
		}catch(Exception e) {
			errores=e.getMessage();
		}
		
		model.addAttribute("errores", errores);
		return "add-uds";
	}
	
}
