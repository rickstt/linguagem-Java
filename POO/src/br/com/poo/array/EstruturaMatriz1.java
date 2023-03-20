package br.com.poo.array;

public class EstruturaMatriz1 {

	public static void main(String[] args) {
		String[][] listaProdutos = {
				{"Nome","Marca","Preço"},
				{"Blusa","Levi","R$60,00"},
				{"Calça","Levi","R$100,00"},
				{"Sapato","Democrata","R$150,00"}
		};
		for(int lin = 0 ; lin < listaProdutos.length ; lin++) {
			for(int col = 0 ; col < listaProdutos[0].length ; col++) {
				System.out.print(listaProdutos[lin][col] + "\t");
			}
		}
	}
}
