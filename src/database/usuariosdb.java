package database;

public class usuariosdb {
	private String Usuario;
	private String Password;
	private String Nombre;
	private String Apellido;
	private String Correo;
	private String ID;
	
	public String getID() {
	    return ID;
	}
	
	public String getUsuario() {
	    return Usuario;
	  }
	public void setUsuario(String newUsuario) {
		this.Usuario = newUsuario;
		}
	
	
	public String getPassword() {
		return Password;
	}
	public void setPassword(String newPassword) {
		this.Password = newPassword;
	}
	
	public String getNombre() {
	    return Nombre;
	  }
	public void setNombre(String newNombre) {
		this.Nombre= newNombre;
		}
	
	public String getApellido() {
	    return Apellido;
	  }
	public void setApellido(String newApellido) {
		this.Apellido = newApellido;
		}
	public String getCorreo() {
	    return Correo;
	  }
	public void setCorreo(String newCorreo) {
		this.Correo= newCorreo;
		}
}
