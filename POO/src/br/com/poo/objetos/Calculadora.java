package br.com.poo.objetos;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Calculadora extends JFrame {

	private JPanel contentPane;
	private int resultado;
	private String valor1;
	private String valor2;
	private String operacao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora frame = new Calculadora();
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
	public Calculadora() {
		resultado = 0;
		operacao = "";
		
		
		
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 389, 475);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPainel = new JLabel("");
		lblPainel.setForeground(SystemColor.text);
		lblPainel.setBackground(SystemColor.windowText);
		lblPainel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblPainel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPainel.setBounds(10, 11, 350, 108);
		contentPane.add(lblPainel);
		lblPainel.setText("0");
		
		JButton btnSoma = new JButton("+");
		btnSoma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valor1 = lblPainel.getText();
				operacao = "+";
				
				lblPainel.setText("0");
				
				System.out.println(valor1);
			}
		});
		btnSoma.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSoma.setForeground(new Color(255, 255, 255));
		btnSoma.setBackground(new Color(63, 63, 63));
		btnSoma.setBounds(10, 154, 80, 40);
		contentPane.add(btnSoma);
		
		JButton btnSubtracao = new JButton("-");
		btnSubtracao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valor1 = lblPainel.getText();
				operacao = "-";
				
				lblPainel.setText("0");
			}
		});
		btnSubtracao.setForeground(Color.WHITE);
		btnSubtracao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSubtracao.setBackground(new Color(63, 63, 63));
		btnSubtracao.setBounds(100, 154, 80, 40);
		contentPane.add(btnSubtracao);
		
		JButton btnMultiplicacao = new JButton("*");
		btnMultiplicacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valor1 = lblPainel.getText();
				operacao = "*";
				
				lblPainel.setText("0");
			}
		});
		btnMultiplicacao.setForeground(Color.WHITE);
		btnMultiplicacao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMultiplicacao.setBackground(new Color(63, 63, 63));
		btnMultiplicacao.setBounds(190, 154, 80, 40);
		contentPane.add(btnMultiplicacao);
		
		JButton btnDivisao = new JButton("/");
		btnDivisao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valor1 = lblPainel.getText();
				operacao = "/";
				
				lblPainel.setText("0");
			}
		});
		btnDivisao.setForeground(Color.WHITE);
		btnDivisao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDivisao.setBackground(new Color(63, 63, 63));
		btnDivisao.setBounds(280, 154, 80, 40);
		contentPane.add(btnDivisao);
		
		JButton btnCe = new JButton("CE");
		btnCe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valor1 = "";
				operacao = "";
				lblPainel.setText("0");
			}
		});
		btnCe.setForeground(Color.WHITE);
		btnCe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCe.setBackground(new Color(63, 63, 63));
		btnCe.setBounds(280, 210, 80, 53);
		contentPane.add(btnCe);
		
		JButton btnDivisao_2 = new JButton("=");
		btnDivisao_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valor2 = lblPainel.getText();
				
				int numero1 = Integer.parseInt(valor1);
				int numero2 = Integer.parseInt(valor2);
				
				switch(operacao) {
					case "+":
						resultado = (numero1 + numero2);
						lblPainel.setText(""+resultado);
					break;
					case "-":
						resultado = (numero1 - numero2);
						lblPainel.setText(""+resultado);
					break;
					case "*":
						resultado = (numero1 * numero2);
						lblPainel.setText(""+resultado);
					break;
					case "/":
						resultado = (numero1 / numero2);
						lblPainel.setText(""+resultado);
					break;
				}
			}
		});
		btnDivisao_2.setForeground(Color.WHITE);
		btnDivisao_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnDivisao_2.setBackground(new Color(0, 191, 255));
		btnDivisao_2.setBounds(280, 274, 80, 151);
		contentPane.add(btnDivisao_2);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lblPainel.getText().equals("0")) {
					lblPainel.setText("7");
				}
				else {
					lblPainel.setText(lblPainel.getText() + "7");
				}
			}
		});
		btn7.setForeground(Color.WHITE);
		btn7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn7.setBackground(new Color(91, 91, 91));
		btn7.setBounds(10, 210, 80, 40);
		contentPane.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(lblPainel.getText().equals("0")) {
					lblPainel.setText("8");
				}
				else {
					lblPainel.setText(lblPainel.getText() + "8");
				}
				
			}
		});
		btn8.setForeground(Color.WHITE);
		btn8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn8.setBackground(new Color(91, 91, 91));
		btn8.setBounds(100, 210, 80, 40);
		contentPane.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lblPainel.getText().equals("0")) {
					lblPainel.setText("9");
				}
				else {
					lblPainel.setText(lblPainel.getText() + "9");
				}
			}
		});
		btn9.setForeground(Color.WHITE);
		btn9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn9.setBackground(new Color(91, 91, 91));
		btn9.setBounds(190, 210, 80, 40);
		contentPane.add(btn9);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lblPainel.getText().equals("0")) {
					lblPainel.setText("4");
				}
				else {
					lblPainel.setText(lblPainel.getText() + "4");
				}
			}
		});
		btn4.setForeground(Color.WHITE);
		btn4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn4.setBackground(new Color(91, 91, 91));
		btn4.setBounds(10, 261, 80, 40);
		contentPane.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lblPainel.getText().equals("0")) {
					lblPainel.setText("5");
				}
				else {
					lblPainel.setText(lblPainel.getText() + "5");
				}
			}
		});
		btn5.setForeground(Color.WHITE);
		btn5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn5.setBackground(new Color(91, 91, 91));
		btn5.setBounds(100, 261, 80, 40);
		contentPane.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lblPainel.getText().equals("0")) {
					lblPainel.setText("6");
				}
				else {
					lblPainel.setText(lblPainel.getText() + "6");
				}
			}
		});
		btn6.setForeground(Color.WHITE);
		btn6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn6.setBackground(new Color(91, 91, 91));
		btn6.setBounds(190, 261, 80, 40);
		contentPane.add(btn6);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lblPainel.getText().equals("0")) {
					lblPainel.setText("1");
				}
				else {
					lblPainel.setText(lblPainel.getText() + "1");
				}
				
			}
		});
		btn1.setForeground(Color.WHITE);
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn1.setBackground(new Color(91, 91, 91));
		btn1.setBounds(10, 312, 80, 40);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lblPainel.getText().equals("0")) {
					lblPainel.setText("2");
				}
				else {
					lblPainel.setText(lblPainel.getText() + "2");
				}
			}
		});
		btn2.setForeground(Color.WHITE);
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn2.setBackground(new Color(91, 91, 91));
		btn2.setBounds(100, 312, 80, 40);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lblPainel.getText().equals("0")) {
					lblPainel.setText("3");
				}
				else {
					lblPainel.setText(lblPainel.getText() + "3");
				}
			}
		});
		btn3.setForeground(Color.WHITE);
		btn3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn3.setBackground(new Color(91, 91, 91));
		btn3.setBounds(190, 312, 80, 40);
		contentPane.add(btn3);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lblPainel.getText().equals("0")) {
					lblPainel.setText("0" + lblPainel.getText());
				}
				else {
					lblPainel.setText(lblPainel.getText() + "0");
				}
			}
		});
		btn0.setForeground(Color.WHITE);
		btn0.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn0.setBackground(new Color(91, 91, 91));
		btn0.setBounds(100, 368, 80, 40);
		contentPane.add(btn0);
	}
}
