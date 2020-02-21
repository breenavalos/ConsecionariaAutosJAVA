
public class Moneda {
	private String nombre;
	private float valorDeCambio;
	private String origen;

public Moneda(String str, float v, String ori ){
	nombre=str;
	valorDeCambio=v;
	origen=ori;
}

public boolean sosMon(String str){
	return(nombre.equalsIgnoreCase(str));
}

public String getNombre() {
	return nombre;
}

public float getValorDeCambio() {
	return valorDeCambio;
}
public void mostrate()
{
	System.out.println(nombre+' '+valorDeCambio + ' ' + origen);
}

public boolean sosNacional()
{
	return(origen.equalsIgnoreCase("Nacional"));
}
	
}//Cierra clase moneda
