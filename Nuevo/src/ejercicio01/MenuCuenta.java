package ejercicio01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import utilesFran.Amadeus;

public class MenuCuenta {

	private Amadeus amadeus=new Amadeus();
	private TreeMap<Long,Cuenta> cuentas=new TreeMap<Long,Cuenta>();
	
	public MenuCuenta() {}
	
	public void arrancaMenu() throws IOException {
		int option = 0;
		do {
		System.out.println("Bienvenidos al banco Frantander");
		System.out.println("Escoja una opci�n");
		System.out.println("1.-Crear Cuenta Ahorro");
		System.out.println("2.-Crear Cuenta Corriente");
		System.out.println("3.-Ingresar Saldo");
		System.out.println("4.-Retirar Saldo");
		System.out.println("5.-Actualizar Saldo");
		System.out.println("6.-Consultar Cuenta");
		System.out.println("7.-Cambiar inter�s");
		System.out.println("8.-Listar Cuentas");
		System.out.println("9.-Salir");
		
		option=amadeus.controlaIntMinMax(1, 9);
		
		switch (option) {
		case 1:
			crearCuentaAhorro();
			break;
		case 2:
			crearCuentaCorriente();
			break;
		case 3:
			ingresarSaldo();
			break;
		case 4:
			retirarSaldo();
			break;
		case 5:
			actualizarSaldo();
			break;
		case 6:
			consultarCuenta();
			break;
		case 7:
			cambiarInteres();
			break;
		case 8:
			listarCuentas();
			break;
		default:
			break;
		}
		
		}while(option!=9);
		
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
		
		do {
			System.out.println("Introduzca n�mero de cuenta");
			ncuenta=amadeus.controlaIntPositivo();
			if(cuentas.containsKey(ncuenta))
				System.out.println("Esa cuenta ya existe, introduzca otro n�mero de cuenta");
			}while(cuentas.containsKey(ncuenta));
		
		System.out.println("Introduzca inter�s variable");
		interes=amadeus.controlaDoublePorcentaje();
		System.out.println("Introduzca saldo m�nimo");
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
		
		do {
		System.out.println("Introduzca n�mero de cuenta");
		ncuenta=amadeus.controlaIntPositivo();
		if(cuentas.containsKey(ncuenta))
			System.out.println("Esa cuenta ya existe, introduzca otro n�mero de cuenta");
		}while(cuentas.containsKey(ncuenta));
		
		Cliente c=new Cliente(dni, nombre, apellidos);
		CuentaCorriente cc=new CuentaCorriente(c, ncuenta);
		
		cuentas.put(ncuenta, cc);
		
	}
	
	public void ingresarSaldo() throws IOException {
		long ncuenta;
		System.out.println("Introduzca n�mero de cuenta");
		ncuenta=amadeus.controlaIntPositivo();
		if(cuentas.containsKey(ncuenta)) {
			System.out.println("Introduzca saldo a a�adir");
			double saldo=amadeus.controlaDoublePositivo();
			cuentas.get(ncuenta).ingresarSaldo(saldo);
		}else {
			System.out.println("Cuenta inexistente");
		}
	}
	
	public void retirarSaldo() throws IOException {
		long ncuenta;
		System.out.println("Introduzca n�mero de cuenta");
		ncuenta=amadeus.controlaIntPositivo();
		if(cuentas.containsKey(ncuenta)) {
			System.out.println("Introduzca saldo a retirar");
			double saldo=amadeus.controlaDoublePositivo();
			cuentas.get(ncuenta).retirarSaldo(saldo);
		}else {
			System.out.println("Cuenta inexistente");
		}
	}
	
	public void actualizarSaldo() throws IOException {
		long ncuenta;
		System.out.println("Introduzca n�mero de cuenta");
		ncuenta=amadeus.controlaIntPositivo();
		if(cuentas.containsKey(ncuenta)) {
			cuentas.get(ncuenta).actualizarSaldo();
		}else {
			System.out.println("Cuenta inexistente");
		}
	}
	
	public void consultarCuenta() throws IOException {
		long ncuenta;
		System.out.println("Introduzca n�mero de cuenta");
		ncuenta=amadeus.controlaIntPositivo();
		if(cuentas.containsKey(ncuenta)) {
			System.out.println(cuentas.get(ncuenta));
		}else {
			System.out.println("Cuenta inexistente");
		}
	}
	
	public void cambiarInteres() throws IOException {
		long ncuenta;
		System.out.println("Introduzca n�mero de cuenta");
		ncuenta=amadeus.controlaIntPositivo();
		if(cuentas.containsKey(ncuenta)) {
			if(cuentas.get(ncuenta) instanceof CuentaAhorro) {
				System.out.println("Introduzca nuevo inter�s");
				double porcentaje=amadeus.controlaDoublePorcentaje();
				((CuentaAhorro)(cuentas.get(ncuenta))).setInteres(porcentaje);
			}else {
				System.out.println("Una cuenta Corriente no tiene un inter�s variable");
			}
		}else {
			System.out.println("Cuenta inexistente");
		}
	}
	
	public void listarCuentas() {
		for (Map.Entry<Long, Cuenta> cuenta : cuentas.entrySet()) {
			
			System.out.println(cuenta.getValue());
			
		}
	}
	
	
	
}
