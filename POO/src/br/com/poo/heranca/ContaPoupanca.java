package br.com.poo.heranca;

public class ContaPoupanca extends ContaBancaria {
	private double rendimentos;

	public ContaPoupanca() {}

	public ContaPoupanca(double rendimentos) {
		this.rendimentos = rendimentos;
	}

	public ContaPoupanca(Long numeroBanco,int agencia,Long numeroConta,String titular,double saldo,double rendimentos) {
		super.setNumeroBanco(numeroBanco);
		super.setAgencia(agencia);
		super.setNumeroConta(numeroConta);
		super.setTitular(titular);
		super.setTitular(titular);
		this.rendimentos = rendimentos;
	}

	public double getRendimentos() {
		return rendimentos;
	}

	public void setRendimentos(double rendimentos) {
		this.rendimentos = rendimentos;
	}
	
	@Override
	public String sacar(double valor) {
		String msg = "";
		
		if(super.getSaldo() < valor) {
			msg = "Saldo insuficiente";
		}
		else {
			super.setSaldo(super.getSaldo() - valor);
			msg = "Saque realizado";
		}
		return msg;
	}
}
