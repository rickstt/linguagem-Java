package br.com.poo.heranca;

public class Cliente extends PessoaFisica {
	
	private double saldoCompras;

	public Cliente() {}

	public Cliente(double saldoCompras) {
		this.saldoCompras = saldoCompras;
	}

	
	public double getSaldoCompras() {
		return saldoCompras;
	}

	public void setSaldoCompras(double saldoCompras) {
		this.saldoCompras = saldoCompras;
	}

}
