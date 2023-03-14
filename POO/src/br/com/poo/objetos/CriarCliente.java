package br.com.poo.objetos;

import java.sql.Date;

import br.com.poo.classes.Cliente;

public class CriarCliente {

	public static void main(String[] args) {
		// Para criar um objeto iremos fazer a instância da classe Cliente.
		Cliente cliente1 = new Cliente();
		// Passar as propriedades para o cliente;
		cliente1.id = 1;
		cliente1.nome = "Vanessa Oliveira";
		cliente1.cpf = "12345678910";
		cliente1.email =  "vanessa@gmail.com";
		cliente1.telefone = "(11)4017-2214";
		cliente1.dataNascimento = Date.valueOf("2023-03-13");
		
		// Vamos cadastrar o cliente acima com o comando cadastrar;
		System.out.println(cliente1.cadastrar());
		
	}

}
