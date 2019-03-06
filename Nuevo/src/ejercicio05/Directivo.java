package ejercicio05;

public class Directivo extends Empleado{

	private double sueldo;
	private double comision;
	
	public Directivo() {}
	
	public Directivo(String nombre, String dni) {
		super(nombre, dni);
	}
	
	/**
	 * Constructor de Directivo
	 * @param comision Comisión que le corresponde al Directivo
	 * */
	public Directivo(String nombre, String dni, double sueldo, double comision) {
		super(nombre, dni);
		this.sueldo=sueldo;
		this.comision=comision;
	}

	public String toString() {
		return super.toString()+"\nSueldo base: "+sueldo+"\nComisión: "+comision;
	}
	
	/**
	 * Método para calcular el sueldo del directivo
	 * @return Sueldo más la comisión que le corresponde
	 * */
	@Override
	public double calcularSueldo() {
		// TODO Auto-generated method stub
		return sueldo+comision;
		
		
	}
	
	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public double getComision() {
		return comision;
	}

	public void setComision(double comision) {
		this.comision = comision;
	}

	
	
	
	

}
