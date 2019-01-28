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
	
	public void introducirVentas() throws IOException {
		for (int i = 0; i < venta.getMeses().length; i++) {
			System.out.println("Introduzca valor de ventas para "+venta.getMeses()[i]);
			v=amadeus.controlaIntPositivo();
			venta=new Venta(venta.getMeses()[i],v);
		}
	}
	
	public void mostrarVentas() {
		for (Venta venta : ventas) {
			venta.toString();
		}
	}
	
	public void ventasAnuales() {
		
		for (Venta venta : ventas) {
			suma+=venta.getVenta();
		}
		
		System.out.println("Las ventas anuales han sido de "+suma+"€");
		suma=0;
		
	}
	
	public void ventasDeLosMesesA() {
		for (Venta venta : ventas) {
			if(venta.getMes().toLowerCase().startsWith("a")) {
				suma+=venta.getVenta();
			}
		}
		System.out.println("La suma de los meses que comienzan por 'A' es de "+suma+"€");
		suma=0;
	}
	
	public void mejorMes() {
	}
}
