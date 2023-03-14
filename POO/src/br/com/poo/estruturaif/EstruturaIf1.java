package br.com.poo.estruturaif;

import java.util.Scanner;

public class EstruturaIf1 {
	public static void main(String args[]) {
		System.out.println("====================\n Valor Par ou Impar \n====================");
		System.out.println("\nEntre com um valor numérico: \n");
		
		// Declaração da var. numérica
		int numero;
		
		// Permite a entrada de dados via teclado pelo terminal
		Scanner entrada = new Scanner(System.in);
		
		numero = entrada.nextInt();
		
		// Vamos testar se o número digitado é par ou impar
		if(numero % 2 == 0) {
			System.out.println("\nO número: " + numero + " é par.");
		}
		else {
			System.out.println("\nO número: " + numero + " é impar.");
		}
	}
	
}
