package ejercicio07;

public class EmpleadoAsalariado extends Empleado {

	private double salarioSemanal;
	
	/**
	 * Constructor de EmpleadoAsalariado
	 * @param salarioSemanal Salario semanal del empleado
	 * */
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

	/**
	 * Método que devuelve los ingresos del empleado
	 * @return Ingresos del empleado
	 * */
	@Override
	public double ingresos() {
		return salarioSemanal;
	}
	
	@Override
	public String toString() {
		return super.toString()+"\nSalario semanal: "+salarioSemanal;
	}

}
