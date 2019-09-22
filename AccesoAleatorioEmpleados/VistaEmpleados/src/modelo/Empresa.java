package modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Empresa {

	File fichero;//=new File("empleados.txt");
	RandomAccessFile file;//=new RandomAccessFile(fichero, "rw");
	
	ArrayList<Integer> ids=new ArrayList<Integer>();
	ArrayList<String> apellidosE=new ArrayList<String>();
	ArrayList<Integer> deps=new ArrayList<Integer>();
	ArrayList<Double> salarios=new ArrayList<Double>();
	int id; //4bits
	String apellido; //12caracteres-24bits
	int departamento; //4bits
	double salario; //8bits
	
	public Empresa() {}
	
	public void insertarEmpleado(int id, String apellido, int departamento, double salario) throws IOException {
		fichero=new File("empleados.txt");
		file=new RandomAccessFile(fichero, "rw");
		long posicion=file.length();
		file.seek(posicion);
		StringBuffer buffer=null;
		file.writeInt(id);
		buffer=new StringBuffer(apellido);
		buffer.setLength(12);
		file.writeChars(buffer.toString());
		file.writeInt(departamento);
		file.writeDouble(salario);
		ids.add(id);
		file.close();
	}
	
	public void modificarEmpleado(int idModificar, String apellido, int dpto, double salario) throws IOException {
		if(comprobarExistencia(idModificar)) {
			long posicion=buscarPosicion(idModificar);
			leerSalarioAntiguo(posicion);
			fichero=new File("empleados.txt");
			file=new RandomAccessFile(fichero, "rw");
			file.seek(posicion);
			StringBuffer buffer=null;
			file.writeInt(idModificar);
			buffer=new StringBuffer(apellido);
			buffer.setLength(12);
			file.writeChars(buffer.toString());
			file.writeInt(dpto);
			file.writeDouble(salario);
			System.out.println("El nuevo salario es "+salario);
			file.close();
		}
	}
	
	public void modificaSalario(int idModificar,double nuevoSalario) throws IOException {
			long posicion=buscarPosicion(idModificar);
			leerSalarioAntiguo(posicion);
			fichero=new File("empleados.txt");
			file=new RandomAccessFile(fichero, "rw");
			file.seek(posicion+32);
			file.writeDouble(nuevoSalario);
			System.out.println("El nuevo salario es "+salario);
			file.close();
		}
	
	public void leerSalarioAntiguo(long posicion) throws IOException {
		double salarioAntiguo=0;
		fichero=new File("empleados.txt");
		file=new RandomAccessFile(fichero, "r");
		file.seek(posicion+32);
		salarioAntiguo=file.readDouble();
		System.out.println("El antiguo salario era "+salarioAntiguo);
		file.close();
	}
	
	public String[] consultarEmpleado(int idEmpleado) throws IOException {
		String[] datos=new String[4];
		fichero=new File("empleados.txt");
		file=new RandomAccessFile(fichero, "rw");
		long posicion=buscarPosicion(idEmpleado);
		file.seek(posicion);
		StringBuffer buffer=null;
		datos[0]=Integer.toString(file.readInt());
		char[] apellidoAux=new char[12]; 
		char aux;
		for (int i = 0; i < apellidoAux.length; i++) {
				aux=file.readChar();
				apellidoAux[i]=aux;
			}
		datos[1]=new String(apellidoAux);
		datos[2]=Integer.toString(file.readInt());
		datos[3]=Double.toString(file.readDouble());
		file.close();
		return datos;
		}
	
	public long buscarPosicion(int idBusqueda) throws IOException {
		fichero=new File("empleados.txt");
		file=new RandomAccessFile(fichero, "rw");
		id=0;
		departamento=0;
		int posicion=0;
		salario=0;
		char[] apellidoAux=new char[12]; 
		char aux;
		//Todos los registros
		while(true) {
			if(file.getFilePointer()==file.length())
				break;
			file.seek(posicion);
			id=file.readInt();
			if(id==idBusqueda) {
				long punto=posicion;
				return punto;
			}
			for (int i = 0; i < apellidoAux.length; i++) {
				aux=file.readChar();
				apellidoAux[i]=aux;
			}
			String apellidos=new String(apellidoAux);
			departamento=file.readInt();
			salario=file.readDouble();
			posicion+=40;
		}
		file.close();
		return 0;
	}
	
	public void eliminarEmpleado(int idBorrado) throws IOException {
		if(comprobarExistencia(idBorrado)) {
			fichero=new File("empleados.txt");
			file=new RandomAccessFile(fichero, "rw");
			long posicion=buscarPosicion(idBorrado);
			file.seek(posicion);
			StringBuffer buffer=null;
			file.writeInt(-1);
			buffer=new StringBuffer("Borrado");
			buffer.setLength(12);
			file.writeChars(buffer.toString());
			file.writeInt(0);
			file.writeDouble(0);
			file.close();
			for (int i = 0; i < ids.size(); i++) {
				if(ids.get(i)==idBorrado) {
					ids.remove(i);
					break;
				}
					
			}
			System.out.println(ids.toString());
		}
	}
	
	public boolean comprobarExistencia(int identificador) {
		if(ids.contains(identificador)) {
			return true;
		}else {
			return false;
		}
	}
	
	public void iniciarArchivo() throws IOException {
		boolean error=false;
		do{
			fichero=new File("empleados.txt");
		try {
			file=new RandomAccessFile(fichero, "r");
			error=false;
		} catch (FileNotFoundException e) {
			System.out.println("Creando Archivo");
			PrintWriter inicializador = new PrintWriter(new FileWriter(fichero));
			inicializador.close();
			file.close();
			error=true;
		}
		}while(error);
		
		id=0;
		int posicion=0;
		//Todos los registros
		while(true) {
			file.seek(posicion);
			if(file.getFilePointer()==file.length())
				break;
			id=file.readInt();
			ids.add(id);
			posicion+=40;
		}
		System.out.println(ids.toString());
		file.close();
	}
	
}
