package ejercicio05;

import java.io.IOException;
import java.util.ArrayList;

import utilesFran.Amadeus;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ArrayList<Empleado> empleados=new ArrayList<Empleado>();
		int option = 0;
		Amadeus amadeus=new Amadeus();
		boolean dir = false;
		boolean com=false;
		
		do {
			System.out.println("Introduzca Opción");
			System.out.println("1.-Crear Directivo");
			System.out.println("2.-Crear Comercial");
			System.out.println("3.-Mostrar datos de los Directivos");
			System.out.println("4.-Mostrar Datos de los Comerciales");
			System.out.println("5.-Mostrar Datos de todos los Empleados");
			System.out.println("6.-Salir");
			
			option=amadeus.controlaIntMinMax(1, 6);
			
			switch (option) {
			case 1:
				empleados.add(crearDirectivo());
				dir=true;
				break;
			case 2:
				empleados.add(crearComercial());
				com=true;
				break;
			case 3:
				if(dir)
					mostrarDirectivos(empleados);
				else
					System.out.println("Debe crear un directivo primero");
				break;
			case 4:
				if(com)
					mostrarComerciales(empleados);
				else
					System.out.println("Debe crear un comercial primero");
				break;
			case 5:
				if(com || dir)
					mostrarEmpleados(empleados);
				else
					System.out.println("Debe crear un empleado primero");
				break;
			default:
				break;
			}
			
		}while(option!=6);
		
		
		
	}
	
	/**
	 * Método para crear un objeto directivo
	 * @return Un objeto directivo
	 * */
	public static Directivo crearDirectivo() throws IOException {
		String nombre;
		String dni; 
		double sueldo, comision;
		int nhijos;
		Amadeus amadeus=new Amadeus();
		
		System.out.println("Introduzca Nombre");
		nombre=amadeus.recibeTexto();
		System.out.println("Introduzca DNI");
		dni=amadeus.recibeTexto();
		dni=amadeus.compruebaNIF(dni);
		System.out.println("Introduzca Sueldo base");
		sueldo=amadeus.controlaDoublePositivo();
		System.out.println("Introduzca Comisión");
		comision=amadeus.controlaDoublePositivo();
		System.out.println("Introduzca Número de Hijos");
		nhijos=amadeus.controlaIntPositivo();
		
		Directivo dir=new Directivo(nombre, dni, sueldo, comision);
		
		System.out.println("Estos son sus datos:");
		System.out.println(dir);
		System.out.println("Retención: "+dir.retencion()+"€");
		System.out.println("Gratificación: "+dir.gratificacion(nhijos)+"€");
		System.out.println("Total: "+dir.calcular()+"€");
		
		return dir;
		
	}
	
	/**
	 * Método para crear un objeto Comercial
	 * @return Un objeto Comercial
	 * */
	public static Comercial crearComercial() throws IOException {
		String nombre;
		String dni; 
		double sueldo, ventas;
		int nhijos;
		Amadeus amadeus=new Amadeus();
		
		System.out.println("Introduzca Nombre");
		nombre=amadeus.recibeTexto();
		System.out.println("Introduzca DNI");
		dni=amadeus.recibeTexto();
		dni=amadeus.compruebaNIF(dni);
		System.out.println("Introduzca Sueldo bruto");
		sueldo=amadeus.controlaDoublePositivo();
		System.out.println("Introduzca importe de las ventas");
		ventas=amadeus.controlaDoublePositivo();
		System.out.println("Introduzca Número de Hijos");
		nhijos=amadeus.controlaIntPositivo();
		
		Comercial com=new Comercial(nombre, dni, sueldo, ventas);
		
		System.out.println("Estos son sus datos:");
		System.out.println(com);
		System.out.println("Retención: "+com.retencion()+"€");
		System.out.println("Gratificación: "+com.gratificacion(nhijos)+"€");
		System.out.println("Total: "+com.calcular()+"€");
		
		return com;
		
	}
	
	/**
	 * Método que muestra los comerciales almacenados en una lista
	 * @param empleados Lista de empleados a analizar
	 * */
	public static void mostrarComerciales(ArrayList<Empleado> empleados) throws IOException {
		for (Empleado empleado : empleados) {
			if(empleado instanceof Comercial) {
				System.out.println(empleado);
				System.out.println("Retención: "+empleado.retencion()+"€");
				System.out.println("Gratificación: "+empleado.gratificacion(empleado.getNhijos())+"€");
				System.out.println("Total: "+empleado.calcular()+"€");
			}
		}
	}
	
	/**
	 * Método que muestra los directivos almacenados en una lista
	 * @param empleados Lista de empleados a analizar
	 * */
	public static void mostrarDirectivos(ArrayList<Empleado> empleados) throws IOException {
		for (Empleado empleado : empleados) {
			if(empleado instanceof Directivo) {
				System.out.println(empleado);
				System.out.println("Retención: "+empleado.retencion()+"€");
				System.out.println("Gratificación: "+empleado.gratificacion(empleado.getNhijos())+"€");
				System.out.println("Total: "+empleado.calcular()+"€");
			}
		}
	}
	
	/**
	 * Método que muestra los comerciales y directivos almacenados en una lista
	 * @param empleados Lista de empleados a analizar
	 * */
	public static void mostrarEmpleados(ArrayList<Empleado> empleados) throws IOException {
		for (Empleado empleado : empleados) {
				System.out.println(empleado);
				System.out.println("Retención: "+empleado.retencion()+"€");
				System.out.println("Gratificación: "+empleado.gratificacion(empleado.getNhijos())+"€");
				System.out.println("Total: "+empleado.calcular()+"€");
		}
	}
	

}
