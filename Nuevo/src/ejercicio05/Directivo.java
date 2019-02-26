package ejercicio05;

public class Directivo extends Empleado implements Calculos{

	private double sueldo;
	private double comision;
	
	
	public Directivo() {}
	
	public Directivo(String nombre, String dni) {
		super(nombre, dni);
	}
	
	public Directivo(String nombre, String dni, double sueldo, double comision) {
		super(nombre, dni);
		this.sueldo=sueldo;
		this.comision=comision;
	}




	@Override
	public double calcularSueldo() {
		// TODO Auto-generated method stub
		return sueldo+comision;
		
		
	}
	
	@Override
	public double retencion() {
		// TODO Auto-generated method stub
		if(calcularSueldo()>=2500)
			return calcularSueldo()*0.2;
		
		else if(calcularSueldo()>=1500)
			return calcularSueldo()*0.18;
		
		else if(calcularSueldo()>=1000)
			return calcularSueldo()*0.15;
		
		else 
			return calcularSueldo()*0.12;
	}

	@Override
	public double gratificacion(int nhijos) {
		// TODO Auto-generated method stub
		if(nhijos>3)
			return 300;
		else if(nhijos>=1)
			return 200;
		else
			return 0;
	}

	@Override
	public double calcular() {
		// TODO Auto-generated method stub
		System.out.println("Introduzca número de hijos del empleado");
		int nhijos=0;
		return calcularSueldo()-retencion()+gratificacion(nhijos);
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
