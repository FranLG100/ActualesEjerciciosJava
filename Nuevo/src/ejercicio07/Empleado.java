package ejercicio07;

public abstract class Empleado {
	
	private String primerNombre, apellidoPaterno;
	private String nss;
	
	/**
	 * Constructor de Empleado
	 * @param primerNombre Nombre del Empleado
	 * @param apellidoPaterno Primer Apellido del empleado
	 * @param nss Número de la Seguridad Social
	 * */
	public Empleado(String primerNombre, String apellidoPaterno, String nss) {
		this.primerNombre = primerNombre;
		this.apellidoPaterno = apellidoPaterno;
		this.nss = nss;
	}
	
	
	
	public abstract double ingresos();

	@Override
	public String toString() {
		return "\nNombre: "+primerNombre+"\nApellido: "+apellidoPaterno+"\nNúmero de la Seguridad Social: "+nss;
	}


	public String getPrimerNombre() {
		return primerNombre;
	}



	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}



	public String getApellidoPaterno() {
		return apellidoPaterno;
	}



	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}



	public String getNss() {
		return nss;
	}



	public void setNss(String nss) {
		this.nss = nss;
	}
	
	
	
	
}
