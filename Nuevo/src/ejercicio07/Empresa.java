package ejercicio07;

import java.util.ArrayList;

public class Empresa {

	private ArrayList<Empleado> empleados=new ArrayList<Empleado>();
	private boolean verificado;
	
	public Empresa() {};
	
	public void addEmpleado(Empleado e) {
		empleados.add(e);
	}
	
	public void eliminarEmpleado(String s) {
		verificado=false;
		for (int i = 0; i < empleados.size(); i++) {
			if(empleados.get(i).getNss().equalsIgnoreCase(s)) {
				empleados.remove(i);
				System.out.println("Empleado eliminado con éxito");
				verificado=true;
				break;
			}
		}
		if(!verificado) {
			System.out.println("Empleado inexistente");
		}
		
	}
	
	public void listarEmpleados() {
		for (Empleado empleado : empleados) {
			System.out.println(empleado+"\n");
		}
	}
	
	public void modificarEmpleado() {}
	
}
