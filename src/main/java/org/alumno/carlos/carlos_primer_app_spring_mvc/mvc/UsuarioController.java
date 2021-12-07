package org.alumno.carlos.carlos_primer_app_spring_mvc.mvc;

import org.alumno.carlos.carlos_primer_app_spring_mvc.model.Usuario;
import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.AlumnoService;
import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.FileService;
import org.alumno.carlos.carlos_primer_app_spring_mvc.srv.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.server.ResponseStatusException;

@Controller
@SessionAttributes({"loginName","loginNickName","user"})
public class UsuarioController {

	@Autowired
	LoginService loginService;
	
	@Autowired
	FileService fileService;
	
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
}
