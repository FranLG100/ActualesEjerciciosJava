package ejercicio07;

import java.io.IOException;

import utilesFran.Amadeus;

public class EmpleadoPorComision extends Empleado{

	private double tarifaComision;
	private double ventasBrutas;
	private Amadeus amadeus=new Amadeus();
	
	public EmpleadoPorComision(String primerNombre, String apellidoPaterno, String nss, double tarifaComision, double ventasBrutas) throws IOException {
		super(primerNombre, apellidoPaterno, nss);
		setTarifaComision(tarifaComision);
		this.ventasBrutas=ventasBrutas;
	}

	@Override
	public double ingresos() {
		return ventasBrutas*tarifaComision;	
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
