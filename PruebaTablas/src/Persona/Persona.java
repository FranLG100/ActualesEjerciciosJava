package Persona;

import java.io.Serializable;

import javax.swing.table.DefaultTableModel;

public class Persona implements Serializable {
	public String dni;
	public String nombre;
	public String apellidos;
	
	public Persona() {}
	
	public Persona(String nombre, String apellidos) {
		this.nombre=nombre;
		this.apellidos=apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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
	
}
