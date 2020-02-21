package Consecionaria;

import java.util.Scanner;

public class EjecutoraConsecionaria {
	public static void main (String args[]){
		Empresa e = new Empresa();
		Scanner entrada = new Scanner(System.in);
		byte opc = 0;
		do {
			System.out.println("\n\nIngrese: 1 - Agregar auto:");
			System.out.println("Ingrese: 2 - Informar ganancia total:");
			System.out.println("Ingrese: 0 - Salir");
			System.out.print("\nIngrese opc: ");
			opc = entrada.nextByte();
			switch (opc) {
			case 1:{
				e.agregarNuevoAuto();
			}break;
			case 2:{
				e.informarGananciaTotal();
			}break;
		}
	}while (opc !=0);
	}
}
