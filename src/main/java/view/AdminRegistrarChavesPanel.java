package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class AdminRegistrarChavesPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField campoIdentificacao;
	private JTextField campoNomeChave;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public AdminRegistrarChavesPanel() {
		setLayout(null);
		
		JLabel lblTitulo = new JLabel("Cadastrar Nova Chave");
		lblTitulo.setBounds(28, 11, 132, 14);
		add(lblTitulo);
		
		JLabel lblIdentificacao = new JLabel("Identificação:");
		lblIdentificacao.setBounds(28, 36, 77, 14);
		add(lblIdentificacao);
		
		campoIdentificacao = new JTextField();
		campoIdentificacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblTitulo.getText();
			}
		});
		campoIdentificacao.setBounds(109, 33, 107, 20);
		add(campoIdentificacao);
		campoIdentificacao.setColumns(10);
		
		JLabel JLabelNomeChave = new JLabel("Nome da Chave:");
		JLabelNomeChave.setBounds(238, 36, 97, 14);
		add(JLabelNomeChave);
		
		campoNomeChave = new JTextField();
		campoNomeChave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLabelNomeChave.getText();
			}
		});
		campoNomeChave.setToolTipText("");
		campoNomeChave.setColumns(10);
		campoNomeChave.setBounds(345, 33, 115, 20);
		add(campoNomeChave);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 125, 891, 293);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					 "ID", "Nome Chave", "Setor" ,"Status no sistema"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(2).setMinWidth(20);
		
		JLabel JLabelSetor_1 = new JLabel("Setor:");
		JLabelSetor_1.setBounds(497, 36, 51, 14);
		add(JLabelSetor_1);
		
		JLabel JLabelStatusNoSistema = new JLabel("Status:");
		JLabelStatusNoSistema.setBounds(677, 36, 51, 14);
		add(JLabelStatusNoSistema);
		
		JComboBox<String> comboBoxStatusChaves = new JComboBox<>();
		comboBoxStatusChaves.setModel(new DefaultComboBoxModel<>(new String[] {"Ativo", "Inativo", "Perdido"}));
		comboBoxStatusChaves.setBounds(724, 32, 113, 22);
		add(comboBoxStatusChaves);
		
		JComboBox<String> comboBoxSetor = new JComboBox<>();
		comboBoxSetor.setModel(new DefaultComboBoxModel<>(new String[] {"Engenharia", "Tecnologia", "Monitoramento", "Estoque", "Sala de Reuniões", "Auditorio", "Gabinete"}));
		comboBoxSetor.setBounds(547, 32, 115, 22);
		add(comboBoxSetor);
		
		
		JButton btnEditarChave = new JButton("Editar Chave");
		btnEditarChave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormEditarInfoChavesDialog dialogEditarChave = new FormEditarInfoChavesDialog();
				dialogEditarChave.setLocationRelativeTo(null);
				dialogEditarChave.setVisible(true);
			}
		});
		btnEditarChave.setBounds(159, 78, 110, 23);
		add(btnEditarChave);
		
		JButton btnSalvarRegistro = new JButton("Salvar Registro");
		btnSalvarRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				Object[] dados = {campoIdentificacao.getText(), campoNomeChave.getText(),  comboBoxSetor.getSelectedItem().toString(), comboBoxStatusChaves.getSelectedItem().toString()};
				modelo.addRow(dados);
			}
		});
		btnSalvarRegistro.setBounds(28, 78, 121, 23);
		add(btnSalvarRegistro);
	}
}
