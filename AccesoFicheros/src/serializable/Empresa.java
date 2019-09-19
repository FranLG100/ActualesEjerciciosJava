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
		departamento=new Departamento(2, "A", "B");
		this.empresa.put(1, departamento);
		fos=new FileOutputStream("empresa.txt");
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
			
			fis=new FileInputStream("empresas.txt");
			ois=new ObjectInputStream(fis);
			empresa=(HashMap<Integer, Departamento>) ois.readObject();
			ois.close();
			fis.close();
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
		
	}
	
	

}
