package chatprivado.accessoadatos;

import java.util.TreeMap;
import java.sql.*;
import chatprivado.models.Usuario;

public class ListaUsuarios extends Conexion implements Procesos<Usuario>,ListaUsuariosInterf<Usuario>{
	public static ListaUsuarios getInstancia() {
		return new ListaUsuarios();
	}
	private TreeMap<Long, Usuario> usuarios = new TreeMap<>();

	@Override
	public Iterable<Usuario> getAll() {
		
		return usuarios.values();
	}
	private ListaUsuarios() {
		ResultSet rs = SelectUsuarios();
	}
	@Override
	public Usuario getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void insert(Usuario o) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(Usuario o) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Usuario getByUsername(String username) {
		for(Usuario usuario: getAll()) {
			if(username.equals(usuario.getUsername())) {
				return usuario;
			}
		}
		
		return null;
	}
	public ResultSet SelectUsuarios() {
		ResultSet rs = null;
		Statement s = null;
		String sql = "SELECT id,username,password FROM zxcv_usuarios";
			try {
				s = conexion.createStatement();
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				
			}
		return null;
	}
	
}
