package org.alumno.carlos.carlos_primer_app_spring_mvc.mvc;




import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.alumno.carlos.carlos_primer_app_spring_mvc.model.Alumno;
import org.alumno.carlos.carlos_primer_app_spring_mvc.model.DocAlumno;
import org.alumno.carlos.carlos_primer_app_spring_mvc.model.FiltroAlumno;
import org.alumno.carlos.carlos_primer_app_spring_mvc.model.Modulo;
import org.alumno.carlos.carlos_primer_app_spring_mvc.model.Pagina;
import org.alumno.carlos.carlos_primer_app_spring_mvc.model.Ud;
import org.alumno.carlos.carlos_primer_app_spring_mvc.model.Usuario;
import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.AlumnoService;
import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.FileService;
import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.I18nService;
import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.PaginaService;
import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.UdService;
import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.excepciones.AlumnoDuplicadoException;
import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.excepciones.AlumnoModificadoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.server.ResponseStatusException;

@Controller
@SessionAttributes({"nombre", "loginName","loginNickName", "usuario"})
public class AlumnoController {

		@Autowired
		AlumnoService alumnoService;
		
		@Autowired
		PaginaService paginaService;
		Pagina pagina = new Pagina("Lista de alumnos","list-alumno");
		
		@Autowired
		FileService fileService;
		
		@Autowired
		UdService udService;
		
		@Autowired
		I18nService language = new I18nService();
		
