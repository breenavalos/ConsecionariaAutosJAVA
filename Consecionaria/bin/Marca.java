package Consecionaria;

public class Marca {
	
	private String nombre;
	
	public Marca(String nombre) {
		this.nombre = nombre;
	}
	
	public String darNombre() {
		return nombre;
	}
	
	public boolean sosMarca(String nom) {
		if(nombre.equalsIgnoreCase(nom))
			return true;
		else
			return false;
	}
}
