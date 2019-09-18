package ventas;

import java.io.IOException;
import java.util.ArrayList;

import utilesFran.Amadeus;

public class Menu {

	private Amadeus amadeus=new Amadeus();
	private String s;
	private int v;
	private Venta venta=null;
	private ArrayList<Venta> ventas=new ArrayList<Venta>();
	private int suma=0;
	private int option=0;
	private String[] meses= {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
	
	
	public void iniciarMenu() throws IOException {
		iniciarMeses();
		do {
			System.out.println("Introduzca una opción");
			System.out.println("1.- Insertar ventas anuales");
			System.out.println("2.- Mostrar ventas anuales");
			System.out.println("3.- Mostrar suma de las ventas");
			System.out.println("4.- Mostrar ventas de los meses que empiezan por A");
			System.out.println("5.- Mostrar mes con más ventas");
			System.out.println("6.- Salir");
			
			option=amadeus.controlaIntMinMax(1, 6);
			
			switch (option) {
			case 1:
				introducirVentas();
				break;
			case 2:
				mostrarVentas();
				break;
			case 3:
				ventasAnuales();
				break;
			case 4:
				ventasDeLosMesesA();
				break;
			case 5:
				mejorMes();
				break;
			default:
				break;
			}
		}while(option!=6);
	}
	
	public void iniciarMeses() throws IOException {
		for (int i = 0; i < 12; i++) {
			venta=new Venta(meses[i],0);
			ventas.add(venta);
		}
	}
	
	public void introducirVentas() throws IOException {
		for (int i = 0; i < ventas.size(); i++) {
			System.out.println("Introduzca valor de ventas para "+meses[i]);
			v=amadeus.controlaIntPositivo();
			ventas.get(i).setVenta(v);
		}
	}
	
	public void mostrarVentas() {
		for (Venta venta : ventas) {
			System.out.println(venta.toString());
		}
	}
	
	public void ventasAnuales() {
		
		for (Venta venta : ventas) {
			suma+=venta.getVenta();
		}
		
		System.out.println("Las ventas anuales han sido de "+suma+"€\n");
		suma=0;
		
	}
	
	public void ventasDeLosMesesA() {
		for (Venta venta : ventas) {
			if(venta.getMes().toLowerCase().startsWith("a")) {
				suma+=venta.getVenta();
			}
		}
		System.out.println("La suma de los meses que comienzan por 'A' es de "+suma+"€\n");
		suma=0;
	}
	
	public void mejorMes() {
		for (int i = 0; i < ventas.size(); i++) {
			if(ventas.get(i).getVenta()>suma)
				suma=ventas.get(i).getVenta();
		}
		System.out.println("\nLos meses con mayores ventas han sido:\n");
		for (Venta ve : ventas) {
			if(ve.getVenta()==suma)
				System.out.println(ve.getMes());
		}
		suma=0;
	}
}
