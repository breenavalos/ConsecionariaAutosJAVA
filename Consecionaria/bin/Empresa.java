package Consecionaria;

import java.util.ArrayList;
import java.util.Scanner;

public class Empresa {
	
	private ArrayList<Auto> autos;
	private ArrayList<Marca> marcas;
	private ArrayList<Moneda> monedas;
	
	public Empresa() {
		autos = new ArrayList<Auto>();
		marcas = new ArrayList<Marca>();
		monedas = new ArrayList<Moneda>();
	}
	
	public void agregarNuevoAuto() {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Ingrese la marca del auto: ");
		String nomMarca = entrada.next();
		Marca marca = this.buscarMarca(nomMarca);
		if(marca != null) {
			System.out.print("Ingrese el modelo del auto: ");
			String mod = entrada.next();
			boolean existeModelo = this.buscarModeloEntreAutos(mod);
			if(existeModelo) {
				System.out.print("Ingrese nueva cantidad de stock: ");
				int st = entrada.nextInt();
				this.actualizarStock(st,mod);
				System.out.println("Se actualuizó el stock para el " + marca.darNombre() + " " + mod);
				System.out.println("El stock actual es: " + this.buscarAutoSegunModelo(mod).darStock());
			}
			else {
				System.out.print("Ingrese el modelo del auto: ");
				mod = entrada.next();
				System.out.print("Ingrese el precio de venta del auto: ");
				int precio = entrada.nextInt();
				System.out.print("Ingrese la moneda que corresponderá al costo de fabricacion del auto: ");
				String nomMoneda = entrada.next();
				Moneda mon = this.buscarMoneda(nomMoneda);
				System.out.print("Ingrese el costo de fabricacion: ");
				int costoFabric = entrada.nextInt();
				System.out.print("Ingrese la cantidad de stock disponible: ");
				int st = entrada.nextInt();
				Auto a = new Auto(mod, precio, costoFabric, st, marca, mon);
				autos.add(a);
			}
		}
		else {
			marca = new Marca(nomMarca);
			marcas.add(marca);
			System.out.print("Ingrese el modelo del auto: ");
			String mod = entrada.next();
			System.out.print("Ingrese el precio de venta del auto: ");
			int precio = entrada.nextInt();
			System.out.print("Ingrese la moneda que corresponderá al costo de fabricacion del auto: ");
			String nomMoneda = entrada.next();
			Moneda mon = this.buscarMoneda(nomMoneda);
			System.out.print("Ingrese el costo de fabricacion: ");
			int costoFabric = entrada.nextInt();
			System.out.print("Ingrese la cantidad de stock disponible: ");
			int st = entrada.nextInt();
			Auto a = new Auto(mod, precio, costoFabric, st, marca, mon);
			autos.add(a);
		}
	}
	
	public void informarGananciaTotal() {
		int gananciaTotal = 0;
		for(Auto auto: autos) {
			gananciaTotal += auto.getGanancia();
		}
		System.out.print("La ganancia total es: " + gananciaTotal);
	}
	
	public Marca buscarMarca(String nombre) {
		int i = 0;
		while((i < marcas.size()) && !(marcas.get(i).sosMarca(nombre)))
			i++;
		if(i < marcas.size())
			return marcas.get(i);
		else
			return null;
	}
	
	public Moneda buscarMoneda(String nom) {
		Scanner entrada = new Scanner(System.in);
		int i = 0;
		while((i < monedas.size()) && !(monedas.get(i).sosMoneda(nom)))
			i++;
		if(i < monedas.size())
			return monedas.get(i);
		else {
			System.out.print("Ingrese la cotización de la moneda: ");
			int cotiz = entrada.nextInt();
			Moneda moneda = new Moneda(nom, cotiz);
			monedas.add(moneda);
			return moneda;
		}
	}
	
	public boolean buscarModeloEntreAutos(String nom) {
		int i = 0;
		while((i < autos.size()) && !(nom.equalsIgnoreCase(autos.get(i).darModelo())))
				i++;
		if(i < autos.size())
			return true;
		else
			return false;
	}
	
	public void actualizarStock(int st, String mod) {
		int i = 0;
		while((i < autos.size()) && !(mod.equalsIgnoreCase(autos.get(i).darModelo())))
				i++;
		autos.get(i).actualizarStock(st);
	}
	
	public Auto buscarAutoSegunModelo(String mod) {
		int i = 0;
		while((i < autos.size()) && !(mod.equalsIgnoreCase(autos.get(i).darModelo())))
				i++;
		if(i < autos.size())
			return autos.get(i);
		else
			return null;
	}
}
