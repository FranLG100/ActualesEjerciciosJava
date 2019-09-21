package leeraleatorio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LeerFichero {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File archivo=new File("aleatorio.txt");
		RandomAccessFile file=new RandomAccessFile(archivo, "r");
		int id,departamento=0;
		int posicion=0;
		int registro;
		Double salario;
		char[] apellido=new char[10]; 
		char aux;
		
		//Todos los registros
		while(true) {
			file.seek(posicion);
			id=file.readInt();
			for (int i = 0; i < apellido.length; i++) {
				aux=file.readChar();
				apellido[i]=aux;
			}
			String apellidos=new String(apellido);
			departamento=file.readInt();
			salario=file.readDouble();
			registro=file.readInt();
			//Esto es un ejemplo de una entrada borrada, si fuese '0'. Podemos controlar esto de muchas formas.
			if(registro!=0) {
				System.out.println("ID: "+id+"\nApellidos: "+apellidos+"\nSalario: "+salario+"\nRegistrado: "+registro);
			}
			posicion+=40;
			if(file.getFilePointer()==file.length())
				break;
		}
		
		//Un solo registro
		//(Cada uno ocupa 36bytes)
		int identificador=1;
		int posicionConcreta=(identificador-1)*36;
		if(posicionConcreta>=file.length()) {
			System.out.println("No existe tal registro");
		}else {
			file.seek(posicionConcreta);
			id=file.readInt();
			for (int i = 0; i < apellido.length; i++) {
				aux=file.readChar();
				apellido[i]=aux;
			}
			String apellidos=new String(apellido);
			departamento=file.readInt();
			salario=file.readDouble();
			System.out.println("ID: "+id+"\nApellidos: "+apellidos+"\nSalario: "+salario);
		}
		
		
	}

}
