package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class dbInsert extends Conexion {
	public boolean registrar(usuariosdb usr) {
		PreparedStatement ps = null;
		Connection con = getConexion();
		String sql = "INSERT INTO users(Usuario, Password, Nombre, Apellido, Email) VALUES(?,?,?,?,?)";
		
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, usr.getUsuario());
			ps.setString(2, usr.getPassword());
			ps.setString(3, usr.getNombre());
			ps.setString(4, usr.getApellido());
			ps.setString(5, usr.getCorreo());
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return false;
		}
		
	}

	public boolean editar(usuariosdb usr) {
		PreparedStatement ps2 = null;
		Connection con = getConexion();
		String sql2 = "UPDATE users SET Usuario='"+usr.getUsuario()+"',Password='"+usr.getPassword()+"',Nombre='"+usr.getNombre()+"',Apellido='"+usr.getApellido()+"',Email='"+usr.getCorreo()+"'WHERE ID="+usr.getID();
		
		try {
			ps2 = (PreparedStatement) con.prepareStatement(sql2);	
			ps2.setString(1, usr.getID());
			ps2.setString(2, usr.getUsuario());
			ps2.setString(3, usr.getPassword());
			ps2.setString(4, usr.getNombre());
			ps2.setString(5, usr.getApellido());
			ps2.setString(6, usr.getCorreo());
			ps2.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return false;
		}
		
	}
	public boolean registrar2( Objetosdb usr) {
		PreparedStatement ps3 = null;
		Connection con = getConexion();
		String sql3 = "INSERT INTO objetos(Nombre, Marca, Categoria, Precio, Cantidad) VALUES(?,?,?,?,?)";
		
		try {
			ps3 = (PreparedStatement) con.prepareStatement(sql3);
			ps3.setString(1, usr.getNombre());
			ps3.setString(2, usr.getMarca());
			ps3.setString(3, usr.getCategoria());
			ps3.setString(4, usr.getPrecio());
			ps3.setString(5, usr.getCantidad());
			ps3.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return false;
		}
		
	}

	public boolean editar2(Objetosdb usr) {
		PreparedStatement ps4 = null;
		Connection con = getConexion();
		String sql4 = "UPDATE objetos SET Nombre='"+usr.getNombre()+"',Marca='"+usr.getMarca()+"',Categoria='"+usr.getCategoria()+"',Precio='"+usr.getPrecio()+"',Cantidad='"+usr.getCantidad()+"'WHERE ID="+usr.getID();
		
		try {
			ps4 = (PreparedStatement) con.prepareStatement(sql4);	
			ps4.setString(1, usr.getID());
			ps4.setString(2, usr.getNombre());
			ps4.setString(3, usr.getMarca());
			ps4.setString(4, usr.getCategoria());
			ps4.setString(5, usr.getPrecio());
			ps4.setString(6, usr.getCantidad());
			ps4.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return false;
		}
		
	}
}
