package br.com.poo.estruturarepeticao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EstruturaWhile1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtInicial;
	private JTextField txtFinal;

	String dados = "";
	int i;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstruturaWhile1 frame = new EstruturaWhile1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EstruturaWhile1() {
		setResizable(false);
		setBackground(Color.YELLOW);
		setTitle("Janela Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 418);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Número Inicial");
		lblNewLabel.setForeground(SystemColor.activeCaptionText);
		lblNewLabel.setFont(new Font("Monaco", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 11, 138, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Número Final");
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Monaco", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(SystemColor.activeCaptionText);
		lblNewLabel_1.setBounds(10, 36, 138, 14);
		contentPane.add(lblNewLabel_1);
		
		txtInicial = new JTextField();
		txtInicial.setBackground(Color.WHITE);
		txtInicial.setFont(new Font("Monaco", Font.ITALIC, 11));
		txtInicial.setBounds(158, 8, 86, 20);
		contentPane.add(txtInicial);
		txtInicial.setColumns(10);
		
		txtFinal = new JTextField();
		txtFinal.setBackground(Color.WHITE);
		txtFinal.setFont(new Font("Monaco", Font.ITALIC, 11));
		txtFinal.setBounds(158, 33, 86, 20);
		contentPane.add(txtFinal);
		txtFinal.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 109, 234, 259);
		contentPane.add(scrollPane);
		
		JTextArea txtResultado = new JTextArea();
		txtResultado.setFont(new Font("Monaco", Font.PLAIN, 13));
		scrollPane.setViewportView(txtResultado);
		
		JButton btnExecutar = new JButton("Executar");
		btnExecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				i = Integer.parseInt(txtInicial.getText());
				
				while(i <= Integer.parseInt(txtFinal.getText())) {
					dados += i + "\n";	
					i++;
				}
				txtResultado.setText(dados);
				txtInicial.setText("");
				txtFinal.setText("");
				dados = "";
			}
		});
		btnExecutar.setBackground(Color.WHITE);
		btnExecutar.setFont(new Font("Monaco", Font.BOLD, 18));
		btnExecutar.setBounds(10, 61, 234, 37);
		contentPane.add(btnExecutar);
	}
}
