package br.com.poo.objetos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaConta extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaConta frame = new JanelaConta();
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
	public JanelaConta() {
		setTitle("SARFA BANK");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 353);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(43, 75, 108));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPoupanca = new JButton("Poupança");
		btnPoupanca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Poupanca jp = new Poupanca();
				jp.setVisible(true);
				
			}
		});
		btnPoupanca.setFont(new Font("Monaco", Font.BOLD, 25));
		btnPoupanca.setForeground(new Color(255, 218, 91));
		btnPoupanca.setBackground(new Color(43, 75, 108));
		btnPoupanca.setBounds(39, 191, 209, 38);
		contentPane.add(btnPoupanca);
		
		JButton btnCorrente = new JButton("Corrente");
		btnCorrente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Corrente jc = new Corrente();
				jc.setVisible(true);
			}
		});
		btnCorrente.setFont(new Font("Monaco", Font.BOLD, 25));
		btnCorrente.setForeground(new Color(255, 218, 91));
		btnCorrente.setBackground(new Color(43, 75, 108));
		btnCorrente.setBounds(322, 191, 209, 38);
		contentPane.add(btnCorrente);
		
		JLabel lblNewLabel = new JLabel("SARFA BANK");
		lblNewLabel.setBackground(new Color(17, 113, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 218, 91));
		lblNewLabel.setFont(new Font("Monaco", Font.BOLD, 30));
		lblNewLabel.setBounds(87, 11, 402, 150);
		contentPane.add(lblNewLabel);
	}
}
