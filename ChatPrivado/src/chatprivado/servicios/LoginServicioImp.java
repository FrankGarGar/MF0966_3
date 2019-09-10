package chatprivado.servicios;

import chatprivado.accessoadatos.ListaUsuarios;
import chatprivado.models.Usuario;

public class LoginServicioImp implements LoginServicio{
	
	private static LoginServicioImp loginServicio = new LoginServicioImp();
	
	private LoginServicioImp() {}
	
	public static LoginServicioImp getInstancia() { return loginServicio; }
	@Override
	public Usuario autenticar(Usuario usuario) {
		
		Usuario encontrado = ListaUsuarios.getInstancia().getByUsername(usuario.getUsername());
		
		if(encontrado != null && encontrado.getPassword().equals(usuario.getPassword())) {
			return encontrado;
		}else {

			return null;
		}
	}
}
