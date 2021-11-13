package org.alumno.carlos.carlos_primer_app_spring_mvc.mvc;

import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"nombre","password"})
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String mostrarMain() {
		return "login";
	}
	
	
	@RequestMapping(value="/carlos_primer_app_spring_mvc", method = RequestMethod.GET)
	public String mostrarLog() {
		return "login";
	}
	
	

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String mostrarLogin() {
		System.out.println("He entrado en login cuando no debia");
		return "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String procesaLogin(@RequestParam String nombre, String password, ModelMap model) {
		
		if(!loginService.UsuarioValido(nombre, password)) {
			model.put("errores", "Usuario" +nombre+"o contraseña incorrecta");
			
			return "login";
			
		}
		
		
			
			model.put("nombre", nombre);
			model.put("password", password);
			return "redirect:list-alumno";
		
		
		
		
		
	
	}
	
	
	
}
