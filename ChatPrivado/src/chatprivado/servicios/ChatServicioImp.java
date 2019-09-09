package chatprivado.servicios;

import chatprivado.accessoadatos.ListaUsuarios;
import chatprivado.models.Usuario;

public class ChatServicioImp implements ChatServicio {
private static ChatServicioImp chatServicio = new ChatServicioImp();
	
	private ChatServicioImp() {}
	
	public static ChatServicioImp getInstancia() { return chatServicio; }
	@Override
	public boolean EnviarMensaje() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean RecibirMensaje() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable DevolverConectados() {
		Iterable usuarios = ListaUsuarios.getInstancia().getAll();
		return usuarios;
	}

}
