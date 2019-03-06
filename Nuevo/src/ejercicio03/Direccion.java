package ejercicio03;

public class Direccion {
	
	private String calle;
	private String ciudad;
	private String zip;
	private String pais;
	
	public Direccion() {}

	/**
	 * Constructor de la clase Direccion
	 * @param calle Nombre de la calle
	 * @param ciudad Nombre de la ciudad
	 * @param zip Código postal
	 * @param pais País de nacimiento
	 * */
	public Direccion(String calle, String ciudad, String zip, String pais) {
		this.calle = calle;
		this.ciudad = ciudad;
		this.zip = zip;
		this.pais = pais;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	
	
	

}
