package org.alumno.carlos.carlos_primer_app_spring_mvc.srv;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.alumno.carlos.carlos_primer_app_spring_mvc.model.Usuario;
import org.alumno.carlos.carlos_primer_app_spring_mvc.utils.Ts;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	private static List<Usuario> usuarios = new ArrayList<Usuario>();
	
	static {
		usuarios.add(new Usuario("joseramon", "joseramon", "miPassword@1","joserra.jpg"));
		usuarios.add(new Usuario("carlos", "carlos", "1234","carlos.jpg"));
	}
	

		

	public boolean usuarioValido(Usuario user) {
		Optional<Usuario> _user = usuarios.stream()
				.filter(u -> u.getNickname().equals(user.getNickname()) && u.getPassword().equals(user.getPassword()))
				.findFirst();
		return _user.isPresent();
	}
	
	public Usuario encontrarUsuarioPorNickName(String nickname) {
//		Optional<Usuario> _user = usuarios.stream().filter(u -> u.getNickname().equals(nickname)).findFirst();
//		return _user.isPresent() ? _user.get() : null;
		
		for (Usuario usuario : usuarios) {
			if(usuario.getNickname().equals(nickname)) {
				return usuario;
			}
		}
		return null;
		
		

	}
	
	public void modificaUsuario(Usuario usuarioModificado, String usuarioModificacion){
		Usuario usuario = encontrarUsuarioPorNickName(usuarioModificacion);
		if(usuario != null) {
			for(int i = 0; i < usuarios.size(); i++) {
				if(usuarios.get(i).getNickname().contentEquals(usuarioModificado.getNickname())) {
					usuarioModificado.setTs(Ts.today());
					usuarioModificado.setUser(usuarioModificacion);
					usuarios.set(i, usuarioModificado);
					break;
				}
			}
		}
	}
}
