package ejercicio07;

public class EmpleadoBaseMasComision extends Empleado {

	public EmpleadoBaseMasComision(String primerNombre, String apellidoPaterno, String nss) {
		super(primerNombre, apellidoPaterno, nss);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double ingresos() {
		return 0;
	}

}
