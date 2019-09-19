package serializable;

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

public class Empresa implements Serializable{
	
	private Departamento departamento;
	private FileOutputStream fos;
	private FileInputStream fis;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private HashMap<Integer, Departamento> empresa=new HashMap<Integer,Departamento>();
	
	public void escribirFichero() throws IOException {
		fos=new FileOutputStream("empresas.txt");
		oos=new ObjectOutputStream(fos);
		oos.writeObject(empresa);
		oos.close();
		fos.close();
		
	}
	
	public void iniciarFichero() throws IOException, ClassNotFoundException {
		try {
			fis=new FileInputStream("empresas.txt");
			ois=new ObjectInputStream(fis);
			empresa=(HashMap<Integer, Departamento>) ois.readObject();
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			System.out.println("Creando Archivo");
			File archivo=new File("empresas.txt");
			PrintWriter inicializador=new PrintWriter(new FileWriter(archivo));
			inicializador.close();
			iniciarFichero();
		} catch (EOFException e) {
			//ois.close();
			fis.close();
		} 
		
		try {
			System.out.println(empresa.get(1).getNombre());
		}catch(NullPointerException e) {
			System.out.println("No existen departamentos");
		}
		
		
	}
	
	public void contarEmpresas() {
		System.out.println("Actualmente hay registrados "+empresa.size()+" departamentos");
	}
	
	public void insertarDepartamento() throws NumberFormatException, IOException {
		int n;
		String nombre;
		String localidad;
		BufferedReader entrada=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Inroduzca n de Departamento");
		n=Integer.parseInt(entrada.readLine());
		System.out.println("Inroduzca nombre de Departamento");
		nombre=entrada.readLine();
		System.out.println("Inroduzca localidad de Departamento");
		localidad=entrada.readLine();
		
		departamento=new Departamento(n, nombre, localidad);
		empresa.put(n, departamento);
		System.out.println("Departamento registrado con éxito");
	}
	
	

}
