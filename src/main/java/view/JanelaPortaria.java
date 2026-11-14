package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class JanelaPortaria extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable TabelaRegistrosPortariaTable;
	private JTextField RegistrarNomeText;
	private JTextField RegistrarPlacaText;
	private JTextField RegistrarDocumentoText;
	private JComboBox<String> TiposComboBox;
	private JTextField RegistrarVeiculoText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPortaria frame = new JanelaPortaria();
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
	public JanelaPortaria() {
		setForeground(new Color(255, 241, 230));
		setBackground(new Color(255, 241, 230));
		setTitle("Sistema de Logística e Controle da Defesa Civil");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton ChavedeSalasButton = new JButton("Chaves de sala");
		ChavedeSalasButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ChavedeSalasButton.setForeground(new Color(40, 40, 40));
		ChavedeSalasButton.setFont(new Font("Arial", Font.PLAIN, 12));
		ChavedeSalasButton.setBackground(new Color(220, 220, 220));
		ChavedeSalasButton.setBounds(130, 10, 115, 31);
		contentPane.add(ChavedeSalasButton);
		
		JButton VisaoGeralButton = new JButton("Visão geral");
		VisaoGeralButton.setForeground(new Color(40, 40, 40));
		VisaoGeralButton.setFont(new Font("Arial", Font.PLAIN, 12));
		VisaoGeralButton.setBackground(new Color(220, 220, 220));
		VisaoGeralButton.setBounds(10, 10, 122, 31);
		contentPane.add(VisaoGeralButton);
		
		JButton ViaturasButton = new JButton("Viaturas");
		ViaturasButton.setForeground(new Color(40, 40, 40));
		ViaturasButton.setFont(new Font("Arial", Font.PLAIN, 12));
		ViaturasButton.setBackground(new Color(220, 220, 220));
		ViaturasButton.setBounds(243, 10, 115, 31);
		contentPane.add(ViaturasButton);
		
		JButton PortariaButton = new JButton("Portaria/Acesso");
		PortariaButton.setForeground(new Color(40, 40, 40));
		PortariaButton.setFont(new Font("Arial", Font.PLAIN, 12));
		PortariaButton.setBackground(new Color(220, 220, 220));
		PortariaButton.setBounds(356, 10, 132, 31);
		contentPane.add(PortariaButton);
		
		JButton ManutencaoFrotasButton = new JButton("Manutenção de frotas");
		ManutencaoFrotasButton.setForeground(new Color(40, 40, 40));
		ManutencaoFrotasButton.setFont(new Font("Arial", Font.PLAIN, 12));
		ManutencaoFrotasButton.setBackground(new Color(220, 220, 220));
		ManutencaoFrotasButton.setBounds(487, 10, 175, 31);
		contentPane.add(ManutencaoFrotasButton);
		
		JButton AdministracaoButton = new JButton("Administração");
		AdministracaoButton.setForeground(new Color(40, 40, 40));
		AdministracaoButton.setFont(new Font("Arial", Font.PLAIN, 12));
		AdministracaoButton.setBackground(new Color(220, 220, 220));
		AdministracaoButton.setBounds(661, 10, 115, 31);
		contentPane.add(AdministracaoButton);
		
		JPanel CameraPanel = new JPanel();
		CameraPanel.setBackground(new Color(0, 0, 0));
		CameraPanel.setBounds(10, 51, 766, 124);
		contentPane.add(CameraPanel);
		CameraPanel.setLayout(null);
		
		JLabel CameraAtualLabel = new JLabel("Câmera 01 - Entrada principal");
		CameraAtualLabel.setFont(new Font("Monospaced", Font.PLAIN, 10));
		CameraAtualLabel.setBounds(10, 0, 186, 24);
		CameraAtualLabel.setForeground(new Color(220, 220, 220));
		CameraPanel.add(CameraAtualLabel);
		
		JScrollPane TabelaPortariaScrollPane = new JScrollPane();
		TabelaPortariaScrollPane.setBounds(10, 264, 766, 139);
		contentPane.add(TabelaPortariaScrollPane);
		
		TabelaRegistrosPortariaTable = new JTable();
		TabelaRegistrosPortariaTable.setFont(new Font("Arial", Font.PLAIN, 12));
		TabelaRegistrosPortariaTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome/Empresa", "Ve\u00EDculo/Placa", "Tipo", "Documento", "Hora entrada", "Hora sa\u00EDda", "A\u00E7\u00E3o"
			}
		));
		TabelaPortariaScrollPane.setViewportView(TabelaRegistrosPortariaTable);
		TabelaRegistrosPortariaTable.getColumnModel().getColumn(6).setCellRenderer(new BotaoAcaoEditor());
		TabelaRegistrosPortariaTable.getColumnModel().getColumn(6).setCellEditor(new BotaoAcaoEditor());
		
		JPanel RegistroEntradaSaidaPanel = new JPanel();
		RegistroEntradaSaidaPanel.setBackground(new Color(255, 241, 230));
		RegistroEntradaSaidaPanel.setBounds(10, 179, 766, 81);
		contentPane.add(RegistroEntradaSaidaPanel);
		RegistroEntradaSaidaPanel.setLayout(null);
		
		JLabel RegistrarEntradaLabel = new JLabel("Novo registro de entrada");
		RegistrarEntradaLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		RegistrarEntradaLabel.setBounds(0, 0, 134, 18);
		RegistroEntradaSaidaPanel.add(RegistrarEntradaLabel);
		
		JLabel NomeEntradaLabel = new JLabel("Nome");
		NomeEntradaLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		NomeEntradaLabel.setBounds(0, 25, 31, 12);
		RegistroEntradaSaidaPanel.add(NomeEntradaLabel);
		
		RegistrarNomeText = new JTextField();
		RegistrarNomeText.setFont(new Font("Arial", Font.PLAIN, 12));
		RegistrarNomeText.setBounds(38, 22, 134, 18);
		RegistroEntradaSaidaPanel.add(RegistrarNomeText);
		RegistrarNomeText.setColumns(10);
		
		JLabel RegistroPlacaLabel = new JLabel("Placa");
		RegistroPlacaLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		RegistroPlacaLabel.setBounds(0, 59, 31, 12);
		RegistroEntradaSaidaPanel.add(RegistroPlacaLabel);
		
		RegistrarPlacaText = new JTextField();
		RegistrarPlacaText.setFont(new Font("Arial", Font.PLAIN, 12));
		RegistrarPlacaText.setColumns(10);
		RegistrarPlacaText.setBounds(38, 56, 134, 18);
		RegistroEntradaSaidaPanel.add(RegistrarPlacaText);
		
		JLabel RegistroDocumentoLabel = new JLabel("Documento:");
		RegistroDocumentoLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		RegistroDocumentoLabel.setBounds(233, 59, 64, 12);
		RegistroEntradaSaidaPanel.add(RegistroDocumentoLabel);
		
		RegistrarDocumentoText = new JTextField();
		RegistrarDocumentoText.setFont(new Font("Arial", Font.PLAIN, 12));
		RegistrarDocumentoText.setColumns(10);
		RegistrarDocumentoText.setBounds(307, 56, 134, 18);
		RegistroEntradaSaidaPanel.add(RegistrarDocumentoText);
		
		JLabel RegistroTipoLabel = new JLabel("Tipo:");
		RegistroTipoLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		RegistroTipoLabel.setBounds(485, 25, 26, 12);
		RegistroEntradaSaidaPanel.add(RegistroTipoLabel);
		
		TiposComboBox = new JComboBox<>();
		TiposComboBox.setModel(new DefaultComboBoxModel<>(new String[] {"Visitantes", "Entregador", "Veículo Terceiro"}));
		TiposComboBox.setFont(new Font("Arial", Font.PLAIN, 12));
		TiposComboBox.setBounds(521, 22, 142, 18);
		RegistroEntradaSaidaPanel.add(TiposComboBox);
		
		JButton RegistrarButton = new JButton("Registrar entrada");
		RegistrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Nome = RegistrarNomeText.getText().trim();
				if (Nome.isEmpty()) {
					JOptionPane.showMessageDialog(JanelaPortaria.this, "O item 'Nome' está em branco");
					return;
				}
				String Placa = RegistrarPlacaText.getText().trim();
				if (Placa.isEmpty()) {
					JOptionPane.showMessageDialog(JanelaPortaria.this, "O item 'Placa' está em branco");
					return;
				}
				String Veiculo = RegistrarVeiculoText.getText().trim();
				if (Veiculo.isEmpty()) {
					JOptionPane.showMessageDialog(JanelaPortaria.this, "O item 'Veículo' está em branco");
					return;
				}
				String Documento = RegistrarDocumentoText.getText().trim();
				if (Documento.isEmpty()) {
					JOptionPane.showMessageDialog(JanelaPortaria.this, "O item 'Documento' está em branco");
					return;
				}
				String VeiculoPlaca = Veiculo + ": " + Placa;
				String Tipo = (String)TiposComboBox.getSelectedItem();
				String HoraEntrada = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
				DefaultTableModel Modelo = (DefaultTableModel)TabelaRegistrosPortariaTable.getModel();
				Modelo.addRow(new Object[] {
						Nome, VeiculoPlaca, Tipo, Documento, HoraEntrada, "", "Pendente"
				});
				RegistrarNomeText.setText("");
				RegistrarPlacaText.setText("");
				RegistrarVeiculoText.setText("");
				RegistrarDocumentoText.setText("");
				JOptionPane.showMessageDialog(JanelaPortaria.this, "Registro confirmado");
			}
		});
		RegistrarButton.setBackground(new Color(220, 220, 220));
		RegistrarButton.setFont(new Font("Arial", Font.PLAIN, 12));
		RegistrarButton.setBounds(521, 56, 142, 18);
		RegistroEntradaSaidaPanel.add(RegistrarButton);
		
		JLabel VeiculosLabel = new JLabel("Veículo:");
		VeiculosLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		VeiculosLabel.setBounds(253, 25, 44, 12);
		RegistroEntradaSaidaPanel.add(VeiculosLabel);
		
		RegistrarVeiculoText = new JTextField();
		RegistrarVeiculoText.setFont(new Font("Arial", Font.PLAIN, 12));
		RegistrarVeiculoText.setColumns(10);
		RegistrarVeiculoText.setBounds(307, 22, 134, 18);
		RegistroEntradaSaidaPanel.add(RegistrarVeiculoText);

	}
}
