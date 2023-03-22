package br.com.poo.heranca;

// A classe PessoaJuridica herda os métodos
// e propriedades da classe Pessoa. Por isso
// usamos o comando (extends) para gerar a herança

public class PessoaJuridica extends Pessoa {
	private String razaoSocial;
	private String cpnj;
	
	public PessoaJuridica() {}

	public PessoaJuridica(String razaoSocial, String cpnj) {
		this.razaoSocial = razaoSocial;
		this.cpnj = cpnj;
	}

	
	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCpnj() {
		return cpnj;
	}

	public void setCpnj(String cpnj) {
		this.cpnj = cpnj;
	}
	
	

}
