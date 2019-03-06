package ejercicio07;

import java.io.IOException;

import utilesFran.Amadeus;

public class EmpleadoPorComision extends Empleado{

	private double tarifaComision;
	private double ventasBrutas;
	private Amadeus amadeus=new Amadeus();
	
	/**
	 * Constructor de EmpleadoPorComision
	 * @param tarifaComision Porcentaje de comisión que se lleva el empleado
	 * @param ventasBrutas Valos de las ventas brutas que realiza el empleado
	 * */
	public EmpleadoPorComision(String primerNombre, String apellidoPaterno, String nss, double tarifaComision, double ventasBrutas) throws IOException {
		super(primerNombre, apellidoPaterno, nss);
		setTarifaComision(tarifaComision);
		this.ventasBrutas=ventasBrutas;
	}

	@Override
	public String toString() {
		return super.toString()+"\nTarifa de Comisión: "+tarifaComision+"%"+"\nValor Ventas Brutas: "+ventasBrutas;
	}
	
	/**
	 * Método que devuelve los ingresos del empleado
	 * @return Ingresos del empleado
	 * */
	@Override
	public double ingresos() {
		return ventasBrutas*tarifaComision/100;	
	}

	public double getTarifaComision() {
		return tarifaComision;
	}

	public void setTarifaComision(double tarifaComision) throws IOException {
		if(tarifaComision<0 || tarifaComision>100) {
			System.out.println("Tarifa de Comisión inválida, introduzca un porcentaje válido");
			this.tarifaComision=amadeus.controlaDoublePorcentaje();
		}
		else
			this.tarifaComision = tarifaComision;
	}

	public double getVentasBrutas() {
		return ventasBrutas;
	}

	public void setVentasBrutas(double ventasBrutas) {
		this.ventasBrutas = ventasBrutas;
	}
	
	

}
