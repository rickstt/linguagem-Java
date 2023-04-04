package br.com.projetoescola.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.Time;

import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.projetoescola.dao.CRUDCurso;
import br.com.projetoescola.domain.Curso;

public class GerenciarCurso extends JFrame {

	private JPanel contentPane;
	MaskFormatter di;
	MaskFormatter dt;
	MaskFormatter hi;
	MaskFormatter ht;
	CRUDCurso cc = new CRUDCurso();
	
	private JLabel lblCadastrar;
	private JLabel lblAtualizar;
	private JLabel lblConsultar;
	private JLabel lblApagar;
	
	private JLabel lblTitulo;
	private JTextField txtTitulo;
	private JLabel lblDescricao;
	private JTextArea txtDescricao;
	private JLabel lblDataInicio;
	private JFormattedTextField txtDataInicio;
	private JLabel lblDataTermino;
	private JFormattedTextField txtDataTermino;
	private JLabel lblHorarioInicio;
	private JFormattedTextField txtHorarioInicio;
	private JLabel lblHorarioTermino;
	private JFormattedTextField txtHorarioTermino;
	private Long id = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciarCurso frame = new GerenciarCurso();
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
	public GerenciarCurso() {
		
		try {
		
		setTitle("Gerenciador De Cursos 3000");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 855, 620);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBounds(10, 11, 189, 417);
		contentPane.add(panel);
		panel.setLayout(null);
		
		carregarTabela();
		
		lblCadastrar = new JLabel(" Cadastrar");
		lblCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCadastrar.setIcon(new ImageIcon("D:\\java\\Henrique\\POO\\src\\br\\com\\poo\\images\\verificar.png"));
		lblCadastrar.setForeground(SystemColor.desktop);
		lblCadastrar.setBounds(30, 75, 149, 35);
		panel.add(lblCadastrar);
		
		lblAtualizar = new JLabel(" Atualizar");
		lblAtualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Curso cadCurso = new Curso();
				
				if(txtTitulo.getText().trim().equals("") || txtDescricao.getText().trim().equals("") ||
				txtDataInicio.getText().trim().equals("") || txtDataTermino.getText().trim().equals("") ||
				txtHorarioInicio.getText().trim().equals("") || txtHorarioTermino.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.", "Erro 4000765x" , JOptionPane.ERROR_MESSAGE);
				}
				else {
					cadCurso.setTituloCurso(txtTitulo.getText());
					cadCurso.setDescricao(txtDescricao.getText());
					cadCurso.setDataInicio(Date.valueOf(txtDataInicio.getText()));
					cadCurso.setDataTermino(Date.valueOf(txtDataTermino.getText()));
					cadCurso.setHorarioInicio(Time.valueOf(txtHorarioInicio.getText()));
					cadCurso.setHorarioTermino(Time.valueOf(txtHorarioTermino.getText()));
					cadCurso.setIdCurso(id);
					
					JOptionPane.showMessageDialog(null, cc.atualizar(cadCurso));
					carregarTabela();
					limparCampos();
				}
			}
		});
		lblAtualizar.setIcon(new ImageIcon("D:\\java\\Henrique\\POO\\src\\br\\com\\poo\\images\\vire-a-direita.png"));
		lblAtualizar.setForeground(Color.BLACK);
		lblAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAtualizar.setBounds(30, 139, 149, 35);
		panel.add(lblAtualizar);
		
		lblConsultar = new JLabel(" Consultar");
		lblConsultar.setIcon(new ImageIcon("D:\\java\\Henrique\\POO\\src\\br\\com\\poo\\images\\procurar.png"));
		lblConsultar.setForeground(Color.BLACK);
		lblConsultar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConsultar.setBounds(30, 201, 149, 35);
		panel.add(lblConsultar);
		
		lblApagar = new JLabel(" Apagar");
		lblApagar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(id.equals(null)) {
					JOptionPane.showMessageDialog(null,"Selecione um curso para ser excluido.","Erro 4000770x" ,JOptionPane.ERROR_MESSAGE);
				}
				else {
					if(JOptionPane.showConfirmDialog(null, "Você tem certeza desta ação? \nEstá ação é permanente "
							+ "e não pode ser desfeita", "ATENÇÃO", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE) == 0                                                                      ) {
						
						Curso cr = new Curso();
						cr.setIdCurso(id);
						JOptionPane.showConfirmDialog(null, cc.apagar(cr));
						carregarTabela();
						limparCampos();
					}
				}
			}
		});
		lblApagar.setIcon(new ImageIcon("D:\\java\\Henrique\\POO\\src\\br\\com\\poo\\images\\cruz.png"));
		lblApagar.setForeground(Color.BLACK);
		lblApagar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblApagar.setBounds(30, 261, 149, 35);
		panel.add(lblApagar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.control);
		panel_1.setBounds(209, 11, 620, 416);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblDescricao = new JLabel("Descrição do curso:");
		lblDescricao.setBackground(new Color(0, 0, 0));
		lblDescricao.setForeground(new Color(0, 0, 0));
		lblDescricao.setBounds(10, 123, 138, 48);
		panel_1.add(lblDescricao);
		lblDescricao.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		lblTitulo = new JLabel("Título do curso:");
		lblTitulo.setForeground(new Color(0, 0, 0));
		lblTitulo.setBounds(10, 21, 138, 48);
		panel_1.add(lblTitulo);
		lblTitulo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(10, 73, 166, 37);
		panel_1.add(txtTitulo);
		txtTitulo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTitulo.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 165, 166, 240);
		panel_1.add(scrollPane_1);
		
		txtDescricao = new JTextArea();
		txtDescricao.setBackground(new Color(255, 255, 255));
		txtDescricao.setForeground(SystemColor.desktop);
		scrollPane_1.setViewportView(txtDescricao);
		
		lblDataInicio = new JLabel("Data de Início:");
		lblDataInicio.setForeground(new Color(0, 0, 0));
		lblDataInicio.setBounds(207, 65, 138, 48);
		panel_1.add(lblDataInicio);
		lblDataInicio.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		di = new MaskFormatter("####-##-##");
		di.setPlaceholderCharacter('_');
		
		txtDataInicio = new JFormattedTextField(di);
		txtDataInicio.setBounds(207, 123, 166, 32);
		panel_1.add(txtDataInicio);
		txtDataInicio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		lblDataTermino = new JLabel("Data de Término:");
		lblDataTermino.setForeground(new Color(0, 0, 0));
		lblDataTermino.setBounds(207, 184, 138, 48);
		panel_1.add(lblDataTermino);
		lblDataTermino.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		dt = new MaskFormatter("####-##-##");
		dt.setPlaceholderCharacter('_');
		
		txtDataTermino = new JFormattedTextField(dt);
		txtDataTermino.setBounds(207, 243, 166, 32);
		panel_1.add(txtDataTermino);
		txtDataTermino.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		lblHorarioInicio = new JLabel("Horário de Início:");
		lblHorarioInicio.setForeground(new Color(0, 0, 0));
		lblHorarioInicio.setBounds(427, 65, 138, 48);
		panel_1.add(lblHorarioInicio);
		lblHorarioInicio.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		hi = new MaskFormatter("##:##:##");
		
		txtHorarioInicio = new JFormattedTextField(hi);
		txtHorarioInicio.setBounds(427, 123, 166, 32);
		panel_1.add(txtHorarioInicio);
		txtHorarioInicio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		lblHorarioTermino = new JLabel("Horário de término:");
		lblHorarioTermino.setForeground(new Color(0, 0, 0));
		lblHorarioTermino.setBounds(427, 184, 138, 48);
		panel_1.add(lblHorarioTermino);
		lblHorarioTermino.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		ht = new MaskFormatter("##:##:##");
		
		txtHorarioTermino = new JFormattedTextField(ht);
		txtHorarioTermino.setBounds(427, 243, 166, 32);
		panel_1.add(txtHorarioTermino);
		txtHorarioTermino.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		
		lblCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Curso cadCurso = new Curso();
				
				if(txtTitulo.getText().trim().equals("") || txtDescricao.getText().trim().equals("") ||
				txtDataInicio.getText().trim().equals("") || txtDataTermino.getText().trim().equals("") ||
				txtHorarioInicio.getText().trim().equals("") || txtHorarioTermino.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.", "Erro 4000765x" , JOptionPane.ERROR_MESSAGE);
				}
				else {
					cadCurso.setTituloCurso(txtTitulo.getText());
					cadCurso.setDescricao(txtDescricao.getText());
					cadCurso.setDataInicio(Date.valueOf(txtDataInicio.getText()));
					cadCurso.setDataTermino(Date.valueOf(txtDataTermino.getText()));
					cadCurso.setHorarioInicio(Time.valueOf(txtHorarioInicio.getText()));
					cadCurso.setHorarioTermino(Time.valueOf(txtHorarioTermino.getText()));
					
					JOptionPane.showMessageDialog(null, cc.gravar(cadCurso) + " Foi Atualizado");
					carregarTabela();
					limparCampos();
				}
			}
		});
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void carregarTabela() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 440, 819, 130);
		contentPane.add(scrollPane);
		
		String[] cabecalho = {
			"Id Curso",
			"Título do Curso",
			"Descrição do Curso",
			"Data de Início",
			"Data de Término",
			"Horário de Início",
			"Horário de Término"
		};
		
		Object[][] dados = new Object[cc.listar().size()][7];
		for(int i = 0 ; i < dados.length ; i++) {
			dados[i][0] = cc.listar().get(i).getIdCurso();
			dados[i][1] = cc.listar().get(i).getTituloCurso();
			dados[i][2] = cc.listar().get(i).getDescricao();
			dados[i][3] = cc.listar().get(i).getDataInicio();
			dados[i][4] = cc.listar().get(i).getDataTermino();
			dados[i][5] = cc.listar().get(i).getHorarioInicio();
			dados[i][6] = cc.listar().get(i).getHorarioTermino();
		}
		
		DefaultTableModel model = new DefaultTableModel(dados,cabecalho);
		
		JTable table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtTitulo.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),1)));
				txtDescricao.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),2)));
				txtDataInicio.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),3)));
				txtDataTermino.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),4)));
				txtHorarioInicio.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),5)));
				txtHorarioTermino.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),6)));
				
				id = Long.parseLong(String.valueOf(table.getValueAt(table.getSelectedRow(),0)));
			}
		});
		table.setForeground(SystemColor.desktop);
		table.setBackground(SystemColor.control);
		scrollPane.setViewportView(table);
	}
	private void limparCampos() {
		txtTitulo.setText("");
		txtDescricao.setText("");
		txtDataInicio.setText("");
		txtDataTermino.setText("");
		txtHorarioInicio.setText("");
		txtHorarioTermino.setText("");
	}
}
