package br.com.projetotelemarketing.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.projetotelemarketing.dao.CRUDChamado;
import br.com.projetotelemarketing.domain.Chamado;

public class Solicitacoes extends JFrame {

	private JPanel contentPane;
	CRUDChamado cc = new CRUDChamado();
	
	private JTextField txtDepartamento;
	private JTextField txtNome;
	private JLabel lblTitulo;
	private JLabel lblNome;
	private JLabel lblDescricao;
	private JLabel lblDepartamento;
	private JTextArea txtDescricao;
	private JLabel lblRealizarChamado;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Solicitacoes frame = new Solicitacoes();
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
	public Solicitacoes() {
		setTitle("Sistema de Suporte");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 571);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblRealizarChamado = new JLabel("Registrar Chamado");
		lblRealizarChamado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Chamado soliChamado = new Chamado();
				
				if(txtNome.getText().trim().equals("") || txtDepartamento.getText().trim().equals("") || txtDescricao.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.", "Erro 4000765x" , JOptionPane.ERROR_MESSAGE);
				}
				else {
					soliChamado.setSolicitacao(txtNome.getText());
					soliChamado.setDepSolicitado(txtDepartamento.getText());
					soliChamado.setDescChamado(txtDescricao.getText());
					
					JOptionPane.showMessageDialog(null, cc.registrar(soliChamado));
					
					limparCampos();
				}
			}
		});
		lblRealizarChamado.setHorizontalAlignment(SwingConstants.CENTER);
		lblRealizarChamado.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		lblRealizarChamado.setBounds(51, 250, 151, 40);
		contentPane.add(lblRealizarChamado);
		
		
		lblTitulo = new JLabel("Preencha todos os campos para efetuar um chamado");
		lblTitulo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		lblTitulo.setBounds(279, 11, 505, 32);
		contentPane.add(lblTitulo);

		lblNome = new JLabel("Insira seu nome:");
		lblNome.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		lblNome.setBounds(279, 89, 151, 32);
		contentPane.add(lblNome);
		
		lblDescricao = new JLabel("Conte-nos mais sobre seu problema:");
		lblDescricao.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		lblDescricao.setBounds(279, 272, 251, 32);
		contentPane.add(lblDescricao);
		
		lblDepartamento = new JLabel("Informe com qual departamento deseja falar:");
		lblDepartamento.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		lblDepartamento.setBounds(279, 183, 304, 32);
		contentPane.add(lblDepartamento);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(279, 322, 495, 199);
		contentPane.add(scrollPane);
		
		txtDescricao = new JTextArea();
		scrollPane.setViewportView(txtDescricao);
	
		txtDepartamento = new JTextField();
		txtDepartamento.setBounds(279, 229, 304, 32);
		contentPane.add(txtDepartamento);
		txtDepartamento.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(279, 132, 304, 32);
		contentPane.add(txtNome);
		
		JLabel lblLayout = new JLabel("");
		lblLayout.setIcon(new ImageIcon("D:\\java\\Henrique\\ProjetoTelemarketing\\src\\br\\com\\projetotelemarketing\\images\\Sem Título-1.png"));
		lblLayout.setBounds(0, 0, 784, 532);
		contentPane.add(lblLayout);
		
		
	}
	private void limparCampos() {
		txtNome.setText("");
		txtDepartamento.setText("");
		txtDescricao.setText("");
	}
}
