package serializable;

import java.io.Serializable;

public class Departamento implements Serializable {
	
	private int nDepartamento;
	private String nombre;
	private String localidad;
	
	public Departamento() {
		
	}
	
	public Departamento(int nDerpartamento, String nombre, String localidad) {
		this.nDepartamento=nDepartamento;
		this.nombre=nombre;
		this.localidad=localidad;
	}

	public int getnDepartamento() {
		return nDepartamento;
	}

	public void setnDepartamento(int nDepartamento) {
		this.nDepartamento = nDepartamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	
	
	

}
