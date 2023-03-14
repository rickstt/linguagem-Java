package br.com.poo.estruturaif;

import java.util.Scanner;

/*
 * Este programa calcula a nota dos alunos e obtem a média
 * de cada aluno. Após isto é apresentada uma das mensagens:
 * Aprovado, Reprovado ou Rcuperação.
 * */

public class EstruturaIf2 {

	public static void main(String[] args) {
		double nota1, nota2, nota3, nota4, media;
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("----------- Sistema de Notas --------\n");
		System.out.println("Digite a primeira nota: ");
		nota1 = entrada.nextDouble();
		
		System.out.println("Digite a segunda nota: ");
		nota2 = entrada.nextDouble();
		
		System.out.println("Digite a terceira nota: ");
		nota3 = entrada.nextDouble();
		
		System.out.println("Digite a Quarta nota: ");
		nota4 = entrada.nextDouble();
		
		media = (nota1 + nota2 + nota3 + nota4) / 4;
		
		if(media >= 6) {
			System.out.println("\nA média deste aluno foi de: " + media);
			System.out.println("\nCom isto, aluno está aprovado.");
		}
		else if(media >= 5) {
			System.out.println("\nA média deste aluno foi de: " + media);
			System.out.println("\nCom isto, o aluno está em recuperação!");
		}
		else {
			System.out.println("\nA média deste aluno foi de: " + media);
			System.out.println("\nCom isto, o aluno está reprovado!!!");
		}
	}

}
