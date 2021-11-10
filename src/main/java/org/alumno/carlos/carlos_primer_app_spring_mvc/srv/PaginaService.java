package org.alumno.carlos.carlos_primer_app_spring_mvc.srv;

import org.alumno.carlos.carlos_primer_app_spring_mvc.model.Pagina;
import org.springframework.stereotype.Service;

@Service
public class PaginaService {
	
	private static Pagina pagina=new Pagina("Login", "Home");

	public static Pagina getPagina() {
		
		return pagina;
	}

	public static void setPagina(Pagina pagina) {
		PaginaService.pagina = pagina;
	}
	
}
