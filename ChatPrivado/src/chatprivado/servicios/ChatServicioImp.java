package chatprivado.servicios;

import chatprivado.accessoadatos.ListaMensajes;
import chatprivado.accessoadatos.ListaUsuarios;
import chatprivado.models.Mensaje;
import chatprivado.models.Usuario;

public class ChatServicioImp implements ChatServicio {
private static ChatServicioImp chatServicio = new ChatServicioImp();
	
	private ChatServicioImp() {}
	
	public static ChatServicioImp getInstancia() { return chatServicio; }
	@Override
	public boolean EnviarMensaje(Mensaje msj) {
		if(ListaMensajes.getInstancia().insert(msj)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean RecibirMensaje() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Usuario> DevolverConectados() {
		Iterable<Usuario> usuarios = ListaUsuarios.getInstancia().getAll();
		return usuarios;
	}
	
	@Override
	public Iterable<Mensaje> DevolverMensajes() {
		Iterable<Mensaje> mensajes = ListaMensajes.getInstancia().getAll();
		return mensajes;
	}
}
