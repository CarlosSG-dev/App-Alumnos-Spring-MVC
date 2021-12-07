package org.alumno.carlos.carlos_primer_app_spring_mvc.srv;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;



@Service
public class FileService {

	private static final String USER_HOME_TOMCAT= System.getProperty("user.home");
	
	private static final String SEPARATOR= File.separator;
	
	private static final String CARPETA_FICHEROS_DINAMICOS_WEBAPP=USER_HOME_TOMCAT+SEPARATOR+"AlumnosWebApp_DynamicFiles"+SEPARATOR;
	
	private static final String CARPETA_IMAGENES_USUARIOS=CARPETA_FICHEROS_DINAMICOS_WEBAPP+"ImagenesUsuarios";
	
	private static final List<String> tiposDeImagenes=Arrays.asList("image/png", "image/jpg", "image/jpeg", "image/gif");
	
	
	public FileSystemResource getImagenUsuario(String fichero) {
		return new FileSystemResource(new File(CARPETA_IMAGENES_USUARIOS, fichero));
		
	}
	
}
