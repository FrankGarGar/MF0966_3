package chatprivado.servicios;

import chatprivado.models.Mensaje;
import chatprivado.models.Usuario;

public interface ChatServicio {
	
	public boolean EnviarMensaje(Mensaje msj);
	public boolean RecibirMensaje();
	public Iterable<Usuario> DevolverConectados();
	public Iterable<Mensaje> DevolverMensajes();
}
