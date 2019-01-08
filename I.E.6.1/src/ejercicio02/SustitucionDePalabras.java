package ejercicio02;

public class SustitucionDePalabras {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//En este String guardaremos la frase a cambiar. La imprimiremos
		String frase="Y entonces el guerrero cogió su espada y mató a su enemigo";
		System.out.println(frase);
		
		//Ahora, con 'replaceAll', cambiaremos las cadenas que queramos por otras deseadas
		frase=frase.replaceAll("espada", "caja de herramientas");
		frase=frase.replaceAll("mató", "ayudó");
		frase=frase.replaceAll("enemigo", "benefactor");
		System.out.println(frase);
	}

}
