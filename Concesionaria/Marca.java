public class Marca {
	private String nombre;

public Marca(String mar){
	nombre=mar;
}			

public boolean sosMarca(String str){
	return(nombre.equalsIgnoreCase(str));
}

public String getNombre() {
	return nombre;
}

}
