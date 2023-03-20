package br.com.poo.array;

public class EstruturaArray2 {

	public static void main(String[] args) {
		int[] numeros = {17,18,2,7,77,88,23,24,8,4,12,0};
		
		for(int i = 0 ; i < numeros.length ; i++) {
			if(numeros [i] % 2 == 0) {
				System.out.println(numeros[i]);
			}
		}
	}

}
