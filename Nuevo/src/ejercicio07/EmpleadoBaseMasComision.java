package ejercicio07;

import java.io.IOException;

public class EmpleadoBaseMasComision extends EmpleadoPorComision {

	private double salarioBase;
	
	
	public EmpleadoBaseMasComision(String primerNombre, String apellidoPaterno, String nss,double tarifaComision, double ventasBrutas, double salarioBase) throws IOException {
		super(primerNombre, apellidoPaterno, nss, tarifaComision, ventasBrutas);
		this.salarioBase=salarioBase;
	}

	@Override
	public double ingresos() {
		return super.ingresos()+salarioBase;
	}
	
	public String toString() {
		return super.toString()+"\nSalario Base: "+salarioBase;
	}

}
