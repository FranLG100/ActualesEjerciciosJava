package ejercicio07;

import java.io.IOException;

import utilesFran.Amadeus;

public class EmpleadoPorHoras extends Empleado {

	private int nHoras;
	private double sueldoHora;
	private Amadeus amadeus=new Amadeus();
	
	public EmpleadoPorHoras(String primerNombre, String apellidoPaterno, String nss,double sueldo,int nHoras) throws IOException {
		super(primerNombre, apellidoPaterno, nss);
		setSueldoHora(sueldo);
		setnHoras(nHoras);
	}

	@Override
	public double ingresos() {
		if(nHoras<=40)
			return sueldoHora*nHoras;
		else
			return (sueldoHora*40)+(sueldoHora*(nHoras-40)*1.5);
	}
	
	public String toString() {
		return super.toString()+"\nSueldo por hora: "+sueldoHora+"\nNúmero de horas trabajadas: "+nHoras;
	}

	public int getnHoras() {
		return nHoras;
	}

	public void setnHoras(int nHoras) throws IOException {
		if(nHoras>=0 && nHoras<=168)
			this.nHoras = nHoras;
		else {
			System.out.println("Número imposible de horas trabajadas. Introduzca una cantidad válida");
			this.nHoras=amadeus.controlaIntMinMax(0, 160);
		}
			
	}

	public double getSueldoHora() {
		return sueldoHora;
	}

	public void setSueldoHora(double sueldoHora) throws IOException {
		if(sueldoHora<0) {
			System.out.println("Cantidad inválida, introduzca una cantidad positiva a cobrar");
			this.sueldoHora=amadeus.controlaDoublePositivo();
		}
		else	
			this.sueldoHora = sueldoHora;
	}
	
	
	
	

}
