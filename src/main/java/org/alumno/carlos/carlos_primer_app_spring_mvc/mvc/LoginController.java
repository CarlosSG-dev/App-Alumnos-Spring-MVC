package org.alumno.carlos.carlos_primer_app_spring_mvc.mvc;

import javax.validation.Valid;

import org.alumno.carlos.carlos_primer_app_spring_mvc.model.Pagina;
import org.alumno.carlos.carlos_primer_app_spring_mvc.model.Usuario;
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
	public String mostrarLogin(ModelMap model) {
		System.out.println("He entrado en login cuando no debia");
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
		
			
		System.out.println(loginService.encontrarUsuarioPorNickName(usuario.getNickname()).getNombre());
		model.put("nombre", loginService.encontrarUsuarioPorNickName(usuario.getNickname()).getNombre());
		model.addAttribute("usuario", usuario);
		
		model.put("loginnickname", loginService.encontrarUsuarioPorNickName(usuario.getNickname()));
		model.put("loginname", loginService.encontrarUsuarioPorNickName(usuario.getNickname()).getNombre());
			return "redirect:list-alumno";
		
		
		
		
		
	
	}
	
	
	
}
