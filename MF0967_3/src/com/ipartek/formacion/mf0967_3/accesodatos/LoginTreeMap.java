package com.ipartek.formacion.mf0967_3.accesodatos;

import java.util.TreeMap;

import com.ipartek.formacion.mf0967_3.modelo.Login;

public class LoginTreeMap implements LoginCrudAble {

	private static LoginTreeMap instancia = new LoginTreeMap();
	
	public static LoginTreeMap getInstancia() {
		return instancia;
	}
	
	private TreeMap<Long, Login> logins = new TreeMap<>();
	
	private LoginTreeMap() {
		logins.put(1L, new Login(1L, "javier@email.net", "contra"));
		logins.put(2L, new Login(2L, "pepe@email.net", "perez"));
	}
	
	@Override
	public Iterable<Login> getAll() {
		return logins.values();
	}

	@Override
	public Login getById(Long id) {
		return logins.get(id);
	}

	@Override
	public void insert(Login login) {
		Long id = logins.lastKey() + 1;
		login.setId(id);
		logins.put(id, login);
	}

	@Override
	public void update(Login login) {
		logins.put(login.getId(), login);
	}

	@Override
	public void delete(Long id) {
		logins.remove(id);
	}

	@Override
	public Login getByEmail(String email) {
		for(Login login: getAll()) {
			if(email.equals(login.getEmail())) {
				return login;
			}
		}
		
		return null;
	}

}
