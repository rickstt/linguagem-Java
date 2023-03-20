package br.com.poo.array;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Padaria extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigoProduto;
	private JTextField txtCodigoBarras;
	private JTextField txtDescricao;
	private JTextField txtValorUnitario;
	private JTextField txtQuantidade;
	private JTextField txtTotalItens;
	private JTextField txtSubTotal;
	private JTextArea txtNota;
	private String cabecalho;
	private int item;
	private double valorPagar;
	private JLabel lblValorPagar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Padaria frame = new Padaria();
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
	public Padaria() {
		
		valorPagar = 0.0;
		item = 1;
		
		cabecalho = "\t\t\t\t    Ferracin - Pães & Cia" + 
					"\n\tAv. Rua Euroupa, 319 - Jardim Europa" + 
					"\n\tCEP: 01449-001 - São Paulo - SP" + 
					"\n\tCNPJ: 40.049.527/0001-25" +
					"\n\tIE: 406.900.586.686" + 
					"\n\tIM: 1.102.442/001-0" +
					"\n -----------------------------------------------------------------------------------------------" +
					"\n\t\t\t\t\tCupom Fiscal" +
					"\n  Item\tCódigo\tdescricao\t\t\t\t    Qtd\t      VL.Unit.\t\tTotal" +
					"\n -----------------------------------------------------------------------------------------------" 
					
					;
		
		String[][] produtos = {
				{"2023","Pão Francês","13.00","17032023"},
				{"2024","Pão de Leite","14.99","17032024"},
				{"2025","Torta de Frango","49.90","17032025"},
				{"2026","Leite Integral A","4.97","17032026"},
				{"2027","Manteiga","6.97","17032027"},
				{"2028","Bolo","19.99","17032028"},
				{"2029","Bauru","11.98","17032029"},
				{"2030","Suco Laranja","6.99","17032030"}
		};
		
		
		
		
		
		
		setResizable(false);
		setTitle("Janela Padaria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1600, 900);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlEsquerdo = new JPanel();
		pnlEsquerdo.setBackground(new Color(89, 0, 2));
		pnlEsquerdo.setBounds(0, 0, 800, 700);
		contentPane.add(pnlEsquerdo);
		pnlEsquerdo.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(0, 0, 800, 250);
		
		 /*
		 * Para ajustar a imagem ao tamanho da label, foi necessário aplicar o comando new ImageIcon
		 * para definir a escala no elemento getImage. O tamanho da imagem foi ajustado para largura da label(lblGetWidth)
		 * e a altura da label(lblGetHeight. E para finalizar, foi alterado a frma de fechamento da imagem quando a tela fecha,
		 * foi setado o valor para suavização (image.SCALE_SMOOTH))
		 */
		lblLogo.setIcon(new ImageIcon(new ImageIcon(Padaria.class.getResource
				("/br/com/poo/images/branding-logo-marca-icone-dz9-design-logo-padaria-marialva-cafe-embalagem-pao-bolo-chocolate-expresso-capuccino-forno-lenha-sol22.jpg"))
				.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH)));
		
		pnlEsquerdo.add(lblLogo);
		
		JLabel lblCodigoProduto = new JLabel("Código do Produto:");
		lblCodigoProduto.setFont(new Font("Perpetua", Font.BOLD, 25));
		lblCodigoProduto.setForeground(SystemColor.textHighlightText);
		lblCodigoProduto.setBounds(35, 261, 238, 24);
		pnlEsquerdo.add(lblCodigoProduto);
		
		JLabel lblCodigoBarras = new JLabel("Código do Barras:");
		lblCodigoBarras.setForeground(Color.WHITE);
		lblCodigoBarras.setFont(new Font("Perpetua", Font.BOLD, 25));
		lblCodigoBarras.setBounds(557, 261, 199, 24);
		pnlEsquerdo.add(lblCodigoBarras);
		
		txtCodigoProduto = new JTextField();
		txtCodigoProduto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				for(int linha = 0 ; linha < produtos.length ; linha++) {
					for(int coluna = 0 ; coluna < produtos[0].length ; coluna ++) {
						if(txtCodigoProduto.getText().equals(produtos[linha][0])) {
							txtCodigoBarras.setText(produtos[linha][3]);
							txtDescricao.setText(produtos[linha][1]);
							txtValorUnitario.setText(produtos[linha][2]);
							break;
						}
					}
				}
				
			}
		});
		txtCodigoProduto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCodigoProduto.setForeground(Color.WHITE);
		txtCodigoProduto.setBackground(new Color(89, 0, 2));
		txtCodigoProduto.setBounds(58, 296, 160, 40);
		pnlEsquerdo.add(txtCodigoProduto);
		txtCodigoProduto.setColumns(10);
		txtCodigoProduto.setBorder(null);
		
		txtCodigoBarras = new JTextField();
		txtCodigoBarras.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCodigoBarras.setForeground(Color.WHITE);
		txtCodigoBarras.setColumns(10);
		txtCodigoBarras.setBackground(new Color(89, 0, 2));
		txtCodigoBarras.setBounds(567, 296, 160, 40);
		pnlEsquerdo.add(txtCodigoBarras);
		txtCodigoBarras.setBorder(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(34, 362, 722, 2);
		pnlEsquerdo.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(390, 283, 1, 53);
		pnlEsquerdo.add(separator_1);
		
		JLabel lblDescricao = new JLabel("Descrição:");
		lblDescricao.setForeground(Color.WHITE);
		lblDescricao.setFont(new Font("Perpetua", Font.BOLD, 25));
		lblDescricao.setBounds(35, 375, 238, 24);
		pnlEsquerdo.add(lblDescricao);
		
		txtDescricao = new JTextField();
		txtDescricao.setForeground(Color.WHITE);
		txtDescricao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDescricao.setColumns(10);
		txtDescricao.setBackground(new Color(89, 0, 2));
		txtDescricao.setBounds(58, 410, 669, 40);
		pnlEsquerdo.add(txtDescricao);
		txtDescricao.setBorder(null);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(35, 474, 722, 2);
		pnlEsquerdo.add(separator_2);
		
		JLabel lblValorUnitario = new JLabel("Valor Unitário:");
		lblValorUnitario.setForeground(Color.WHITE);
		lblValorUnitario.setFont(new Font("Perpetua", Font.BOLD, 20));
		lblValorUnitario.setBounds(69, 487, 238, 24);
		pnlEsquerdo.add(lblValorUnitario);
		
		txtValorUnitario = new JTextField();
		txtValorUnitario.setForeground(Color.WHITE);
		txtValorUnitario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtValorUnitario.setColumns(10);
		txtValorUnitario.setBackground(new Color(89, 0, 2));
		txtValorUnitario.setBounds(58, 509, 160, 40);
		pnlEsquerdo.add(txtValorUnitario);
		txtValorUnitario.setBorder(null);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setForeground(Color.WHITE);
		lblQuantidade.setFont(new Font("Perpetua", Font.BOLD, 20));
		lblQuantidade.setBounds(334, 487, 238, 24);
		pnlEsquerdo.add(lblQuantidade);
		
		txtQuantidade = new JTextField();
		
		txtQuantidade.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				txtTotalItens.setText("" +
							Double.parseDouble(txtQuantidade.getText()) * 
							Double.parseDouble(txtValorUnitario.getText()) 
						);
				txtSubTotal.setText("R$ " +
						Double.parseDouble(txtQuantidade.getText()) * 
						Double.parseDouble(txtValorUnitario.getText()) 
				);
			}
		});
		txtQuantidade.setForeground(Color.WHITE);
		txtQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtQuantidade.setColumns(10);
		txtQuantidade.setBackground(new Color(89, 0, 2));
		txtQuantidade.setBounds(317, 509, 160, 40);
		pnlEsquerdo.add(txtQuantidade);
		txtQuantidade.setBorder(null);
		
		JLabel lblTotalItens = new JLabel("Total de Itens:");
		lblTotalItens.setForeground(Color.WHITE);
		lblTotalItens.setFont(new Font("Perpetua", Font.BOLD, 20));
		lblTotalItens.setBounds(582, 487, 238, 24);
		pnlEsquerdo.add(lblTotalItens);
		
		txtTotalItens = new JTextField();
		txtTotalItens.setForeground(Color.WHITE);
		txtTotalItens.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTotalItens.setColumns(10);
		txtTotalItens.setBackground(new Color(89, 0, 2));
		txtTotalItens.setBounds(567, 509, 160, 40);
		pnlEsquerdo.add(txtTotalItens);
		txtTotalItens.setBorder(null);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1.setForeground(Color.LIGHT_GRAY);
		separator_1_1.setBounds(272, 496, 1, 53);
		pnlEsquerdo.add(separator_1_1);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setOrientation(SwingConstants.VERTICAL);
		separator_1_2.setForeground(Color.LIGHT_GRAY);
		separator_1_2.setBounds(524, 496, 1, 53);
		pnlEsquerdo.add(separator_1_2);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(34, 571, 722, 2);
		pnlEsquerdo.add(separator_2_1);
		
		txtSubTotal = new JTextField();
		txtSubTotal.setForeground(Color.WHITE);
		txtSubTotal.setFont(new Font("Tahoma", Font.PLAIN, 40));
		txtSubTotal.setColumns(10);
		txtSubTotal.setBackground(new Color(89, 0, 2));
		txtSubTotal.setBounds(58, 624, 281, 53);
		pnlEsquerdo.add(txtSubTotal);
		txtSubTotal.setBorder(null);
		
		JLabel lblSubTotal = new JLabel("Sub Total:");
		lblSubTotal.setForeground(Color.WHITE);
		lblSubTotal.setFont(new Font("Perpetua", Font.BOLD, 25));
		lblSubTotal.setBounds(35, 584, 238, 24);
		pnlEsquerdo.add(lblSubTotal);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cabecalho += "\n" + " " + item +"\t"+ txtCodigoProduto.getText() +
						"\t" + txtDescricao.getText() + "\t\t\t\t" + txtQuantidade.getText() +
						"\t" + txtValorUnitario.getText() + "\t" + txtSubTotal.getText();
				
				txtNota.setText(cabecalho);
				item ++;
				
				valorPagar += Double.parseDouble(txtTotalItens.getText());
				lblValorPagar.setText("R$ " + valorPagar);

			}
		});
		btnIncluir.setForeground(Color.WHITE);
		btnIncluir.setBackground(new Color(28, 109, 16));
		btnIncluir.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnIncluir.setBounds(511, 624, 216, 53);
		pnlEsquerdo.add(btnIncluir);
		
		JPanel pnlDireito = new JPanel();
		pnlDireito.setBackground(SystemColor.controlHighlight);
		pnlDireito.setBounds(805, 0, 779, 700);
		contentPane.add(pnlDireito);
		pnlDireito.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 779, 700);
		pnlDireito.add(scrollPane);
		
		txtNota = new JTextArea();
		txtNota.setFont(new Font("Monospaced", Font.PLAIN, 14));
		txtNota.setBackground(SystemColor.scrollbar);
		scrollPane.setViewportView(txtNota);
		txtNota.setText(cabecalho);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBounds(0, 705, 1584, 155);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("New label");
		label.setBounds(-19, 11, 10, 22);
		panel.add(label);
		
		JLabel lblTotalPagar = new JLabel("Total a Pagar:");
		lblTotalPagar.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblTotalPagar.setBounds(23, 24, 541, 109);
		panel.add(lblTotalPagar);
		
		lblValorPagar = new JLabel("");
		lblValorPagar.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblValorPagar.setBounds(805, 35, 308, 86);
		panel.add(lblValorPagar);
		lblValorPagar.setText("R$ " + valorPagar);
	}
}
