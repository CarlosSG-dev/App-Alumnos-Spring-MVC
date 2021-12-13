package org.alumno.carlos.carlos_primer_app_spring_mvc.mvc;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.alumno.carlos.carlos_primer_app_spring_mvc.model.Pagina;
import org.alumno.carlos.carlos_primer_app_spring_mvc.model.Usuario;
import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.I18nService;
import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.LoginService;
import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.PaginaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes({"nombre", "loginName","loginNickName", "usuario"})
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	PaginaService paginaService;
	Pagina pagina = new Pagina("login", "login");
	
	@Autowired
	I18nService language = new I18nService();
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String mostrarMain(ModelMap model) {
		
		model.addAttribute("usuario", new Usuario("", "", "",""));
		return "login";
	}
	
	
	@RequestMapping(value="/carlos_primer_app_spring_mvc", method = RequestMethod.GET)
	public String mostrarLog() {
		return "login";
	}
	
	

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String mostrarLogin(HttpServletRequest request,HttpServletResponse response, Locale locale,ModelMap model) {
		
		//Traza i18n
				//Información idioma de la petición del navegador
				System.out.println("Accept-Language: "+ request.getHeader("Accept-Language"));

				//Información del localeResolver
				
				System.out.println(String.format("Petición recibida. Languaje: %s, País: %s %n", locale.getLanguage(), locale.getDisplayCountry()));
				//Datos para la cabecera de la página
				language.configuraIdiomaPeticion(request, response, locale);
				paginaService.setPagina(pagina);
				model.put("pagina", new Pagina("Home","login", language.getIdioma()));
				System.out.println("language.getIdioma "+language.getIdioma());
				model.addAttribute("loginName", "Desconocido");
				model.put("loginNickname", "Desconocido");
				//Datos para el formulario de login
		
		model.addAttribute("usuario", new Usuario("", "", "",""));
		
		return "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String procesaLogin(@Valid Usuario usuario , BindingResult validacion, ModelMap model) {
		
		paginaService.setPagina(new Pagina("Home", "login"));
		model.put("pagina", paginaService.getPagina());
		model.addAttribute("usuario", new Usuario("", "", "",""));
		
		if (validacion.hasErrors()) 
			return "login";
		
		
		if(!loginService.usuarioValido(usuario)) {
			model.put("errores", "Usuario" +usuario.getNickname()+"o contraseña incorrecta");
			
			
			return "login";
			
		}
		
			
		Usuario usuarioEncontrado = loginService.encontrarUsuarioPorNickName(usuario.getNickname());
		Usuario desconocido = new Usuario("desconocido", "Desconocido", "", "usuarioSinFoto.jpg");
		if (usuarioEncontrado != null) {
			model.put("nombre", usuarioEncontrado.getNombre());
			model.addAttribute("usuario", usuarioEncontrado);
			model.put("loginNickName", usuarioEncontrado.getNickname());
			model.put("loginName", usuarioEncontrado.getNombre());
			
			model.addAttribute("loginNickName", usuarioEncontrado.getNickname());
			model.addAttribute("loginName", usuarioEncontrado.getNombre());			
			
		} else {
			model.put("nombre", desconocido.getNombre());
			model.addAttribute("usuario", desconocido);
			model.put("loginNickName", desconocido.getNickname());
			model.put("loginName", desconocido.getNombre());
			
			model.addAttribute("loginNickName", desconocido.getNickname());
			model.addAttribute("loginName", desconocido.getNombre());		
		}
		return "redirect:list-alumno";
		
		
		
		
		
	
	}
	
	
	
}
