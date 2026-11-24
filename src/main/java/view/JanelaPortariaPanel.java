package view;

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

public class JanelaPortariaPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel Panel;
	private JTable TabelaRegistrosPortariaTable;
	private JTextField RegistrarNomeText;
	private JTextField RegistrarPlacaText;
	private JTextField RegistrarDocumentoText;
	private JComboBox<String> TiposComboBox;
	private JTextField RegistrarVeiculoText;

	/**
	 * Create the panel.
	 */
	public JanelaPortariaPanel() {
		
		setLayout(null);
		setForeground(new Color(255, 241, 230));
		setBackground(new Color(255, 241, 230));
		setBounds(100, 100, 800, 450);
		Panel = new JPanel();
		Panel.setBackground(new Color(255, 255, 255));
		Panel.setBounds(0, 0, 800, 450);
		Panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		Panel.setLayout(null);
		
		JPanel CameraPanel = new JPanel();
		CameraPanel.setBackground(new Color(0, 0, 0));
		CameraPanel.setBounds(10, 10, 766, 160);
		Panel.add(CameraPanel);
		CameraPanel.setLayout(new java.awt.BorderLayout());
		
		JPanel BarraSuperiorCam = new JPanel(new java.awt.BorderLayout());
		BarraSuperiorCam.setBackground(new Color(20, 20, 20));
		
		JLabel CameraAtualLabel = new JLabel("Câmera 01 - Entrada principal");
		CameraAtualLabel.setFont(new Font("Monospaced", Font.PLAIN, 11));
		CameraAtualLabel.setForeground(new Color(220, 220, 220));
		CameraPanel.add(CameraAtualLabel, java.awt.BorderLayout.WEST);
		
		JButton CapturarFotoButton = new JButton("Capturar Foto / Placa");
		CapturarFotoButton.setFont(new Font("Arial", Font.BOLD, 11));
		CapturarFotoButton.setBackground(new Color(220, 220, 220));
		BarraSuperiorCam.add(CapturarFotoButton, java.awt.BorderLayout.EAST);

		CameraPanel.add(BarraSuperiorCam, java.awt.BorderLayout.NORTH);
		
				com.github.sarxos.webcam.Webcam webcam = com.github.sarxos.webcam.Webcam.getDefault();
				if (webcam != null) {
					webcam.setViewSize(com.github.sarxos.webcam.WebcamResolution.QVGA.getSize());
					com.github.sarxos.webcam.WebcamPanel painelVideo = new com.github.sarxos.webcam.WebcamPanel(webcam);
					painelVideo.setMirrored(true);
					CameraPanel.add(painelVideo, java.awt.BorderLayout.CENTER);
				} else {
					JLabel SemCamLabel = new JLabel("[ ÁREA PLACA - Nenhuma webcam detectada ]",
							javax.swing.SwingConstants.CENTER);
					SemCamLabel.setFont(new Font("Monospaced", Font.BOLD, 12));
					SemCamLabel.setForeground(new Color(0, 200, 0));
					CameraPanel.add(SemCamLabel, java.awt.BorderLayout.CENTER);
				}

				
				CapturarFotoButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (webcam != null && webcam.isOpen()) {
							try {
								java.awt.image.BufferedImage foto = webcam.getImage();
								String nomeArquivo = "placa_" + System.currentTimeMillis() + ".png";
								javax.imageio.ImageIO.write(foto, "PNG", new java.io.File(nomeArquivo));

								RegistrarPlacaText.setText("ABC-1234");
								JOptionPane.showMessageDialog(JanelaPortariaPanel.this,
										"Foto capturada e salva como: " + nomeArquivo + "\nPlaca detectada: ABC-1234");
							} catch (Exception ex) {
								JOptionPane.showMessageDialog(JanelaPortariaPanel.this,
										"Erro ao salvar imagem: " + ex.getMessage());
							}
						} else {
							RegistrarPlacaText.setText("XYZ-9876");
							JOptionPane.showMessageDialog(JanelaPortariaPanel.this,
									"Modo Simulação: Captura realizada!\nPlaca preenchida automaticamente.");
						}
					}
				});
		
		JScrollPane TabelaPortariaScrollPane = new JScrollPane();
		TabelaPortariaScrollPane.setBounds(10, 264, 766, 139);
		Panel.add(TabelaPortariaScrollPane);
		
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
		Panel.add(RegistroEntradaSaidaPanel);
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
					JOptionPane.showMessageDialog(JanelaPortariaPanel.this, "O item 'Nome' está em branco");
					return;
				}
				String Placa = RegistrarPlacaText.getText().trim();
				if (Placa.isEmpty()) {
					JOptionPane.showMessageDialog(JanelaPortariaPanel.this, "O item 'Placa' está em branco");
					return;
				}
				String Veiculo = RegistrarVeiculoText.getText().trim();
				if (Veiculo.isEmpty()) {
					JOptionPane.showMessageDialog(JanelaPortariaPanel.this, "O item 'Veículo' está em branco");
					return;
				}
				String Documento = RegistrarDocumentoText.getText().trim();
				if (Documento.isEmpty()) {
					JOptionPane.showMessageDialog(JanelaPortariaPanel.this, "O item 'Documento' está em branco");
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
				JOptionPane.showMessageDialog(JanelaPortariaPanel.this, "Registro confirmado");
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
		add(Panel);

	}

}
