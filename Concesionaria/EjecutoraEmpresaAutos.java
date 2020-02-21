import java.util.Scanner;	
public class EjecutoraEmpresaAutos {

public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	input.useDelimiter(System.getProperty("line.separator"));
		
	EmpresaAuto emp = new EmpresaAuto();
		byte opc=0;
		String rta="";
		do{
			System.out.println("\nEmpresa de autos");
			System.out.println("1) Agregar un auto: ");
			System.out.println("2) Agregar moneda: ");
			System.out.println("3) Informar ganancia: ");
			System.out.println("4) Mostrar monedas: ");
			System.out.println("5) Agregar Marca: ");
			System.out.println("6) Listar Autos: ");
			
			System.out.println("0) Salir");
			opc=input.nextByte();
			switch(opc){
			case 1:{
				do{
					emp.agregarAuto();
					System.out.println("¿Desea agregar otro auto?");
					rta=input.next();
				}while (rta.compareToIgnoreCase("S")==0);
			}break;
			case 2:{
				do{
					emp.agregarMoneda();
					System.out.println("¿Desea agregar otra moneda?");
					rta=input.next();
				}while (rta.compareToIgnoreCase("S")==0);
			}break;		
			case 3:{
					emp.informarGanancia();
			}break;
			case 4:{
				emp.mostrarMoneda();
		}break;
			case 5:{
				emp.agregarMarca();
		}break;
			case 6:{
				emp.listarAutos();
		}break;
			}
		}while(opc!=0);
	}//Cierra el main

}//Cierra clase ejecutora

