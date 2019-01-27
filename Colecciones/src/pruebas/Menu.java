package pruebas;

import java.io.IOException;
import java.util.ArrayList;

import utilesFran.Amadeus;

public class Menu {

	private Amadeus amadeus = new Amadeus();
	private ArrayList<Persona> personas = new ArrayList<Persona>();
	private Persona p = null;
	private String n;
	private String a;
	private int idFind;
	private int option;
	private int alt;
	private boolean match;

	public void inicio() throws IOException {
		do {
		System.out.println("Introduzca una opción");
		System.out.println("1.-Imprimir datos");
		System.out.println("2.-Insertar");
		System.out.println("3.-Consultar");
		System.out.println("4.-Actualizar");
		System.out.println("5.-Borrar");
		System.out.println("6.-Limpiar lista");
		System.out.println("7.-Salir");
		
		option=amadeus.controlaIntMinMax(1, 7);
		
		switch (option) {
		case 1:
			listarPersonas();
			break;
		case 2:
			insertarPersona();
			break;
		case 3:
			consultarPersona();
			break;
		case 4:
			actualizarPersona();
			break;
		case 5:
			borrarPersona();
			break;
		case 6:
			limpiarLista();
			break;
		default:
			break;
		}
		
		}while (option!=7);
	}
	
	private void listarPersonas() {
		for (Persona p : personas) {
			System.out.println(p.toString());
		}
	}

	private void insertarPersona() throws IOException {
		System.out.println("Introduzca nombre");
		n = amadeus.recibeTexto();
		System.out.println("Introduzca apellido");
		a = amadeus.recibeTexto();
		System.out.println("Introduzca altura");
		alt = amadeus.controlaIntMinMax(100, 240);
		p = new Persona(n, a, alt);
		personas.add(p);
	}

	private void consultarPersona() throws IOException {
		System.out.println("Introduzca id");
		idFind = amadeus.controlaIntPositivo();
		for (Persona p : personas) {
			if (p.getIdPersona() == idFind) {
				System.out.println(p.toString());
				match = true;
				break;
			}
		}
		if (!match)
			System.out.println("No existe una persona con esa ID");

		match = false;
	}

	private void actualizarPersona() throws IOException {
		System.out.println("Introduzca id");
		idFind = amadeus.controlaIntPositivo();
		for (Persona p : personas) {
			if (p.getIdPersona() == idFind) {
				p.toString();
				match = true;
				System.out.println("¿Qué desea modificar?");
				System.out.println("1.-Nombre");
				System.out.println("2.-Apellidos");
				System.out.println("3.-Altura");
				System.out.println("4.-Nada");
				option = amadeus.controlaIntMinMax(1, 4);

				switch (option) {
				case 1:
					System.out.println("Introduzca nombre");
					n = amadeus.recibeTexto();
					p.setNombre(n);
					break;
				case 2:
					System.out.println("Introduzca apellido");
					a = amadeus.recibeTexto();
					p.setApellido(a);
					break;
				case 3:
					System.out.println("Introduzca altura");
					alt = amadeus.controlaIntMinMax(100, 240);
					p.setAltura(alt);
					break;
				default:
					break;
				}

			}
		}
		if (!match)
			System.out.println("No existe una persona con esa ID");

		match = false;
	}
	
	private void borrarPersona() throws IOException {
		System.out.println("Introduzca id");
		idFind = amadeus.controlaIntPositivo();
		for (Persona p : personas) {
			if (p.getIdPersona() == idFind) {
				match = true;
				personas.remove(p);
				System.out.println("Registro eliminado");
				break;
			}
		}
		if (!match)
			System.out.println("No existe una persona con esa ID");

		match = false;
	}
	
	private void limpiarLista() {
		System.out.println("Registros borrados");
		personas.clear();
	}
	
	
}
