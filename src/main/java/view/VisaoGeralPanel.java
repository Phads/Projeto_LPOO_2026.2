package view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;

public class VisaoGeralPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tableVisaoGeral;

	/**
	 * Create the panel.
	 */
	public VisaoGeralPanel() {
		setBackground(new Color(253, 245, 217));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 159, 1022, 346);
		add(scrollPane);
		
		tableVisaoGeral = new JTable();
		tableVisaoGeral.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Data Hora", "Resgistros Do Sistema"
			}
		));
		tableVisaoGeral.getColumnModel().getColumn(0).setPreferredWidth(115);
		tableVisaoGeral.getColumnModel().getColumn(1).setPreferredWidth(209);
		scrollPane.setViewportView(tableVisaoGeral);
		
		JPanel panel = new JPanel();
		panel.setBounds(30, 40, 317, 83);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chaves/Salas Ocupadas");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 297, 21);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("7/12");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 32, 297, 40);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(357, 40, 359, 83);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabelStatusViaturas = new JLabel("Chaves/Salas Ocupadas");
		lblNewLabelStatusViaturas.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabelStatusViaturas.setBounds(10, 11, 339, 21);
		panel_1.add(lblNewLabelStatusViaturas);
		
		JLabel lblNewLabel_1_1 = new JLabel("4/6");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(10, 32, 339, 40);
		panel_1.add(lblNewLabel_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(726, 40, 326, 83);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabelStatusVisitantes = new JLabel("Chaves/Salas Ocupadas");
		lblNewLabelStatusVisitantes.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabelStatusVisitantes.setBounds(10, 11, 306, 21);
		panel_2.add(lblNewLabelStatusVisitantes);
		
		JLabel lblNewLabel_1_2 = new JLabel("17");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(10, 32, 306, 40);
		panel_2.add(lblNewLabel_1_2);
		
		JButton btnNewButtonGerarPdf = new JButton("Gerar Relatório Geral (PDF)");
		btnNewButtonGerarPdf.setBounds(30, 0, 185, 34);
		add(btnNewButtonGerarPdf);
		
		JLabel lblNewLabelTitulo = new JLabel("Atividade Recente (Tempo Real)");
		lblNewLabelTitulo.setForeground(new Color(0, 128, 192));
		lblNewLabelTitulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabelTitulo.setBounds(31, 134, 213, 23);
		add(lblNewLabelTitulo);

	}
}
