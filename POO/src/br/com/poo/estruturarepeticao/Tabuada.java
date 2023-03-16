package br.com.poo.estruturarepeticao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Tabuada extends JFrame {
	
	
	static String dados = "";
	public static void main(String[] args) {
		// Gerando um objeto de janela baseado na
		// classe JFrame. Abaixo um processo de
		// Instância:
		JFrame janela = new JFrame();
		
		// Tamanho em largura e altura:
		janela.setSize(500, 400);
		
		// Posicionar a janela no centro da tela:
		janela.setLocationRelativeTo(null);
		
		// Aplicar um título a janela que será criada:
		janela.setTitle("Tabuáda");
		
		// Comando para fechar e retirar a janela da memória:
		janela.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Vamos definir o layout como nulo. Isto nos ajuda
		// A posicionar os componentes livremente
		janela.getContentPane().setLayout(null);
		
		// Vamos adicionar um componente de texto à nossa janela.
		// Este componente será um rótulo (label -> JLabel)
		JLabel lblNumero = new JLabel("Digite um número para a tabuada");
		
		// Para posicionar a label na janela criada, será necessário 
		// utilizar as configurações de x, y, Largura e altura
		lblNumero.setBounds(10,10,250,30);
		
		// Vamos adicionar a label (lblNumero) a tela janela
		janela.add(lblNumero);
		
		// Vamos adicionar um novo componente chamado JTextArea
		// Para apresentar os resultados da tabuada.
		JTextArea txtResultado = new JTextArea();
		
		// Primeiro vamos posicionar e definir a 
		// largura e altura da caixa
		txtResultado.setBounds(10,50,463,300);
		
		// Vamos adicionar a caixa de texto a janela
		janela.add(txtResultado);
		
		// Para o usuário inserir um número para a tabuada
		// Iremos adicionar um novo componente chamado
		// JTextField (Campo de texto)
		JTextField txtNumero = new JTextField();
		
		// Vamos agora posicionar a caixa dentro da janela
		// Definindo largura e altura para que ela fique
		// ao lado de lblNumero
		txtNumero.setBounds(210,10,50,30);
		
		// Por fim vamos adicionar a caixa a janela
		janela.add(txtNumero);
		
		// Agora vamos adicionar o elemento de botão
		JButton btnCalcular = new JButton("Calcular");
		
		btnCalcular.setBounds(280,10,100,30);
		
		janela.add(btnCalcular);
		
		// Vamos adicionar um evento de clique ao botão criado
		// Ao clicar no botão o valor de txtNumero deve ser repassado
		// Para txtResultado e exibido ao usuário
		btnCalcular.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for(int i = 1 ; i <= 10 ; i++) {
					dados += txtNumero.getText() + " x " + i + " = " +
					Integer.parseInt(txtNumero.getText()) * i + "\n";
				}
				
				txtResultado.setText(dados);
				txtNumero.setText("");
				// limpar a váriavel dados para que sempre após exibir o resultado
				// A variavel dados seja limpa para aguardar novos dados
				dados = "";
			}

			});
		
		// Comando para mostrar a janela:
		janela.setVisible(true);
	}

}
