package modelo;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.table.DefaultTableModel;

import com.sun.javafx.collections.MappingChange.Map;

public class Empresa implements Serializable {

	private Departamento departamento;
	private FileOutputStream fos;
	private FileInputStream fis;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private HashMap<Integer, Departamento> empresa = new HashMap<Integer, Departamento>();

	public void escribirFichero() throws IOException {
		fos = new FileOutputStream("empresas.dat");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(empresa);
		oos.close();
		fos.close();

	}

	public void iniciarFichero() throws IOException, ClassNotFoundException {
		try {
			fis = new FileInputStream("empresas.dat");
			ois = new ObjectInputStream(fis);
			empresa = (HashMap<Integer, Departamento>) ois.readObject();
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			System.out.println("Creando Archivo");
			File archivo = new File("empresas.dat");
			PrintWriter inicializador = new PrintWriter(new FileWriter(archivo));
			inicializador.close();
			iniciarFichero();
		} catch (EOFException e) {
			// ois.close();
			fis.close();
		}

		try {
			System.out.println(empresa.get(0).getNombre());
		} catch (NullPointerException e) {
			System.out.println("No existen departamentos");
		}

	}

	public String contarEmpresas() {
		String nEmpresas=Integer.toString(empresa.size());
		return nEmpresas;
	}

	public HashMap<Integer, Departamento> getEmpresa() {
		return empresa;
	}

	public void setEmpresa(HashMap<Integer, Departamento> empresa) {
		this.empresa = empresa;
	}

	public boolean comprobarExistencia(int n) {
		if(empresa.containsKey(n))
			return true;
		else
			return false;
	}
	
	public void insertarDepartamento(int n, String nombre, String localidad) throws NumberFormatException, IOException {
		departamento = new Departamento(n, nombre, localidad);
		empresa.put(n, departamento);
		System.out.println("Departamento registrado con éxito");
		escribirFichero();
	}

	public void modificarDepartamento(int n, String nombre, String localidad) throws NumberFormatException, IOException {
		departamento=new Departamento(n,nombre,localidad);
		empresa.put(n,departamento);
		System.out.println("Departamento registrado con éxito");
		escribirFichero();
	}
	
	public void borrarDepartamento(int n) throws NumberFormatException, IOException {
		empresa.remove(n);
		escribirFichero();
		}
	
	public String[] consultarDepartamento(int n) {
		String[] datos=new String[2];
		datos[0]=empresa.get(n).getNombre();
		datos[1]=empresa.get(n).getLocalidad();
		return datos;
	}
	
	public DefaultTableModel llenarTabla() {
		DefaultTableModel plantilla=new DefaultTableModel();
		String headers[]= {"ID","Nombre","Localidad"};
		String[][] tabla=new String[empresa.size()][3];
		int id;
		int i=0;
		String nombre, localidad;
		for (Entry<Integer, Departamento> dpto : empresa.entrySet()) {
			tabla[i][0]=Integer.toString(dpto.getKey());
			tabla[i][1]=dpto.getValue().getNombre();
			tabla[i][2]=dpto.getValue().getLocalidad();
			i++;
			}
		plantilla.setDataVector(tabla, headers);
		return plantilla;
	}

}
