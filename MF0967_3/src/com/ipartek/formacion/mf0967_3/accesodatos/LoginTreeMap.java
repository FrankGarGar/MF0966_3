package com.ipartek.formacion.mf0967_3.accesodatos;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeMap;

import com.ipartek.formacion.mf0967_3.modelo.Libro;
import com.ipartek.formacion.mf0967_3.modelo.Login;

public class LoginTreeMap extends Conexion implements LoginCrudAble {

	private static LoginTreeMap instancia;
	
	public static LoginTreeMap getInstancia() {
		return instancia = new LoginTreeMap();
	}
	
	private TreeMap<Long, Login> logins = new TreeMap<>();
	
	private LoginTreeMap() {
		ResultSet ls = SelectUsuarios();
		
		try {
			while (ls.next()) {
				logins.put(ls.getLong("id"),new Login(ls.getString("usuario"),ls.getString("password")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	public ResultSet SelectUsuarios() {
		ResultSet rs = null;
		Statement s = null;
		try {
			s = super.con.createStatement();
			String sql = "SELECT * FROM usuarios";

			try {
				rs = s.executeQuery(sql);
				return rs;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

}
