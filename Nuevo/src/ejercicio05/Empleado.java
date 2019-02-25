package ejercicio05;

public abstract class Empleado {
	
	private String nombre;
	private String dni;
	
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
	
	

}
