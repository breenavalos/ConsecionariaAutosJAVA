import java.util.ArrayList;
import java.util.Scanner;

public class EmpresaAuto {
	
	private ArrayList<Auto>autos;
	private ArrayList<Moneda>monedas;
	private ArrayList<Marca>marcas;
	
	
public EmpresaAuto(){
	autos=new ArrayList<Auto>();
	monedas=new ArrayList<Moneda>();
	marcas=new ArrayList<Marca>();
	float valcambio = 1;
	Moneda money=new Moneda("Peso",valcambio, "Nacional");
	monedas.add(money);
}	
	
public void agregarAuto(){
	Scanner input = new Scanner(System.in);
	input.useDelimiter(System.getProperty("line.separator"));
	
	System.out.println("Ingrese Nombre de Marca: ");
	String mar=input.next();
	
	Marca ma=this.sosMarca(mar);
	
	if(ma!=null)
		this.agregarAutoYaConMarca(ma);
	else
		System.out.println("Marca Inexistente !!!");
	
}//Cierra agregarAuto

public void agregarAutoYaConMarca(Marca ma){
	Scanner input = new Scanner(System.in);
	input.useDelimiter(System.getProperty("line.separator"));
	int stock=1;
	float precioventa=0;
	float costo=0;
	
	
		System.out.println("Ingrese modelo de auto: ");
		String modelo=input.next();
		int busq=this.verificarAuto(modelo);
		if(busq !=-1)
				{
					autos.get(busq).setStock();
					System.out.println("El auto fue agregado al stock !!!");
				}
		else
			{
				System.out.println("Ingrese precio venta: ");
				precioventa=input.nextFloat();
				System.out.println("Ingrese costo: ");
				costo=input.nextFloat();
				byte op;
				do
					{
						System.out.print("Ingrese 1 Nacional - 2 Importado: ");
						op = input.nextByte();
					}
				while(op != 1 && op != 2);
		
			if(op == 1)
				{
					Moneda mon=this.verificarMoneda("Peso");
					Auto au=new Nacional(ma,modelo,precioventa,costo,mon,stock);
					autos.add(au);
				}
			else
				{
					System.out.println("Ingrese moneda: ");
					String nomb=input.next();
					Moneda mon=this.verificarMoneda(nomb);
					if(mon!=null)
					{
						//if(mon.getNombre().equalsIgnoreCase("Peso"))
						if(mon.sosNacional())
							{
								System.out.println("Debe ingresar una moneda extranjera !!!");
							}
						else
							{
								System.out.println("La moneda ya tiene valor de cambio: "+ mon.getValorDeCambio());
								Auto au=new Importado(ma,modelo,precioventa,costo,mon,stock);
								autos.add(au);
							}	
					}
					else
						{
							System.out.println("Moneda Inexistente !!!");	
						}
				}
			}
}
	
public void agregarMoneda(){
	Scanner input = new Scanner(System.in);
	input.useDelimiter(System.getProperty("line.separator"));
	float valcambio=0;
	System.out.println("Ingrese moneda");
	String mon=input.next();
	Moneda mo=this.verificarMoneda(mon);
	if(mo!=null){
		System.out.println("Moneda Existente !!!");
	}
	else{
		System.out.println("Ingrese valor de cambio");
		valcambio=input.nextFloat();
		String origen="Extranjera";
		Moneda money=new Moneda(mon,valcambio,origen);
		monedas.add(money);
	}	
}//Cierra agregarMoneda

public void informarGanancia(){
	float acu=0;
	for(Auto au: autos){
		acu=acu+au.darGanancia();
	}
	System.out.println("Ganancia total: " + acu);	
}//Cierra informarGanancia

public void listarAutos(){
	float acu=0;
	for(Auto au: autos){
		au.mostrate();
	}
	
}//Cierra informarGanancia


public void mostrarMoneda(){
	for(Moneda mo: monedas){
		mo.mostrate();	
		}
}//Cierra mostrarMoneda

public void agregarMarca(){
	Scanner input = new Scanner(System.in);
	input.useDelimiter(System.getProperty("line.separator"));
	System.out.println("Ingrese Nombre de Marca: ");
	String mar=input.next();
	
	Marca ma=this.sosMarca(mar);
	if(ma!=null)
		{
			System.out.println("Marca existente !!!");
		}
	else
		{
			Marca marca=new Marca(mar);
			marcas.add(marca);
			System.out.println("Marca " + mar + " Ingresada Correctamente !!!");
		}	
}//Cierra agregarMarca

public int verificarAuto(String mod){
	int i=0;
	while((i<autos.size()) && (!autos.get(i).sosModelo(mod)))
		i++;
		if(i<autos.size())
			return i;
		else{
			return (-1);
		}
}//Cierra metodo sosAuto

public Moneda verificarMoneda(String nomb){
	int i=0;
	while((i<monedas.size()) && (!monedas.get(i).sosMon(nomb)))
		i++;
		if(i<monedas.size())
			return (monedas.get(i));
		else
			{
				return null;
			}
	}

public Marca sosMarca(String mar){
	int i=0;
	while((i<marcas.size()) && (!marcas.get(i).sosMarca(mar)))
		i++;
		if(i<marcas.size())
			{
				//System.out.println("Encontro Marca !!! ");
				return marcas.get(i);
			}
		else
			{
				//System.out.println("No Encontro Marca !!! ");
				return null;
			}
}//Cierra metodo sosMarca

}//Cierra clase EmpresaAuto


