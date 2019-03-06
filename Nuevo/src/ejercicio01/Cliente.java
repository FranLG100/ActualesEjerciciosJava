package ejercicio01;

import java.io.IOException;

import utilesFran.Amadeus;

public class Cliente {

	private String nombre;
	private String apellidos;
	private String dni;
	private Amadeus amadeus=new Amadeus();
	
	public Cliente() {};
	
	/**
	 * Constructor público de Cliente
	 * @param dni DNI del cliente
	 * @param nombre Nombre del Cliente
	 * @param apellidos Apellidos del Cliente
	 * */
	public Cliente(String dni, String nombre, String apellidos) throws IOException {
		this.dni=amadeus.compruebaNIF(dni);
		this.nombre=nombre;
		this.apellidos=apellidos;
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
	
	
}
