
public abstract class Auto {
		private Marca marca;
		private String modelo;
		private float precioVenta;
		private float costo;
		private Moneda mon;
		private int stock;

public Auto(Marca ma,String mo,float pre,float c,Moneda m,int str){
	marca=ma;
	modelo=mo;
	precioVenta=pre;
	costo=c;
	mon=m;
	stock=str;
}

public boolean sosModelo(String mod){
	return(modelo.equalsIgnoreCase(mod));
}//Cierra metodo sosMoneda

public float darGanancia(){
	float gananciatotal=this.darGananciaUnidad()*stock;
	return(gananciatotal);
}
public void mostrate() {
	System.out.printf("%s - %s - Stock-> %d - Precio Venta -> %.0f - Costo-> %.0f - Moneda -> %s - ganancia -> %.0f \n", marca.getNombre(),
			this.getModelo(),stock,precioVenta,costo, mon.getNombre(), this.darGananciaUnidad());
}

public Marca getMarca() {
	return marca;
}

public String getModelo() {
	return modelo;
}

public float getPrecioventa() {
	return precioVenta;
}

public float getCosto() {
	return costo;
}

public float darGananciaUnidad() {
	float cambioapeso=(costo*mon.getValorDeCambio());
	float gananciaxunidad=precioVenta-cambioapeso;
	return gananciaxunidad;
}
public int getStock() {
	return stock;
}
public void setStock(){
	stock=stock+1;
}
}//Cierra clase auto
