package empleados;

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
	int id=2; //4bits
	String apellido="Hinojosa"; //12caracteres-24bits
	int departamento=2; //4bits
	double salario=4000; //8bits
	
	public Empresa() {}
	
	public void insertarEmpleado() throws IOException {
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
	
	public void leerSalarioAntiguo(long posicion) throws IOException {
		double salarioAntiguo=0;
		fichero=new File("empleados.txt");
		file=new RandomAccessFile(fichero, "r");
		file.seek(posicion+32);
		salarioAntiguo=file.readDouble();
		System.out.println("El antiguo salario era "+salarioAntiguo);
		file.close();
	}
	
	public long buscarPosicion(int idBusqueda) throws IOException {
		fichero=new File("empleados.txt");
		file=new RandomAccessFile(fichero, "r");
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
			long posicion=(idBorrado-1)*40;
			file.seek(posicion);
			StringBuffer buffer=null;
			file.writeInt(-1);
			buffer=new StringBuffer("Borrado");
			buffer.setLength(12);
			file.writeChars(buffer.toString());
			file.writeInt(0);
			file.writeDouble(0);
			file.close();
		}
	}
	
	public boolean comprobarExistencia(int identificador) {
		if(ids.contains(identificador)) {
			System.out.println("El empleado existe");
			return true;
		}else {
			System.out.println("El empleado no existe");
			return false;
		}
	}
	
	public void leerEmpleados() throws IOException {
		fichero=new File("empleados.txt");
		try {
			file=new RandomAccessFile(fichero, "r");
		} catch (FileNotFoundException e) {
			System.out.println("Creando Archivo");
			PrintWriter inicializador = new PrintWriter(new FileWriter(fichero));
			inicializador.close();
			file.close();
			leerEmpleados();
		}
		
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
			ids.add(id);
			for (int i = 0; i < apellidoAux.length; i++) {
				aux=file.readChar();
				apellidoAux[i]=aux;
			}
			String apellidos=new String(apellidoAux);
			apellidosE.add(apellidos);
			departamento=file.readInt();
			deps.add(departamento);
			salario=file.readDouble();
			salarios.add(salario);
			if(id>=0) {
				System.out.println("ID: "+id+"\nApellidos: "+apellidos+"\nSalario: "+salario);
			}
			posicion+=40;
		}
		file.close();
	}
	
}
