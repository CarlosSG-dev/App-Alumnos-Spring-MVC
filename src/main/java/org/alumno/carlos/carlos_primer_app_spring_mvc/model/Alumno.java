package org.alumno.carlos.carlos_primer_app_spring_mvc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.alumno.carlos.carlos_primer_app_spring_mvc.model.interfaces.Modificable;
import org.alumno.carlos.carlos_primer_app_spring_mvc.utils.Ts;
import org.hibernate.validator.constraints.Range;

public class Alumno implements Serializable, Comparable<Alumno>, Modificable<Alumno>{
	private static final long serialVersionUID = 1L;
	@Size(min = 4, message = "El nombre debe tener almenos 4 carácteres")
	private String nombre;
	@Pattern(regexp = "[0-9]{8}[A-Za-z]{1}", message = "El dni debe tener 8 números y una letra")
	private String dni;
	@Digits(fraction = 0, integer = 2, message = "La edad debe ser igual o mayor a 18 y menor o igual a 99")
	@Range(min = 18, max = 99, message = "La edad debe ser igual o mayor a 18 y menor o igual a 99")
	private int edad;
	@Size(min = 3, message = "El ciclo debe tener almenos 3 carácteres")
	private String ciclo;
	@Digits(fraction = 0, integer = 1, message = "El curso debe ser 1 o 2")
	@Range(min = 1, max = 2, message = "El curso debe ser 1 o 2")
	private int curso;
	private String user;
	private Date ts;
	
	
	private boolean erasmus;
	private String[] interesadoEn;
	private String [] lenguajeFavorito;
	private String genero;
	private String horario;
	private String pais;
	private ArrayList<Integer> matriculadoen;
	private String hobbies;
	
	public Alumno(String nombre, String dni, int edad, String ciclo, int curso) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.edad = edad;
		this.ciclo = ciclo;
		this.curso = curso;
	}
	
	public Alumno(@Size(min = 4, message = "El nombre debe tener almenos 4 carácteres") String nombre,
			@Pattern(regexp = "[0-9]{8}[A-Za-z]{1}", message = "El dni debe tener 8 números y una letra") String dni,
			@Digits(fraction = 0, integer = 2, message = "La edad debe ser igual o mayor a 18 y menor o igual a 99") @Range(min = 18, max = 99, message = "La edad debe ser igual o mayor a 18 y menor o igual a 99") int edad,
			@Size(min = 3, message = "El ciclo debe tener almenos 3 carácteres") String ciclo,
			@Digits(fraction = 0, integer = 1, message = "El curso debe ser 1 o 2") @Range(min = 1, max = 2, message = "El curso debe ser 1 o 2") int curso,
			boolean erasmus, String genero, String horario, String pais, ArrayList<Integer> matriculadoen,
			String hobbies) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.edad = edad;
		this.ciclo = ciclo;
		this.curso = curso;
		this.erasmus = erasmus;
		this.genero = genero;
		this.horario = horario;
		this.pais = pais;
		this.matriculadoen = matriculadoen;
		this.hobbies = hobbies;
	}

	public Alumno() {
		super();
	}
	
	

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public ArrayList<Integer> getMatriculadoen() {
		return matriculadoen;
	}

	public void setMatriculadoen(ArrayList<Integer> matriculadoen) {
		this.matriculadoen = matriculadoen;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public boolean isErasmus() {
		return erasmus;
	}

	public void setErasmus(boolean erasmus) {
		this.erasmus = erasmus;
	}

	public String[] getInteresadoEn() {
		return interesadoEn;
	}

	public void setInteresadoEn(String[] interesadoEn) {
		this.interesadoEn = interesadoEn;
	}

	public String[] getLenguajeFavorito() {
		return lenguajeFavorito;
	}

	public void setLenguajeFavorito(String[] lenguajeFavorito) {
		this.lenguajeFavorito = lenguajeFavorito;
	}

	
	

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}

	public Alumno(String nombre) {
		super();
		this.nombre = nombre;
	}

	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public Date getTs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTs(Date ts) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUser(String user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", dni=" + dni + ", edad=" + edad + ", ciclo=" + ciclo + ", curso=" + curso
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Alumno a) {
		return this.nombre.compareTo(a.getNombre());
	}
	
	@Override
	public boolean sePuedeModificarUtilizando(Alumno itemModificado) {
		if(this.getUser()!=null && this.getTs()!= null) {
			String usuarioActual = this.getUser();
			String usuarioModificado = itemModificado.getUser();
			
			Date fechaActual = Ts.parseIso(Ts.formatIso(itemModificado.getTs()));
			Date fechaModificada = Ts.parseIso(Ts.formatIso(itemModificado.getTs()));
			
			if(!usuarioActual.equals(usuarioModificado) || !fechaActual.equals(fechaModificada)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String noSePuedeModificar() {
		String msg="\r\n\t[ERROR]\r\n<br/>" +
					"\t$item ha sido modificado por otro usuarioi.\r\n<br/>" +
					"\tPara evitar la pérdida de información se impide guardar '$item'. \r\n<br/>" +
					"\tÚltima modificación realizada por [" + this.getUser() +"] el [" + Ts.ts(this.getTs()) + "]\r\n<br/>";
		
		return msg.replace("$item", "Alumno");
	}
	
	
}
