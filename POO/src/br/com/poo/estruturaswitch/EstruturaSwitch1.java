package br.com.poo.estruturaswitch;

import java.util.Scanner;

public class EstruturaSwitch1 {

	public static void main(String[] args) {
		int numSemana;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite o número do dia da semana: \n");
		numSemana = input.nextInt();
		
		switch(numSemana) {
		case 1:
			System.out.println("\nDomingo");
		break;
		case 2:
			System.out.println("\nSegunda-Feira");
		break;
		case 3:
			System.out.println("\nTerça-Feira");
		break;
		case 4:
			System.out.println("\nQuarta-Feira");
		break;
		case 5:
			System.out.println("\nQuinta-Feira");
		break;
		case 6:
			System.out.println("\nSexta-Feira");
		break;
		case 7:
			System.out.println("\nSábado");
		break;
		default:
			System.out.println("Este dia da semana não é válido.");
		break;
		}
	}

}
