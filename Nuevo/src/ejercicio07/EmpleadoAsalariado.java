package ejercicio07;

public class EmpleadoAsalariado extends Empleado {

	private double salarioSemanal;
	
	public EmpleadoAsalariado(String primerNombre, String apellidoPaterno, String nss) {
		super(primerNombre, apellidoPaterno, nss);
	}

	@Override
	public double ingresos() {
		return salarioSemanal;
	}
	
	public String toString() {
		return super.toString()+"\nSalario semanal: "+salarioSemanal;
	}

}
