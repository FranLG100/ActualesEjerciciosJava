package ejercicio03;

public class EliminarEspaciosBlancos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String frase=" Su per ca li fra gi lís ti co es pia li do so";
		frase=frase.replaceAll("\\s", "");
		System.out.println(frase);
	}

}
