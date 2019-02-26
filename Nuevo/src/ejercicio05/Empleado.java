package ejercicio05;

public abstract class Empleado implements Calculos {
	
	private String nombre;
	private String dni;
	private int nhijos;
	
	public Empleado() {}

	public Empleado(String nombre, String dni) {
		super();
		this.nombre = nombre;
		this.dni = dni;
	}
	
	@Override
	public String toString() {
		return "\nDNI: "+dni+"\nNombre: "+nombre;
	}

	public abstract double calcularSueldo();
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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
		this.nhijos=nhijos;
		if(nhijos>3)
			return 300;
		else if(nhijos>=1)
			return 200;
		else
			return 0;
	}

	@Override
	public double calcular() {
		return calcularSueldo()-retencion()+gratificacion(nhijos);
	}

	public int getNhijos() {
		return nhijos;
	}

	public void setNhijos(int nhijos) {
		this.nhijos = nhijos;
	}
	
	

}
