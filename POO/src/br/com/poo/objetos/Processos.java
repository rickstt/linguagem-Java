package br.com.poo.objetos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Processos {
	public static void main(String[] args) {
		try {
			/*
			 * O comando Process executa um comando do sistema operacional, neste caso
			 * o sistema é windows.
			 * O comando RunTime(Tempo de execução) getRuntime(chamar para executar)
			 * são utilizados para executar um comando de sistema operacional. E, este
			 * comando será executado quando a aplicação do java or executada(Runtime)
			 * Abaixo estamos abrindo a calculadora
			 **/
			Process pr = Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe 127.0.0.1:8888");
			
			/*
			 * O comando BufferedReader(A classe BuferredReader) é um leitor que trabalha
			 * com dados em memória. Ele é responsável para ler os dados em memória.
			 * Abaixo é feita uma inserção de leitura de dados com o comando InputStreamReader
			 * (Inserir um dado de leitura). Neste caso foi inserido e lido o processo que
			 * executa o comando que abre a calculadora
			 **/
			BufferedReader leitor = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			
			/*
			 * Para exibir as informações retornadas pelo Buffer, podemos usar uma variavel 
			 * no formato de String para armazenar estas informações e depois exibi-las
			 **/
			String rs = "";
			
			/*
			 * Para pegar todos os dados de memória foi feito um laço while, e os dados foram
			 * passados para a variavel rs. Assim foi possível exibir no console
			 * */
			while((rs = leitor.readLine()) != null ) {
				System.out.println(rs);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
