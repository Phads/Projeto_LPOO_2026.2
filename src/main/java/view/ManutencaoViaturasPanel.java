package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class ManutencaoViaturasPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ManutencaoViaturasPanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registrar Viatura em Manutenção");
		lblNewLabel.setBounds(10, 10, 170, 21);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Viatuaras:");
		lblNewLabel_1.setBounds(10, 45, 60, 12);
		add(lblNewLabel_1);
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel<>(new String[] {"Viaturas cadastradas"}));
		comboBox.setBounds(66, 41, 161, 20);
		add(comboBox);
		
		JComboBox<String> comboBox_2 = new JComboBox<>();
		comboBox_2.setModel(new DefaultComboBoxModel<>(new String[] {"Preventiva", "Corretiva", "Sinistro", "Reparo"}));
		comboBox_2.setBounds(282, 41, 119, 20);
		add(comboBox_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tipo:");	
		lblNewLabel_1_1.setBounds(237, 45, 35, 12);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Oficinal / Locadora:");
		lblNewLabel_2.setBounds(411, 45, 110, 12);
		add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(531, 42, 145, 18);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(782, 42, 197, 18);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Enviar p/ Manutenção");
		btnNewButton.setBounds(1002, 41, 149, 20);
		add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Motivo / Serviço");
		lblNewLabel_3.setBounds(686, 45, 99, 12);
		add(lblNewLabel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 119, 969, 488);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Viatura / Placa", "Tipo", "Oficina", "Descri\u00E7\u00E3o do Servi\u00E7o", "Data Entrada", "Data Conclus\u00E3o", "Status"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_2 = new JButton("Concluir Manutenção");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(10, 78, 149, 20);
		add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Gerar Relatório");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2_1.setBounds(169, 78, 128, 20);
		add(btnNewButton_2_1);
		
		
	}
}
