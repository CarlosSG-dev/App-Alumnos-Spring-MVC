package org.alumno.carlos.carlos_primer_app_spring_mvc.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.alumno.carlos.carlos_primer_app_spring_mvc.excepciones.ImagenValida;
import org.springframework.web.multipart.MultipartFile;


	public class ImagenUsuario implements Serializable{
		
		private static final long serialVersionUID = 1L;
		@Size(min=5,message="El usuario debe de tener un tamaño mínimo de 5 carácteres")
		private String nickname;
		@NotNull
		
		private MultipartFile imagen; /** @ImagenValida */
		
		public ImagenUsuario() {
		}
		public ImagenUsuario(String nickname,MultipartFile imagen) {
			this.nickname = nickname;
			this.imagen = imagen;
		}
		public ImagenUsuario(String nickname) {
			this.nickname = nickname;
		}
		public String getNickname() {
			return nickname;
		}
		public void setNickname(String nickname) {
			this.nickname = nickname;
		}
		public MultipartFile getImagen() {
			return imagen;
		}
		public void setImagen(MultipartFile imagen) {
			this.imagen = imagen;
		}
	}

