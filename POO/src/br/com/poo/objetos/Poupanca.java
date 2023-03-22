package br.com.poo.objetos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Poupanca extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumeroConta;
	private JTextField txtTitular;
	private JTextField txtAgencia;
	private JTextField txtNumeroBanco;
	private JTextField txtSaldo;
	private JTextField txtValor;
	private JTextField txtRendimento;


	/**
	 * Create the frame.
	 */
	public Poupanca() {
		setTitle("SARFA BANK - Conta Poupança");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 788, 575);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(43, 75, 108));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNumeroConta = new JTextField();
		txtNumeroConta.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtNumeroConta.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "O CAMPO NÚMERO DA CONTA NÃO PODE SER VAZIO");
					txtNumeroConta.requestFocus();
				}
			}
		});
		txtNumeroConta.setForeground(new Color(255, 255, 255));
		txtNumeroConta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNumeroConta.setBackground(new Color(43, 75, 108));
		txtNumeroConta.setBounds(22, 53, 268, 37);
		contentPane.add(txtNumeroConta);
		txtNumeroConta.setColumns(10);
		
		JLabel lblNumeroConta = new JLabel("Número da Conta:");
		lblNumeroConta.setForeground(new Color(255, 218, 91));
		lblNumeroConta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNumeroConta.setBounds(22, 11, 190, 37);
		contentPane.add(lblNumeroConta);
		
		txtTitular = new JTextField();
		txtTitular.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtTitular.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "O CAMPO TITULAR NÃO PODE SER VAZIO");
					txtTitular.requestFocus();
				}
			}
		});
		txtTitular.setForeground(new Color(255, 255, 255));
		txtTitular.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTitular.setColumns(10);
		txtTitular.setBackground(new Color(43, 75, 108));
		txtTitular.setBounds(22, 145, 718, 37);
		contentPane.add(txtTitular);
		
		JLabel lblTitular = new JLabel("Titular:");
		lblTitular.setForeground(new Color(255, 218, 91));
		lblTitular.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitular.setBounds(22, 101, 190, 37);
		contentPane.add(lblTitular);
		
		txtAgencia = new JTextField();
		txtAgencia.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtAgencia.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "O CAMPO AGÊNCIA NÃO PODE SER VAZIO");
					txtAgencia.requestFocus();
				}
			}
		});
		txtAgencia.setForeground(new Color(255, 255, 255));
		txtAgencia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtAgencia.setColumns(10);
		txtAgencia.setBackground(new Color(43, 75, 108));
		txtAgencia.setBounds(350, 53, 129, 37);
		contentPane.add(txtAgencia);
		
		JLabel lblAgencia = new JLabel("Agência:");
		lblAgencia.setForeground(new Color(255, 218, 91));
		lblAgencia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAgencia.setBounds(350, 11, 190, 37);
		contentPane.add(lblAgencia);
		
		txtNumeroBanco = new JTextField();
		txtNumeroBanco.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtNumeroBanco.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "O CAMPO NÚMERO DO BANCO NÃO PODE SER VAZIO");
					txtNumeroBanco.requestFocus();
				}
			}
		});
		txtNumeroBanco.setForeground(new Color(255, 255, 255));
		txtNumeroBanco.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNumeroBanco.setColumns(10);
		txtNumeroBanco.setBackground(new Color(43, 75, 108));
		txtNumeroBanco.setBounds(550, 53, 170, 37);
		contentPane.add(txtNumeroBanco);
		
		JLabel lblNmeroDoBanco = new JLabel("Número do Banco:");
		lblNmeroDoBanco.setForeground(new Color(255, 218, 91));
		lblNmeroDoBanco.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNmeroDoBanco.setBounds(550, 11, 190, 37);
		contentPane.add(lblNmeroDoBanco);
		
		JLabel lblSaldo = new JLabel("Saldo Inicial:");
		lblSaldo.setForeground(new Color(255, 218, 91));
		lblSaldo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblSaldo.setBounds(22, 212, 190, 37);
		contentPane.add(lblSaldo);
		
		JButton btnVerificarSaldo = new JButton("Consultar Saldo");
		btnVerificarSaldo.setForeground(new Color(43, 75, 108));
		btnVerificarSaldo.setBackground(new Color(255, 218, 91));
		btnVerificarSaldo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnVerificarSaldo.setBounds(49, 372, 163, 127);
		contentPane.add(btnVerificarSaldo);
		btnVerificarSaldo.setEnabled(false);
		
		JButton btnSacar = new JButton("Sacar");
		btnSacar.setForeground(new Color(43, 75, 108));
		btnSacar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSacar.setBackground(new Color(255, 218, 91));
		btnSacar.setBounds(291, 455, 163, 44);
		contentPane.add(btnSacar);
		btnSacar.setEnabled(false);
		
		JButton btnDepositar = new JButton("Depositar");
		btnDepositar.setForeground(new Color(43, 75, 108));
		btnDepositar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDepositar.setBackground(new Color(255, 218, 91));
		btnDepositar.setBounds(291, 387, 163, 44);
		contentPane.add(btnDepositar);
		btnDepositar.setEnabled(false);
		
		txtSaldo = new JTextField();
		txtSaldo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtSaldo.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "O CAMPO SALDO INICIAL NÃO PODE SER VAZIO");
					txtSaldo.requestFocus();
				}
			}
		});
		txtSaldo.setForeground(new Color(255, 255, 255));
		txtSaldo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSaldo.setColumns(10);
		txtSaldo.setBackground(new Color(43, 75, 108));
		txtSaldo.setBounds(22, 260, 273, 49);
		contentPane.add(txtSaldo);
		
		txtValor = new JTextField();
		txtValor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtValor.setBounds(522, 387, 184, 112);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		txtValor.setEnabled(false);
		
		JLabel lblRendimento = new JLabel("Rendimento:");
		lblRendimento.setForeground(new Color(255, 218, 91));
		lblRendimento.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblRendimento.setBounds(462, 212, 190, 37);
		contentPane.add(lblRendimento);
		
		txtRendimento = new JTextField();
		txtRendimento.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtRendimento.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "O CAMPO RENDIMENTO NÃO PODE SER VAZIO");
					txtRendimento.requestFocus();
				}
				btnVerificarSaldo.setText("Abrir Conta");
				btnVerificarSaldo.setEnabled(true);
			}
		});
		txtRendimento.setForeground(new Color(255, 255, 255));
		txtRendimento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtRendimento.setColumns(10);
		txtRendimento.setBackground(new Color(43, 75, 108));
		txtRendimento.setBounds(462, 260, 244, 49);
		contentPane.add(txtRendimento);
	}
}
