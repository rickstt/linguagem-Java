package br.com.projetoescola.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * A classe Conexao é destinada a abrir conexão com o banco de dados<br>
 * Nesta classe você encontrará os seguintes métodos:<br>
 * <ul>
 * 	<li><b>abrirConexao:</b> Abre a conexão com o banco escoladb</li>
 * 	<li><b>fecharConexao:</b> Fecha a conexão com o banco escoladb</li>
 * </ul>
 * 
 * @author Henrique Santos
 *
 */

public abstract class Conexao {
	
	/*
	 * As propriedades da classe Conexao foram setados como protected pois
	 * haverá um processo de herança desta classe e assim será possível passar os 
	 * dados para as sub-classes.
	 * O comando Connection é uma classe que permite estabelecer a conexão com o
	 * banco de dados. Foi setado para esta classe a variavel conn com o valor inicial
	 * nulo, assim ela começa com algo e depois será instanciada.
	 * Já o comando PreparedStatement é utilizado para executar os comando SQL, tais como:
	 * Insert, Delete, Select, Update, dentre outros. A váriavel prepared foi criada como pst
	 * e seu valor inicial é null.
	 * o comando ResultSet é destinado a guardar os resultados do comando Select do mysql. 
	 * A váriavel rs foi inicializada com o valor null 
	 * */
	
	protected Connection conn = null;
	protected PreparedStatement pst = null;
	protected ResultSet rs = null;
	
	/**
	 * O método <b>abrirConexao</b> abre a conexão com o banco de dados escoladb que está
	 * no servidor MySQL, que por sua vez está no container(docker)
	 */
	public void abrirConexao() {
		/*
		 * Os comandos try, catch são utilizados para realizar o tratamento de erros,
		 * onde try, vocÊ tenta executar algo e caso dê erro o comando catch, captura 
		 * automáticamente o erro e o trata de acordo com o comando printStackTrace,
		 * exibindo a pilha(Stack) de erros
		 * */
		try {
			/*
			 * O comando Class.forName é usado para carregar o drive de comunicação com mysql
			 * */
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			/*
			 * Na linha abaixo é passado para o comando getConnection a url de conexao com o 
			 * banco de dados(ip,porta,banco de dados), o usuário e a senha. 
			 * TimeZone foi definido como true
			 * */
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:6556/escoladb?useTimeZone=true", "root", "senac@123");
		}
		
		catch(SQLException se) {
			/*
			 * Para tratamentos de erros específicos de sql, estamos usando a classe SQLException
			 * */
			se.printStackTrace();
		}
		catch(Exception e) {
			/*
			 * Para erros gerais, estamos usando o comando Exception
			 * */
			e.printStackTrace();
		}
	}
	
	public void fecharConexao() {
		try {
			/*
			 * O comando close é utilizado para fechar a conexão com o servidor de banco de dados
			 * */
			conn.close();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}