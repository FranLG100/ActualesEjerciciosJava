package ejercicio02;

public class SustitucionDePalabras {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String frase="Y entonces el guerrero cogió su espada y reventó a su enemigo";
		System.out.println(frase);
		
		frase=frase.replaceAll("espada", "escopeta");
		System.out.println(frase);
	}

}
