package Consecionaria;

public class Auto {
	
	private String modelo;
	private int precioVenta;
	private int costoFabricacion;
	private int stock;
	private Marca marca;
	private Moneda moneda;
	
	public Auto(String modelo, int precioVenta, int costoFabricacion, int stock, Marca marca, Moneda moneda) {
		this.modelo = modelo;
		this.precioVenta = precioVenta;
		this.costoFabricacion = costoFabricacion;
		this.stock = stock;
		this.marca = marca;
		this.moneda = moneda;
	}
	
	//metodos
	public int getGanancia() {
		return ((precioVenta - this.convertirCostoAPesos())*stock);
	}
	
	public int convertirCostoAPesos() {
		return (moneda.darCotizacion() * costoFabricacion);
	}
	
	public String darModelo() {
		return modelo;
	}
	
	public void actualizarStock(int st) {
		stock += st;
	}
	
	public int darStock() {
		return stock;
	}

}
