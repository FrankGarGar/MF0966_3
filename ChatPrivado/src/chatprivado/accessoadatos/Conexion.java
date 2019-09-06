package chatprivado.accessoadatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	protected static Connection conexion = null;
	private String user = "root";
	private String pass = "admin";
	private String url = "jdbc:mysql://localhost:3307/chatpublico?serverTimezone=UTC";

	public Conexion() {

		try {
			new com.mysql.cj.jdbc.Driver();
			conexion = DriverManager.getConnection(url, user, pass);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
	}
	public static void closeConexion() {
		if(conexion!=null) {
			try {
				conexion.close();
			} catch (SQLException e) {
				System.out.println("Error al intentar cerrar la conexión");
			}
		}
	}
}
