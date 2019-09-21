package empleados;

import java.io.File;
import java.io.RandomAccessFile;

public class Empleado {

	File fichero;//=new File("empleados.txt");
	RandomAccessFile file;//=new RandomAccessFile(fichero, "rw");
	
	int id; //4bits
	String apellido; //12caracteres-24bits
	int departamento; //4bits
	double salario; //8bits
	//40bits
	
	public Empleado() {}
	
	public Empleado(int id, String nombre, int departamento, double salario) {
		this.id=id;
		this.apellido=nombre;
		this.departamento=departamento;
		this.salario=salario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String nombre) {
		this.apellido = nombre;
	}

	public int getDepartamento() {
		return departamento;
	}

	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
	
}
