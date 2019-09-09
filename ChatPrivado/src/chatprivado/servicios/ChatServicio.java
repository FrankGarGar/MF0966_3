package chatprivado.servicios;

import chatprivado.accessoadatos.ListaUsuarios;

public interface ChatServicio {
	
	public boolean EnviarMensaje();
	public boolean RecibirMensaje();
	public Iterable DevolverConectados();
}