		@InitBinder
		protected void initBinder(WebDataBinder binder) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		}
		
		@RequestMapping(value = "list-alumno", method = RequestMethod.GET)
		public String listarAlumno(@RequestParam(required = false) String orden, ModelMap model) {
			
			Pagina pagina = new Pagina("Lista de alumnos", "list-alumno");
			pagina.setIdioma(language.getIdioma());
			paginaService.setPagina(pagina);
			
			model.put("alumnos", alumnoService.listaAlumnos(orden == null ? "" : orden));
			model.addAttribute("filtroAlumno", new FiltroAlumno("", ""));
			paginaService.setPagina(pagina);
			model.put("pagina", paginaService.getPagina());
			
			return "list-alumno";
		
		}
		
		
		@RequestMapping(value = "add-alumno", method = RequestMethod.GET)
		public String mostrarAlumno(ModelMap model) {
			Pagina pagina = new Pagina("Añadir alumno", "list-alumno");
			pagina.setIdioma(language.getIdioma());
			paginaService.setPagina(pagina);
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
			
			Pagina pagina = new Pagina("Modificar alumno", "list-alumno");
			pagina.setIdioma(language.getIdioma());
			paginaService.setPagina(pagina);
			
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
				alumnoService.modificaAlumno(alumno, model.getAttribute("nombre").toString());
				//model.clear();
				return "redirect:list-alumno";
			} catch (NumberFormatException e) {
				error = e.toString();
			} catch (AlumnoModificadoException e) {
				error = e.toString();
			}
			model.addAttribute("errores", error);
			return "update-alumno";
		}
		
		@ModelAttribute("interesadoEnLista")
		public Object[] getInteresadoEnLista() {
			return alumnoService.listaInteresadoEn().toArray();
		}
		
		@ModelAttribute("generoLista")
		public Object[] getGeneroLista() {
			return alumnoService.listaGenero().toArray();
		}

		@ModelAttribute("horarioLista")
		public Object[] getHorarioLista() {
			return alumnoService.listaHorario().toArray();
		}

		@ModelAttribute("paisLista")
		public HashMap<String, String> getPaisLista() {
			return alumnoService.listaPais();
		}

		@ModelAttribute("modulosLista")
		public List<Modulo> getModulosLista() {
			return alumnoService.listaModulos();
		}
		@ModelAttribute("udsLista")
		public List<Ud> getUdsLista() {
			return udService.listaUds("");
		}
		
		@ModelAttribute("searchLista")
		public HashMap<String, String> getSearchLista() {
			return alumnoService.listaSearch();
		}
		
		@ModelAttribute("opcionesTipoDoc")
		public List<String> getTipoDoc() {
			return alumnoService.opcionesTipoDoc();
		}
		
		
		
		@RequestMapping(value = "/filter-alumno", method = RequestMethod.POST)
		public String filterAlumnoPost(@Valid FiltroAlumno falumno, BindingResult validacion, ModelMap model) {
			paginaService.setPagina(new Pagina("Lista alumnos", "list-alumno"));
			model.put("pagina", paginaService.getPagina());
			if (validacion.hasErrors())
				return "list-alumno";

			model.put("alumnos", alumnoService.filter(falumno));
			return "list-alumno";
		}
		
		
		@RequestMapping(value="/docs-alumno", method = RequestMethod.GET)
		public String getDocsAlumnos(ModelMap model, @RequestParam String dni) {
			paginaService.setPagina(new Pagina("Documentacion", "docs-alumno"));
			model.put("pagina", paginaService.getPagina());
			
			Pagina pagina = new Pagina("Documentacion", "docs-alumno");
			pagina.setIdioma(language.getIdioma());
			paginaService.setPagina(pagina);
			
			model.addAttribute("alumno", alumnoService.encontrarAlumnoPorDni(dni));
			model.addAttribute("docAlumno", new DocAlumno(alumnoService.siguienteDoc(dni)));
			
			model.addAttribute("docAlumno", new DocAlumno(alumnoService.siguienteDoc(dni)));
			
			model.addAttribute("pagina", paginaService.getPagina());
			
			
			return "docs-alumno";
		}
		
		@RequestMapping(value = "add-doc-alumno", method = RequestMethod.GET)
		public String mostrarDocAlumno(ModelMap model, String dni) {
			DocAlumno docAlumno = new DocAlumno();
			docAlumno.setDni(dni);
			paginaService.setPagina(new Pagina("Añadir documentacion alumno", "doc-alumno"));
			Pagina pagina = new Pagina("Añadir documentacion alumno", "doc-alumno");
			pagina.setIdioma(language.getIdioma());
			paginaService.setPagina(pagina);
			model.put("pagina", paginaService.getPagina());
			model.addAttribute("docAlumno", docAlumno);
			model.addAttribute("alumno", alumnoService.encontrarAlumnoPorDni(docAlumno.getDni()));
			return "add-doc-alumno";
		}
		
		@RequestMapping(value="/add-doc-alumno", method = RequestMethod.POST)
		public String addDocAlumno(ModelMap model, @Valid DocAlumno docAlumno, BindingResult validacion){
			paginaService.setPagina(new Pagina("Documentacion", "docs-alumno"));
			model.put("pagina", paginaService.getPagina());
			
			if(validacion.hasErrors()) {
				model.addAttribute("alumno", alumnoService.encontrarAlumnoPorDni(docAlumno.getDni()));
				return "redirect:docs-alumno?dni=" +docAlumno.getDni();
			}
			
			String dni = (String) docAlumno.getDni();
			Alumno alumno = alumnoService.encontrarAlumnoPorDni(dni);
			Usuario userActive = (Usuario) model.getAttribute("usuario");
			try {
				if(alumno == null) {
					throw new Exception("Alumno desconocido");
				}
				
//				if(userActive == null) {
//					throw new Exception("Para añadir documentación debe estar logeado");
//				}
				
				alumnoService.addDocAlumno(docAlumno);
				
				
				alumnoService.modificaAlumno(alumno, userActive.getNickname());
				
				model.addAttribute("alumno", alumnoService.encontrarAlumnoPorDni(docAlumno.getDni()));
				
				model.addAttribute("docAlumno", new DocAlumno(alumnoService.siguienteDoc(dni)));
				model.clear();
				return "redirect:docs-alumno?dni=" +docAlumno.getDni();
				
			}catch(Exception e) {
				//model.addAttribute("alumno", alumnoService.encontrarAlumnoPorDni(alumno.getDni()));
				
				model.addAttribute("errores", e.getMessage());
			}
			return "redirect:docs-alumno?dni=" +docAlumno.getDni();
		}
		
		
		@RequestMapping(value="/descargar-docAlumno/{dni}/{idDoc}", method = RequestMethod.GET)
		public @ResponseBody void descargarDocAlumno(HttpServletResponse response, @PathVariable("dni") String dni,
				@PathVariable("idDoc") Integer idDoc) throws IOException{
			
			try {
				
				Optional<DocAlumno> docAlumno = alumnoService.encontrarDocAlumnoPorDni_IdDoc(dni, idDoc);
				
				if(docAlumno.isPresent()) { //existe el documento de ese alumno con ese id
					//Obtener fichero
					String nombreFichero=dni+"_idDoc_"+idDoc+"."+docAlumno.get().getTipo();
					FileSystemResource resource = fileService.getDocumentoAlumno(nombreFichero);
				if(!resource.exists()) {
					throw new IOException("El documento con el dni '"+dni+"' y el id '"+idDoc+"' no existe;");
				}
				
				File fichero=resource.getFile();
				//Montar respuesta para el navegador web
				
				response.setContentType(docAlumno.get().getContentTypeFichero());
				response.setHeader("Content-Disposition", "attachment: filename=" + fichero.getName());
				response.setHeader("Content-Length", String.valueOf(fichero.length()));
				
				InputStream in = new FileInputStream(fichero);
				FileCopyUtils.copy(in, response.getOutputStream());
				}else {
					throw new IOException("El documento con el dni '"+dni+"' y el id '"+idDoc+"' no existe;");
					
				}
				
				
			}catch(Exception e) {//Ante cualquier error
				//Devolver error 404-recurso no encontrado
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}
		}
		
		
}
