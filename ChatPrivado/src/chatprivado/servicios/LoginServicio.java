package chatprivado.servicios;

import chatprivado.models.Usuario;

public interface LoginServicio {
	boolean autenticar(Usuario login);
}
