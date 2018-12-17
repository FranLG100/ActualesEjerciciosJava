package ejerciciosArray;
import utilesFran.Amadeus;

public class Ejercicio03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Amadeus amadeus=new Amadeus();
		int[][] matriz=amadeus.creaMatrizLlena(4, 4, 9);
		amadeus.imprimeMatriz(matriz);
		System.out.println();
		amadeus.posicionesMayorEnLaMatriz(matriz);
		System.out.println();
		System.out.println();
		amadeus.posicionesMenorEnLaMatriz(matriz);
	}

}
