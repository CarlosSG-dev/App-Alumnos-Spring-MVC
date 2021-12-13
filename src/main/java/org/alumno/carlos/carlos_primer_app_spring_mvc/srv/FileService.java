package org.alumno.carlos.carlos_primer_app_spring_mvc.srv;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.alumno.carlos.carlos_primer_app_spring_mvc.excepciones.ValidadorDocumentoAlumno;
import org.alumno.carlos.carlos_primer_app_spring_mvc.excepciones.ValidadorImagenes;
import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



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
	
	public FileSystemResource getDocumentoAlumno(String fichero) {
		return new FileSystemResource(new File(CARPETA_IMAGENES_USUARIOS, fichero));
	}
	
	public String guardarFichero(String ruta, String filename, MultipartFile fichero) {
		try {
			//Obtener datos del fichero
			byte[] fileBytes = fichero.getBytes();
			//Obtener ruta
			Path path = Paths.get(ruta + SEPARATOR + filename);
			//Guardar fichero
			//El fichero no tiene porque existir en la ruta, pero 
			//si la carpeta destino no existe se producirá una excepción
			File directory = new File(ruta);
		    if (! directory.exists()){
		        directory.mkdirs();
		    }
			
			
			Files.write(path, fileBytes);
			
		}catch(NoSuchFileException e) {
			return "No existe la carpeta para poder guardar '"+e.getMessage()+"'";
		}catch(IOException e) {
			return e.getMessage();
		}
		return null;
	}
	
	public Object guardaImagenUsuario(MultipartFile fichero, String nickName) {
		String nombreFichero= getNombreImagenUsuario(fichero,nickName);
		System.out.println("nombreFichero "+nombreFichero);
		if(!ValidadorImagenes.imagenValida(fichero)) {
			return ValidadorImagenes.mensajesErrorImagen(fichero);
		}
		
		String errorAlGuardar=guardarFichero(CARPETA_IMAGENES_USUARIOS, nombreFichero, fichero);
			if(errorAlGuardar==null)
				return nombreFichero;
			else
				return new ArrayList<String>(List.of(errorAlGuardar));
	}
	
	public String getNombreImagenUsuario(MultipartFile fichero, String nickName) {
		String extension= ValidadorImagenes.getExtension(fichero);
		String nombreFichero= nickName+"."+extension;
		System.out.println("extension "+extension);
		return nombreFichero;
	}
	public String getNombreDocumentoAlumno(MultipartFile fichero, String nickName) {
		String extension= ValidadorDocumentoAlumno.getExtension(fichero);
		String nombreFichero= nickName;
		System.out.println("extension "+extension);
		return nombreFichero;
	}
	
	
	public String getExtensionMultipartFile(MultipartFile fichero) {
		String extension="";
		
		if(ValidadorDocumentoAlumno.tiposDeDocumentos.contains(fichero.getContentType())) {
			extension = FilenameUtils.getExtension(fichero.getOriginalFilename());
			return extension;
			}else {
				return "";
			}
		}
	
	public ArrayList<String> guardaDocumentoAlumno(MultipartFile fichero, String nickName) {
		String nombreFichero= getNombreDocumentoAlumno(fichero,nickName);
		System.out.println("nombreFichero "+nombreFichero);
		if(!ValidadorDocumentoAlumno.DocumentoValido(fichero)) {
			return ValidadorDocumentoAlumno.mensajesErrorDocumento(fichero);
		}
		
		String errorAlGuardar=guardarFichero(CARPETA_IMAGENES_USUARIOS, nombreFichero,fichero);
			if(errorAlGuardar==null)
				return new ArrayList<String>();
			else
				return new ArrayList<String>(List.of(errorAlGuardar));
	}
	
}
