package database;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;

public class Conexion {
	private final String db = "usuarios";
	private final String user = "root";
	private final String password = "Ddcc.02246";
	private final String url = "jdbc:mysql://localhost:3306/"+db;
	private Connection con = null;
	
	public Connection getConexion() {
		try {
			con = (Connection) DriverManager.getConnection(url, user, password);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}

 