package br.com.poo.estruturaswitch;

import javax.swing.JOptionPane;

public class EstruturaSwitch3 extends JOptionPane {

	public static void main(String[] args) {
		   
		JOptionPane.showMessageDialog(null, "Sistema de Salário","CONFIDENCIAL",JOptionPane.INFORMATION_MESSAGE);
		String salario = JOptionPane.showInputDialog("Digite o cargo para se informar dos salários disponíveis.");
		String resultado;
		
		switch(salario) {
			case "diretor":
				resultado = "O salário correspondete é de R$20.000";
			break;
			case "gerente":
				resultado = "O salário correspondete é de R$15.000";
			break;
			case "secretaria":
				resultado = "O salário correspondete é de R$8.000";
			break;
			case "analista":
				resultado = "O salário correspondete é de R$7.000";
			break;
			case "assistente":
				resultado = "O salário correspondete é de R$4.000";
			break;
			case "estagiario":
				resultado = "O salário correspondete é de R$1.500";
			break;
			default:
				resultado = "O salário não está disponível, tente outro cargo.";
			break;
		}
		JOptionPane.showMessageDialog(null,resultado,"Informação Confidencial",JOptionPane.INFORMATION_MESSAGE);
	}

}
