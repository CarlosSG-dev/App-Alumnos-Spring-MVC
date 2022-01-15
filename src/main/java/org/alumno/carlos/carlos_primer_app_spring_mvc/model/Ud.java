package org.alumno.carlos.carlos_primer_app_spring_mvc.model;

import java.util.Date;
import java.util.Objects;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

public class Ud implements Comparable<Ud>{

	private static final long serialVersionUID = 1L;
	
	@Size(min = 1, message = "El idModulo no puede estar vacio")
	private int idModulo;
	
	@Size(min = 5, message = "El nombre debe tener almenos 5 carácteres")
	private String nombre;
	
	private int id;
	
	
	
	
	
	@Range(min = 2, max = 8, message = "Las horas deben de estar entre 2 y 8")
	private int horas;
	

	private int orden;
	
	private String user;
	private Date ts;
	

	
	public Ud() {
		super();
	}
	
	
	


	
	public Ud(@Size(min = 1, message = "El idModulo no puede estar vacio") int idModulo,
			@Size(min = 5, message = "El nombre debe tener almenos 5 carácteres") String nombre, int id, 
			
			@Range(min = 2, max = 8, message = "Las horas deben de estar entre 2 y 8") int horas,
			int orden) {
		super();
		this.idModulo = idModulo;
		this.nombre = nombre;
		this.id = id;
		this.horas = horas;
		this.orden = orden;
	}






	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getOrden() {
		return orden;
	}
	public void setOrden(Integer orden) {
		this.orden = orden;
	}
	public Integer getHoras() {
		return horas;
	}
	public void setHoras(Integer horas) {
		this.horas = horas;
	}
	public Integer getIdModulo() {
		return idModulo;
	}
	public void setIdModulo(Integer idModulo) {
		this.idModulo = idModulo;
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(horas, id, idModulo, nombre, orden);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ud other = (Ud) obj;
		return Objects.equals(horas, other.horas) && Objects.equals(id, other.id)
				&& Objects.equals(idModulo, other.idModulo) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(orden, other.orden);
	}
	@Override
	public int compareTo(Ud o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	
	
}
