package br.com.poo.estruturaif;

import java.text.DecimalFormat;
import java.util.Scanner;

public class EstruturaIf3 {

	public static void main(String[] args) {
		   double salario, aliquota, novoSalario;
		   Scanner entrada = new Scanner(System.in);
		   DecimalFormat formatter = new DecimalFormat("############.##");
		   
		   System.out.println("----------------------------------\n Cálculo de Contribuição do INSS \n----------------------------------");
		   System.out.println("\nInforme o salário para ser calculado o desconto: \n");
		   salario = entrada.nextDouble();
		   
		   if(salario <= 1302.00) {
			   aliquota = (salario * 7.5) / 100;
			   novoSalario = (salario - aliquota);
			   
			   System.out.println("\nO salário informado é de: " + formatter.format(salario));
			   System.out.println("\nO desconto salárial é de: " + formatter.format(aliquota));
			   System.out.println("\nO salário com o desconto é de: " + formatter.format(novoSalario));
		   }
		   else if(salario <= 2571.29) {
			   aliquota = (salario * 9.0) / 100;
			   novoSalario = (salario - aliquota);
			   
			   System.out.println("\nO salário informado é de: " + formatter.format(salario));
			   System.out.println("\nO desconto salárial é de: " + formatter.format(aliquota));
			   System.out.println("\nO salário com o desconto é de: " + formatter.format(novoSalario));
		   }
		   else if(salario <= 3856.94) {
			   aliquota = (salario * 12.0) / 100;
			   novoSalario = (salario - aliquota);
			   
			   System.out.println("\nO salário informado é de: " + formatter.format(salario));
			   System.out.println("\nO desconto salárial é de: " + formatter.format(aliquota));
			   System.out.println("\nO salário com o desconto é de: " + formatter.format(novoSalario));
		   }
		   else if(salario <= 7507.49) {
			   aliquota = (salario * 14.0) / 100;
			   novoSalario = (salario - aliquota);
			   
			   System.out.println("\nO salário informado é de: " + formatter.format(salario));
			   System.out.println("\nO desconto salárial é de: " + formatter.format(aliquota));
			   System.out.println("\nO salário com o desconto é de: " + formatter.format(novoSalario));
		   }
		   else {
			   System.out.println("\n Sinto muito, mas o salário informado não está na tabela :(");
		   }
	}

}
