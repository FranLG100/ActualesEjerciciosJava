package ejercicio03;

public abstract class Persona implements Humano {

	private String nombre;
	private String apellidos;
	private String dni;
	private Direccion direccion;
	
	public Persona() {}

	/**
	 * Constructor de Persona
	 * @param nombre Nombre de la persona
	 * @param apellidos Apellidos de la persona
	 * @param dni DNI de la persona
	 * */
	public Persona(String nombre, String apellidos, String dni) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
	}

	@Override
	public String identificate() {
		return "\nTipo: Persona";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	
	
}
