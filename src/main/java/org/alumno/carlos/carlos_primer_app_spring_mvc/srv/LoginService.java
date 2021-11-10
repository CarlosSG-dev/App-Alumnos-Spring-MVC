package org.alumno.carlos.carlos_primer_app_spring_mvc.srv;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public boolean UsuarioValido(String usuario, String password) {
		if(usuario.contentEquals("carlos") && password.contentEquals("1234")) {
			return true;
		}else {
			return false;
		}
			
	}
}
