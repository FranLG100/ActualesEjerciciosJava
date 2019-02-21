package ejercicio01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import utilesFran.Amadeus;

public class MenuCuenta {

	private Amadeus amadeus=new Amadeus();
	private HashMap<Long,Cuenta> cuentas=new HashMap<Long,Cuenta>();
	
	public MenuCuenta() {}
	
	public void arrancaMenu() {
		
		System.out.println("Bienvenidos al banco Frantander");
		System.out.println("Escoja una opción");
		System.out.println("1.-Crear Cuenta Ahorro");
		System.out.println("2.-Crear Cuenta Corriente");
		System.out.println("3.-Ingresar Saldo");
		System.out.println("4.-Retirar Saldo");
		System.out.println("5.-Actualizar Saldo");
		System.out.println("6.-Consultar Cuenta");
		System.out.println("7.-Cambiar interés");
		System.out.println("8.-Listar Cuentas");
		System.out.println("9.-Salir");
		
	}
	
	public void crearCuentaAhorro() throws IOException {
		long ncuenta;
		double interes;
		double saldoMin;
		String nombre;
		String apellidos;
		String dni;
		System.out.println("Introduzca nombre del Cliente");
		nombre=amadeus.recibeTexto();
		System.out.println("Introduzca apellidos del Cliente");
		apellidos=amadeus.recibeTexto();
		System.out.println("Introduzca DNI del Cliente");
		dni=amadeus.recibeTexto();
		dni=amadeus.compruebaNIF(dni);
		
		System.out.println("Introduzca número de cuenta");
		ncuenta=amadeus.controlaIntPositivo();
		System.out.println("Introduzca interés variable");
		interes=amadeus.controlaDoublePorcentaje();
		System.out.println("Introduzca saldo mínimo");
		saldoMin=amadeus.controlaDoublePositivo();
		
		Cliente c=new Cliente(dni, nombre, apellidos);
		CuentaAhorro ca=new CuentaAhorro(c, ncuenta, interes, saldoMin);
		
		cuentas.put(ncuenta, ca);
		
	}
	
	public void crearCuentaCorriente() throws IOException {
		long ncuenta;
		String nombre;
		String apellidos;
		String dni;
		System.out.println("Introduzca nombre del Cliente");
		nombre=amadeus.recibeTexto();
		System.out.println("Introduzca apellidos del Cliente");
		apellidos=amadeus.recibeTexto();
		System.out.println("Introduzca DNI del Cliente");
		dni=amadeus.recibeTexto();
		dni=amadeus.compruebaNIF(dni);
		
		System.out.println("Introduzca número de cuenta");
		ncuenta=amadeus.controlaIntPositivo();
		
		Cliente c=new Cliente(dni, nombre, apellidos);
		CuentaCorriente cc=new CuentaCorriente(c, ncuenta);
		
		cuentas.put(ncuenta, cc);
		
	}
	
	public void listarCuentas() {
		for (Map.Entry<Long, Cuenta> cuenta : cuentas.entrySet()) {
			
			System.out.println(cuenta.getValue());
			
		}
	}
	
	
	
}
