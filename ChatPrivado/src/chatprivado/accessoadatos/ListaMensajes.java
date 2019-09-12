package chatprivado.accessoadatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeMap;

import chatprivado.models.Mensaje;
import chatprivado.models.Usuario;

public class ListaMensajes extends Conexion implements Procesos<Mensaje>{
	@SuppressWarnings("unused")
	private static ListaMensajes instancia;
	
	public static ListaMensajes getInstancia() {
		return instancia = new ListaMensajes();
	}
	private TreeMap<Long, Mensaje> mensajes = new TreeMap<>();

	@Override
	public Iterable<Mensaje> getAll() {
		ResultSet rs = SelectMensajes();
		try {
			while (rs.next()) {
				Mensaje mensaje = new Mensaje(rs.getString("mensaje"),new Usuario(rs.getString("username")),rs.getTimestamp("fecha"));
				mensajes.put(rs.getLong("idm"),mensaje);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mensajes.values();
		
	}
	public Iterable<Mensaje> getPrivados(int idcreado,int idrecibido) {
		ResultSet rs = SelectMensajesPrivados(idcreado,idrecibido);
		
		try {
			while (rs.next()) {
				Mensaje mensaje = new Mensaje(rs.getString("mensaje"),new Usuario(rs.getString("username")),rs.getTimestamp("fecha"));
				
				mensajes.put(rs.getLong("idm"),mensaje);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mensajes.values();
	}
	public Iterable<Mensaje> getNexts(String cant) {
		int c = Integer.parseInt(cant);
		ResultSet rs = SelectNewMessages(c);
		try {
			while (rs.next()) {
				Mensaje mensaje = new Mensaje(rs.getString("mensaje"),new Usuario(rs.getString("username")),rs.getTimestamp("fecha"));
				
				mensajes.put(rs.getLong("idm"),mensaje);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mensajes.values();
		
	}
	public Iterable<Mensaje> getNextsPrivados(int cant,int idrec,int idlog) {
		
		ResultSet rs = SelectNewMessagesPrivados(cant,idrec,idlog);
		try {
			while (rs.next()) {
				Mensaje mensaje = new Mensaje(rs.getString("mensaje"),new Usuario(rs.getString("username")),rs.getTimestamp("fecha"));
				
				mensajes.put(rs.getLong("idm"),mensaje);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mensajes.values();
		
	}
	private ListaMensajes() {
		
	}
	@Override
	public Mensaje getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Mensaje msj) {
		String sql = "INSERT INTO zxcv_mensajespublicos (mensaje,id_usuario,fecha) values (?, ?, ?)";
		
		try {
			try (PreparedStatement ps = conexion.prepareStatement(sql)) {
				
				ps.setString(1,msj.getMensaje());
				ps.setLong(2, msj.getUsuario().getId());
				ps.setTimestamp(3,msj.getFecha2());
				int res =ps.executeUpdate();
				
				if(res==1) {
					return true;
				}
				
			}
		} catch (SQLException e) {
			return false;
		}
		return false;
		
	}
	public boolean insertPrivado(Mensaje msj,int idreceptor) {
		String sql = "INSERT INTO zxcv_mensajesprivados (mensaje,id_creado,id_recibido,fecha) values (?, ?, ?, ?)";
		
		try {
			try (PreparedStatement ps = conexion.prepareStatement(sql)) {
				
				ps.setString(1,msj.getMensaje());
				ps.setLong(2, msj.getUsuario().getId());
				ps.setInt(3,idreceptor);
				ps.setTimestamp(4,msj.getFecha2());
				int res =ps.executeUpdate();
				
				if(res==1) {
					return true;
				}
				
			}
		} catch (SQLException e) {
			return false;
		}
		return false;
		
	}
	@Override
	public void update(Mensaje o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	public ResultSet SelectMensajes() {
		ResultSet rs = null;
		PreparedStatement s = null;
		String sql = "SELECT us.id as idu,us.username,mp.id as idm,mp.mensaje,mp.fecha FROM zxcv_usuarios us INNER JOIN zxcv_mensajespublicos mp ON us.id=mp.id_usuario ORDER BY fecha ASC";
		try {
			s = conexion.prepareStatement(sql);
			try {
				
				rs = s.executeQuery();
				
				return rs;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ResultSet SelectMensajesPrivados(int idcreado, int idrecibido) {
		ResultSet rs = null;
		PreparedStatement s = null;
		String sql = "SELECT us.id as idu,us.username,mp.id as idm,mp.mensaje,mp.fecha FROM zxcv_usuarios us INNER JOIN zxcv_mensajesprivados mp ON us.id=mp.id_creado WHERE ( mp.id_creado=" + idcreado + " AND mp.id_recibido=" + idrecibido + ") OR (mp.id_recibido=" + idcreado + " AND mp.id_creado=" + idrecibido + ") ORDER BY fecha DESC";
		try {
			s = conexion.prepareStatement(sql);
			try {
				
				rs = s.executeQuery();
				
				return rs;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ResultSet SelectNewMessages(int cant) {
		ResultSet rs = null;
		ResultSet rs2 = null;
		PreparedStatement s = null;
		Statement st=null;
		int lim = 0;
		String sql = "SELECT us.id as idu,us.username,mp.id as idm,mp.mensaje,mp.fecha FROM zxcv_usuarios us INNER JOIN zxcv_mensajespublicos mp ON us.id=mp.id_usuario ORDER BY fecha DESC";	
		String sqll = "SELECT us.id as idu,us.username,mp.id as idm,mp.mensaje,mp.fecha FROM zxcv_usuarios us INNER JOIN zxcv_mensajespublicos mp ON us.id=mp.id_usuario ORDER BY fecha DESC LIMIT ?";
		String sql2 = "SELECT COUNT(id) as n FROM zxcv_mensajespublicos";
		try {
			
			
			if(cant!=0) {
				s = conexion.prepareStatement(sqll);
				st = conexion.createStatement();
				rs2 = st.executeQuery(sql2);
				rs2.next();
				
				lim = rs2.getInt("n");
				if(lim>cant) {
					lim = lim-cant;
					s.setInt(1, lim);
					rs = s.executeQuery();
				}else {
				}
				
				rs2.close();
				st.close();
			}else {
				
				s = conexion.prepareStatement(sql);
				rs = s.executeQuery();
			}
				return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ResultSet SelectNewMessagesPrivados(int cant,int idrec,int idlog) {
		ResultSet rs = null;
		ResultSet rs2 = null;
		PreparedStatement s = null;
		PreparedStatement totalSt=null;
		int lim = 0;
		String sql = "SELECT us.id as idu,us.username,mp.id as idm,mp.mensaje,mp.fecha FROM zxcv_usuarios us INNER JOIN zxcv_mensajesprivados mp ON us.id=mp.id_creado WHERE ( mp.id_creado=? AND mp.id_recibido=?) OR (mp.id_recibido=? AND mp.id_creado=?) ORDER BY fecha DESC";
		String sqll = "SELECT us.id as idu,us.username,mp.id as idm,mp.mensaje,mp.fecha FROM zxcv_usuarios us INNER JOIN zxcv_mensajesprivados mp ON us.id=mp.id_creado WHERE ( mp.id_creado=? AND mp.id_recibido=?) OR (mp.id_recibido=? AND mp.id_creado=?) ORDER BY fecha DESC LIMIT ?";
		String sql2 = "SELECT COUNT(id) as n FROM zxcv_mensajesprivados WHERE ( id_creado=" +idrec+" AND id_recibido=" + idlog + ") OR (id_recibido=" + idrec + " AND id_creado=" + idlog + ")";
		try {
			
			if(cant!=0) {
				s = conexion.prepareStatement(sqll);
				totalSt = conexion.prepareStatement(sql2);
				
				rs2 = totalSt.executeQuery(sql2);
				rs2.next();
				lim = rs2.getInt("n")-cant;
				s.setInt(1, idrec);
				s.setInt(2, idlog);
				s.setInt(3, idrec);
				s.setInt(4, idlog);
				s.setInt(5, lim);
				rs = s.executeQuery();
				rs2.close();
				totalSt.close();
			}else {
				s = conexion.prepareStatement(sql);
				s.setInt(1, idrec);
				s.setInt(2, idlog);
				s.setInt(3, idrec);
				s.setInt(4, idlog);
				rs = s.executeQuery();
			}
				
			
				return rs;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
