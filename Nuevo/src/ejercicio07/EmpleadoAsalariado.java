package ejercicio07;

public class EmpleadoAsalariado extends Empleado {

	private double salarioSemanal;
	
	public EmpleadoAsalariado(String primerNombre, String apellidoPaterno, String nss, double salarioSemanal) {
		super(primerNombre, apellidoPaterno, nss);
		this.salarioSemanal=salarioSemanal;
	}

	public double getSalarioSemanal() {
		return salarioSemanal;
	}

	public void setSalarioSemanal(double salarioSemanal) {
		this.salarioSemanal = salarioSemanal;
	}

	@Override
	public double ingresos() {
		return salarioSemanal;
	}
	
	public String toString() {
		return super.toString()+"\nSalario semanal: "+salarioSemanal;
	}

}
