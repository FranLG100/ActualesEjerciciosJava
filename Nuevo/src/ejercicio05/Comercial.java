package ejercicio05;

public class Comercial extends Empleado {

	private double sueldoBruto;
	private double importeVentas;
	
	
	public Comercial() {
	}


	public Comercial(String nombre, String dni) {
		super(nombre, dni);
	}
	
	public Comercial(String nombre, String dni, double sueldoBruto, double importeVentas) {
		super(nombre, dni);
		this.importeVentas=importeVentas;
		this.sueldoBruto=sueldoBruto;
	}


	@Override
	public double calcularSueldo() {
		return sueldoBruto+calcularComision();
	}
	
	public double calcularComision() {
		return importeVentas*0.1;
	}


	public double getSueldoBruto() {
		return sueldoBruto;
	}


	public void setSueldoBruto(double sueldoBruto) {
		this.sueldoBruto = sueldoBruto;
	}


	public double getImporteVentas() {
		return importeVentas;
	}


	public void setImporteVentas(double importeVentas) {
		this.importeVentas = importeVentas;
	}

	
	
}
