package escribiraleatorio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File fichero=new File("aleatorio.txt");
		RandomAccessFile file=new RandomAccessFile(fichero, "rw");
		String[] apellidos= {"Lorente","Rodriguez","Hinojosa","Ferrera"};
		int[] dep= {2,4,6,8};
		double[] salario= {4000,750,900,850};
		int[] registro= {1,0,1,0};
		
		StringBuffer buffer=null;
		int n=apellidos.length;
		
		for (int i = 0; i < n; i++) {
			file.writeInt(i+1);
			buffer=new StringBuffer(apellidos[i]);
			buffer.setLength(10);
			file.writeChars(buffer.toString());
			file.writeInt(dep[i]);
			file.writeDouble(salario[i]);
			file.writeInt(registro[i]);
		}
		file.close();
	}

}
