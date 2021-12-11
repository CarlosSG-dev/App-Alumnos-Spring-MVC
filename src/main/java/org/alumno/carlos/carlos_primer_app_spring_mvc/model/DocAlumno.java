package org.alumno.carlos.carlos_primer_app_spring_mvc.model;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.alumno.carlos.carlos_primer_app_spring_mvc.excepciones.DocumentoAlumnoValido;
import org.springframework.web.multipart.MultipartFile;





public class DocAlumno implements Comparable<DocAlumno>{
	@Pattern(regexp = "[0-9]{8}[A-Za-z]{1}", message = "El dni debe tener 8 números y una letra")
	private String dni;
	@NotNull (message = "El dni no puede estar vacio")
	private Integer id;
	@NotNull ( message = "El tipo no puede estar vacio")
	private String tipo;
	@Size(min = 10, message = "Los comentarios deben tener al menos 10 caracteres")
	private String comentario;
	@DocumentoAlumnoValido
	MultipartFile fichero;
	
	String tipoFichero;
	
	String contentTypeFichero;
	
	
	public DocAlumno(int a) {
		super();
	}
	public DocAlumno(
			@Pattern(regexp = "[0-9]{8}[A-Za-z]{1}", message = "El dni debe tener 8 números y una letra") String dni,
			@NotNull(message = "El dni no puede estar vacio") Integer id,
			@NotNull(message = "El tipo no puede estar vacio") String tipo,
			@Size(min = 10, message = "Los comentarios deben tener al menos 10 caracteres") String comentario) {
		super();
		this.dni = dni;
		this.id = id;
		this.tipo = tipo;
		this.comentario = comentario;
	}
	
	
	
	
	public DocAlumno(
			@Pattern(regexp = "[0-9]{8}[A-Za-z]{1}", message = "El dni debe tener 8 números y una letra") String dni,
			@NotNull(message = "El dni no puede estar vacio") Integer id,
			@NotNull(message = "El tipo no puede estar vacio") String tipo,
			@Size(min = 10, message = "Los comentarios deben tener al menos 10 caracteres") String comentario,
			MultipartFile fichero) {
		super();
		this.dni = dni;
		this.id = id;
		this.tipo = tipo;
		this.comentario = comentario;
		this.fichero = fichero;
	}
	public MultipartFile getFichero() {
		return fichero;
	}
	public void setFichero(MultipartFile fichero) {
		this.fichero = fichero;
	}
	public String getTipoFichero() {
		return tipoFichero;
	}
	public void setTipoFichero(String tipoFichero) {
		this.tipoFichero = tipoFichero;
	}
	public String getContentTypeFichero() {
		return contentTypeFichero;
	}
	public void setContentTypeFichero(String contentTypeFichero) {
		this.contentTypeFichero = contentTypeFichero;
	}
	public DocAlumno() {
		super();
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	@Override
	public int compareTo(DocAlumno doc) {
		// TODO Auto-generated method stub
		return this.id-doc.getId();
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DocAlumno other = (DocAlumno) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
