package com.ipartek.formacion.mf0967_3.accesodatos;

import java.sql.*;

public class Conexion {
	private Connection con;
	private Statement s;
	public static void main(String[] args) {
		try {
			String uri = "jdbc:mysql://localhost:3307/libreria?serverTimezone=UTC";

			try (Connection con = DriverManager.getConnection(uri, "root", "admin")) {

				System.out.println("Conectado");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Conexion() {
		try {
			String uri = "jdbc:mysql://localhost:3307/libreria?serverTimezone=UTC";
			
			try (Connection con = DriverManager.getConnection(uri, "root", "admin")) {
				this.con = con;
				System.out.println("Conectado");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet SelectLibros(String tabla) {
		try {
			try (Statement s = this.con.createStatement()) {
	
				String sql = "SELECT * FROM " + tabla;
	
				try (ResultSet rs = s.executeQuery(sql)) {
	
					while (rs.next()) {
						System.out.println(rs.getString("titulo") + ", " + rs.getString("autor"));
	
					}
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
}
//		try {
//			String uri = "jdbc:mysql://localhost:3307/libreria?serverTimezone=UTC";
//
//			try (Connection con = DriverManager.getConnection(uri, "root", "admin")) {
//
//				System.out.println("Conectado");
//
//				try (Statement s = con.createStatement()) {
//
//					String sql = "SELECT titulo, autor FROM libros";
//		
//					try (ResultSet rs = s.executeQuery(sql)) {
//
//						while (rs.next()) {
//							System.out.println(rs.getString("titulo") + ", " + rs.getString("autor"));
//
//						}
//					}
//				}
//
//				int id = 1;
//
//				String sql = "SELECT * FROM libros WHERE id=?";
//
//				try (PreparedStatement ps = con.prepareStatement(sql)) {
//
//					ps.setInt(1, id);
//
//					try (ResultSet rs = ps.executeQuery()) {
//						while (rs.next()) {
//							System.out.println(rs.getString("autor"));
//						}
//					}
//				}
//
//				String descripcion = "Modificada";
//				id = 1;
//				
//				sql = "UPDATE libros SET descripcion=? WHERE id=?";
//				
//				try (PreparedStatement ps = con.prepareStatement(sql)) {
//
//					ps.setString(1, descripcion);
//					ps.setInt(2, id);
//					
//					ps.executeUpdate();
//				}
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
