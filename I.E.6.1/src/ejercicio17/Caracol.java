package ejercicio17;

import utilesFran.Amadeus;

public class Caracol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Amadeus amadeus=new Amadeus();
		int tamanho=5; //Tama�o de la matriz que vamos a generar
		int contador=1; //Contador. N�mero en el cual empeazamos
		int principio=0; // Variable inicial, para llevar la cuenta de los l�mites
		int fin=tamanho-1; //Variable inicial sobre el final, para llevar la cuenta de los l�mites
		int[][] matriz=new int[tamanho][tamanho];
		
		while(contador<=(tamanho*tamanho)) {
			for (int i = principio; i <= fin; i++) {
				matriz[principio][i]=contador++;
			}
			for (int i = principio+1; i <= fin; i++) {
				matriz[i][fin]=contador++;
			}
			for (int i = fin-1; i >=principio; i--) {
				matriz[fin][i]=contador++;
			}
			for (int i = fin-1; i >=principio+1; i--) {
				matriz[i][principio]=contador++;
			}
			
			principio++;
			fin--;
		}
		
		amadeus.imprimeMatriz(matriz);

	}

}
