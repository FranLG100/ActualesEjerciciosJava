package ejercicio07;

import java.io.IOException;

public class EmpleadoBaseMasComision extends EmpleadoPorComision {

	private double salarioBase;
	
	/**
	 * Constructor de EmpleadoBaseMasComision
	 * @param salarioBase Salario Base del empleado
	 * */
	public EmpleadoBaseMasComision(String primerNombre, String apellidoPaterno, String nss,double tarifaComision, double ventasBrutas, double salarioBase) throws IOException {
		super(primerNombre, apellidoPaterno, nss, tarifaComision, ventasBrutas);
		this.salarioBase=salarioBase;
	}

	/**
	 * Método que devuelve los ingresos del empleado
	 * @return Ingresos del empleado
	 * */
	@Override
	public double ingresos() {
		return super.ingresos()+salarioBase;
	}
	
	@Override
	public String toString() {
		return super.toString()+"\nSalario Base: "+salarioBase;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}
	
	

}
