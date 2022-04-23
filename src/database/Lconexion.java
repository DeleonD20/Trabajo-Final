package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;

public class Lconexion {
    
    static Connection contacto = null;
    public static String usuario;
    public static String password;
    public static boolean status = false;
    
    public static Connection getConexion(){
        try {
            final String Controlador = "com.mysql.jdbc.Driver";
            Class.forName(Controlador);
            final String url_bd = "jdbc:mysql://localhost:3306/usuarios";
            contacto = DriverManager.getConnection(url_bd, "root", "Ddcc.02246");
            Statement sentencia = contacto.createStatement();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error ", JOptionPane.ERROR_MESSAGE);
        }
		return contacto;
    }
    
    
    public static void setcuenta(String usuario, String password){
        Lconexion.usuario = "root";
        Lconexion.password = "Ddcc.02246";
    }
    
    public static boolean getstatus(){
        return  status;
    }
    
    public static ResultSet Consulta(String consulta){
        Connection con = getConexion();
        Statement declara;
        try{
            declara=con.createStatement();
            ResultSet respuesta = declara.executeQuery(consulta);
            return respuesta;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(),
            "Error de Conexion",JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
}
