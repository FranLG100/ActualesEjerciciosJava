package ejercicio17;

import utilesFran.Amadeus;

public class Caracol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Amadeus amadeus=new Amadeus();
		int tamanho=3;
		int contador=1;
		int principio=0;
		int fin=tamanho;
		int[][] matriz=new int[tamanho][tamanho];
		
		while(contador<=(tamanho*tamanho)) {
			for (int i = principio; i <= fin-1; i++) {
				matriz[principio][i]=contador++;
			}
			for (int i = principio+1; i <= fin-1; i++) {
				matriz[i][fin-1]=contador++;
			}
			for (int i = fin-2; i >=principio; i--) {
				matriz[fin-1][i]=contador++;
			}
			for (int i = fin-2; i >=principio+1; i--) {
				matriz[i][principio]=contador++;
			}
			
			principio++;
			fin--;
		}
		
		amadeus.imprimeMatriz(matriz);

	}

}
