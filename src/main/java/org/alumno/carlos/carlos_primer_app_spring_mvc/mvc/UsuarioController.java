package org.alumno.carlos.carlos_primer_app_spring_mvc.mvc;

import javax.validation.Valid;

import org.alumno.carlos.carlos_primer_app_spring_mvc.model.ImagenUsuario;
import org.alumno.carlos.carlos_primer_app_spring_mvc.model.Usuario;
import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.AlumnoService;
import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.FileService;
import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.I18nService;
import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;



import java.util.ArrayList;

@Controller
@SessionAttributes({"loginName","loginNickName","user", "usuario"})
public class UsuarioController {

	@Autowired
	LoginService loginService;
	
	@Autowired
	FileService fileService;
	
	@Autowired
	AlumnoService alumnoService;
	
	@Autowired
	I18nService language = new I18nService();
	
	@RequestMapping(value = "/imagenUsuario/{nickName}", method = RequestMethod.GET)
	public ResponseEntity<FileSystemResource> getFile(@PathVariable("nickName") String nickName) {

		try {
			System.out.println("nickname "+ nickName);

			String nombreFicheroConImagen;
			if(nickName.equals("Desconocido") || nickName.equals("") ) {
				nombreFicheroConImagen = "Desconocido.jpg";
			}else {
				Usuario user = loginService.encontrarUsuarioPorNickName(nickName);
				nombreFicheroConImagen = user.getNombreFicheroConImagen();

			}
			System.out.println("nombreFicheroConImagen3 "+nombreFicheroConImagen);
			FileSystemResource resource = fileService.getImagenUsuario(nombreFicheroConImagen);
			if (!resource.exists()) {
				throw new Exception("La imagen no existe");
			}
			ResponseEntity<FileSystemResource> responseEntity = new ResponseEntity<>(resource, HttpStatus.OK);
			return responseEntity;
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value= "/update-imagenUsuario", method = RequestMethod.GET)
	public String updateImagenUsuario(ModelMap model, @RequestParam String nickName) {
		model.put("loginNickName", nickName);
		model.put("errores","");
		model.addAttribute("imagenUsuario",new ImagenUsuario(nickName));
		return "update-imagenUsuario";
		
		
	}
	
	@RequestMapping(value= "/guardar-imagen-usuario", method = RequestMethod.POST)
	public String guardarImagenUsuario(ModelMap model, @Valid ImagenUsuario imagenUsuario, BindingResult validacion) {
		Usuario usuario = (Usuario) model.getAttribute("usuario");
		System.out.println(usuario.getNickname());
	
		String nickName=imagenUsuario.getNickname();
		MultipartFile fichero =imagenUsuario.getImagen();
//		if (validacion.hasErrors()) {
//			return "update-imagenUsuario";
//		}
		if(usuario.getNickname() == "") {
			System.out.println("Redirecciono 1");
			return "redirect:update-imagenUsuario?nickName=" + imagenUsuario.getNickname();
		}else {
			
			fileService.guardaImagenUsuario(imagenUsuario.getImagen(),imagenUsuario.getNickname());
			loginService.modificaUsuario(usuario,usuario.getNickname());
			
		}
		Object result=fileService.guardaImagenUsuario(fichero, nickName);
		
		if (result instanceof ArrayList) {
			@SuppressWarnings("unchecked")
			ArrayList<String> listaErroresAlGuardar = (ArrayList<String>) result;
			
			if(!listaErroresAlGuardar.isEmpty()) {
				String mensajeCompleto="";
				for(String mensaje:listaErroresAlGuardar) {
					mensajeCompleto+=language.getTraduccion(mensaje)+"<br>";
				}
			}
			
		} else if (result instanceof String) {
			String route = (String) result;
			usuario.setNombreFicheroConImagen(route);
			model.addAttribute("imagenUsuario", imagenUsuario);
		}
		return "redirect:update-imagenUsuario?nickName=" + imagenUsuario.getNickname();
		
	}
}
