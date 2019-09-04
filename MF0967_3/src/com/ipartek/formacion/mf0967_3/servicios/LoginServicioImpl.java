package com.ipartek.formacion.mf0967_3.servicios;

import com.ipartek.formacion.mf0967_3.accesodatos.LoginTreeMap;
import com.ipartek.formacion.mf0967_3.modelo.Login;

public class LoginServicioImpl implements LoginServicio {

	private static LoginServicioImpl loginServicioImpl = new LoginServicioImpl();
	
	private LoginServicioImpl() {}
	
	public static LoginServicioImpl getInstancia() { return loginServicioImpl; }
	
	@Override
	public boolean autenticar(Login login) {
		Login encontrado = LoginTreeMap.getInstancia().getByEmail(login.getEmail());
		
		return encontrado != null && encontrado.getPassword().equals(login.getPassword());
	}

}
