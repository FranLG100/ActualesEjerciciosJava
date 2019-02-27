package ejercicio07;

public class EmpleadoPorComision extends Empleado{

	private double tarifaComision;
	private double ventasBrutas;
	
	public EmpleadoPorComision(String primerNombre, String apellidoPaterno, String nss) {
		super(primerNombre, apellidoPaterno, nss);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double ingresos() {
		return 0;
		
	}

}
