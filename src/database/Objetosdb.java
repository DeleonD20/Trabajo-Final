package database;

public class Objetosdb {
	private String Nombre;
	private String Precio;
	private String Marca;
	private String Categoria;
	private String Cantidad;
	private String ID;
	
	public String getID() {
	    return ID;
	}
	
	public String getNombre() {
	    return Nombre;
	  }
	public void setNombre(String newNombre) {
		this.Nombre = newNombre;
		}
	
	
	public String getPrecio() {
		return Precio;
	}
	public void setPrecio(String newPrecio) {
		this.Precio = newPrecio;
	}
	
	public String getMarca() {
	    return Marca;
	  }
	public void setMarca(String newMarca) {
		this.Marca= newMarca;
		}
	
	public String getCategoria() {
	    return Categoria;
	  }
	public void setCategoria(String newCategoria) {
		this.Categoria = newCategoria;
		}
	public String getCantidad() {
	    return Cantidad;
	  }
	public void setCantidad(String newCantidad) {
		this.Cantidad= newCantidad;
		}
}
