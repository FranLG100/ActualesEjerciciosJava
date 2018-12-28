package ejercicio08;

import java.util.StringTokenizer;

public class Tokenizer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String notas="Juan Carlos \n 8.5 \n Andrés \n 4.9 \n Pedro \n 3.8 \n Juan \n 6.3";
		StringTokenizer token=new StringTokenizer(notas,"\n");
		
		while(token.hasMoreTokens()) {
			System.out.println("El alumno "+token.nextToken().trim()+" ha sacado la nota "+token.nextToken().trim());
		}

	}

}
