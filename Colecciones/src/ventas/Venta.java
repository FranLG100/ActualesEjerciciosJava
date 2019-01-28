package ventas;

import java.io.IOException;
import java.util.ArrayList;

import utilesFran.Amadeus;

public class Venta {
	
	private Amadeus amadeus=new Amadeus();
	private String[] meses= {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
	private String mes;
	private int venta;
	private boolean match=false;
	
	public Venta(String mes, int venta) throws IOException {
		do {
			for (int i = 0; i < meses.length; i++) {
				if (mes.equalsIgnoreCase(meses[i])) {
					match = true;
					break;
				}
			}
			if (!match) {
				System.out.println("Introduzca un mes válido");
				mes = amadeus.recibeTexto();
			}
		} while (!match);
		this.mes = mes;
		this.venta = venta;
		match=false;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) throws IOException {
		do {
			for (int i = 0; i < meses.length; i++) {
				if (mes.equalsIgnoreCase(meses[i])) {
					match = true;
					break;
				}
			}
			if (!match) {
				System.out.println("Introduzca un mes válido");
				mes = amadeus.recibeTexto();
			}
		} while (!match);
		this.mes = mes;
		match=false;
	}

	public int getVenta() {
		return venta;
	}

	public void setVenta(int venta) {
		this.venta = venta;
	}

	public String[] getMeses() {
		return meses;
	}

	public void setMeses(String[] meses) {
		this.meses = meses;
	}
	
	@Override
	public String toString() {
		return "\nMes: "+mes+"\nVentas: "+venta+"\n";
	}
	
	
	
	

}
