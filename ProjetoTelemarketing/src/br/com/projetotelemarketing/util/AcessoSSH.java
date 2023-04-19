package br.com.projetotelemarketing.util;

import java.io.BufferedReader;
/*
 * Este arquivo java realiza um acesso remoto via ssh em um servidor linux
 * Fedora Server. Para realizar esta operação foi necessário a utilização de
 * uma biblioteca chamada JSch(Java Security Channel), esta biblioteca foi
 * baixada do site www.jcraft.com/jsch/
 * */
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class AcessoSSH {

	/*
	 * Para o acesso à máquina remota, foi definido como constante os 
	 * seguintes itens: 
	 * */
	private static final String REMOTE_HOST = "127.0.0.1";
	private static final String REMOTE_USER = "senac";
	private static final String REMOTE_PASSWORD = "senac@123";
	private static final int REMOTE_PORT = 2222;
	/*
	 * Para a sessão e o canal(Channel) foi definido um tempo de execução
	 * de 10000 milisegundos, ou seja, 10 segundos
	 * */
	private static final int SESSION_TIMEOUT = 10000;
	private static final int CHANNEL_TIMEOUT = 10000;
	
	public static void executar() {
		
		//O comando que será executado remotamente no servidor.
		String comando = "python3 /home/senac/Python/banco.py";
		
		//Tipando a variável sessao para abrir a sessão ssh com o servidor linux
		Session sessao = null;
		
		try {
			 //Criação do objeto config para criar as configurações de acesso
			 //ao servidor
			Properties config = new Properties();
			
			// Foi setada a configuração restrita para checagem da chave de
			// criptografia. Muito usado quando não se tem chave
			config.put("StrictHostKeyChecking", "no");
			
			//Criando o objeto JSch
			JSch jsch = new JSch();
			
			//Setar o arquivo que contém a chave de criptografia para acesso SSH
			jsch.setKnownHosts("/home/senac/.ssh/nome_arquivo_chave");
			
			//Comando para abrir a sessão remota com o servidor linux. Foram passados:
			//Nome usuário, ip do servidor e porta de comunicação nesta ordem
			sessao = jsch.getSession(REMOTE_USER, REMOTE_HOST, REMOTE_PORT);
			
			//Setando a senha do servidor remoto
			sessao.setPassword(REMOTE_PASSWORD);
			
			//Foi setado a configuração para a sessao não verificar a existência da 
			//chave de acesso
			sessao.setConfig(config);
			
			//Passando tempo de execução da sessão
			sessao.connect(SESSION_TIMEOUT);
			
			/*
			 * Criando o elemento que representa o canal de execução de comandos. O
			 * comando sessao.openChannel, nos diz que quando a sessão for aberta
			 * também será aberto um canal para passagem dos comandos que serão
			 * executados(exec) no servidor remoto
			 * */
			ChannelExec channelExec = (ChannelExec) sessao.openChannel("exec");
			
			 //O comando channelExec.setCommand aponta o comando que deve ser executado
			 //no servidor remoto. Este comando foi definido na declaração da variavel
			 //String comando
			channelExec.setCommand(comando);
			
			 //Quando há algum erro inesperado na execução do channelExec será exibido 
			 //no sysout
			channelExec.setErrStream(System.err);
			
			//O comando InputStream realiza uma entrada de dados por meio do canal criado.
			//Também permite obter os dados que estão entrando no canal com o comando
			//getInputStream()
			InputStream in = channelExec.getInputStream();
			
			//Estabelece a conexão com o canal e passa o tempo em que o canal fica aberto
			//para a passagem de dados.
			channelExec.connect(CHANNEL_TIMEOUT);
			
			/*
			 * Os dados serão  passados e recebidos por bytes e não diretamente com
			 * Strings ou números(Inteiros ou reais) para que esta ação seja feita
			 * criamos um array de bytes para realizar a transação
			 * */
			byte[] tmp = new byte[1024];
			
			/*
			 * Enquanto for possivel executar o laço(while(true)) ele deve verificar
			 * se há dados em in, portanto temos o comando in.available(disponível) se
			 * é maior que 0. Sendo positivo ele deve executar todas as linhas disponíveis 
			 * que retornaram. Se o retorno de dados resultou em mais linhas maiores que 0,
			 * estas linhas serão apresentadas no terminal. O uso do comando new String(tmp,0,i)
			 * faz a conversão de bytes que estão vindo como resposta e a variável i conta a
			 * quantidade de linhas que retornam
			 * */
			while(true) {
				while(in.available() > 0) {
					int i = in.read(tmp,0,1024);
					if(i < 0) break;
					System.out.println(new String(tmp,0,i));
				}
				
				/*
				 * Se o canal estiver fechado, mas mesmo assim tiver dados em in, o laço
				 * deve continuar, ou seja, voltar ao início e executar novamente.
				 * Caso não haja mais nada a ser exibido em tela, o canal é fechado e é exibida
				 * a menssagem de canal fechado
				 * */
				if(channelExec.isClosed()) {
					if(in.available() > 0) continue;
					System.out.println("Saída do processo " + channelExec.getExitStatus());
					break;
				}
				try {
					//Demora 1 segundo e repete o laço outra vez até o canal ser desconectado
					Thread.sleep(1000);
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
			
			Process pr = Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe 127.0.0.1:8202/dep_vlr.html");
			BufferedReader leitor = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			String rs = "";
			while((rs = leitor.readLine()) != null ) {
				System.out.println(rs);
			}
			
			//Desconectar o canal
			channelExec.disconnect();
		}
		catch(JSchException jsex) {
			jsex.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(sessao != null) {
				//desconectar o canal
				sessao.disconnect();
			}
		}
}
}