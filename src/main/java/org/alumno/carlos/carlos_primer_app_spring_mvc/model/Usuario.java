package org.alumno.carlos.carlos_primer_app_spring_mvc.model;

import java.util.Date;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class Usuario {

		@Length(min = 5, message = "El usuario debe tener un tamaño mínimo de 5 carácteres.")
		private String nickname;
		private String nombre;
		@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,16}$", message = "La contraseña debe contener entre 8 y 16 carácteres, un dígito, una mayúscula, una minúscula y un carácter especial.")
		private String password;
		private String nombreFicheroConImagen;
		private Date ts;
		private String user;
		
		
		


		public String getNombreFicheroConImagen() {
			return nombreFicheroConImagen;
		}


		public void setNombreFicheroConImagen(String nombreFicheroConImagen) {
			this.nombreFicheroConImagen = nombreFicheroConImagen;
		}


		public Date getTs() {
			return ts;
		}


		public void setTs(Date ts) {
			this.ts = ts;
		}


		public String getUser() {
			return user;
		}


		public void setUser(String user) {
			this.user = user;
		}


		public Usuario(
				@Length(min = 5, message = "El usuario debe tener un tamaño mínimo de 5 carácteres.") String nickname,
				String nombre,
				@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,16}$", message = "La contraseña debe contener entre 8 y 16 carácteres, un dígito, una mayúscula, una minúscula y un carácter especial.") String password,
				String nombreFicheroConImagen) {
			super();
			this.nickname = nickname;
			this.nombre = nombre;
			this.password = password;
			this.nombreFicheroConImagen = nombreFicheroConImagen;
		}


		public Usuario() {
			super();
			// TODO Auto-generated constructor stub
				this.nombreFicheroConImagen = "Desconocido.jpg";
			
		}


		public String getNickname() {
			return nickname;
		}


		public void setNickname(String nickname) {
			this.nickname = nickname;
		}


		public String getNombre() {
			return nombre;
		}


		public void setNombre(String nombre) {
			this.nombre = nombre;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}
		
		
		
		
}
