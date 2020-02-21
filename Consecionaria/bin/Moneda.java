package Consecionaria;

public class Moneda {
	
	private String nombre;
	private int cotizacion;
	
	public Moneda(String nombre, int cotizacion) {
		this.nombre = nombre;
		this.cotizacion = cotizacion;
	}
	
	public String darNombre() {
		return this.nombre;
	}
	
	public int darCotizacion() {
		return this.cotizacion;
	}
	
	public boolean sosMoneda(String nom) {
		if(nombre.equalsIgnoreCase(nom))
			return true;
		else
			return false;
	}
}
