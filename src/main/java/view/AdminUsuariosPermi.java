package view;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JScrollPane;

import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class AdminUsuariosPermi extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tableUsuarios;

	private Color corDeFundo = new Color(236, 233, 216);

	public AdminUsuariosPermi() {
		setPreferredSize(new Dimension(1280, 720));
		setBackground(corDeFundo); //
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(null);
		//for (Component item : menuBar.getComponents()) {
		//	((JComponent) item).setOpaque(false);
		//}


		JPanel panel = new JPanel();
		panel.setBounds(240, 58, 1030, 652);
		panel.setBackground(corDeFundo);
		add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel(new BorderLayout(0, 0));
		panel_1.setBounds(0, 0, 1030, 31);
		panel.add(panel_1);

		JPanel panelEsquerda = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
		JButton button = new JButton("Novo Usuário");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormCadastrarNovoUsuarioDialog dialogCadastrarUsuario = new FormCadastrarNovoUsuarioDialog();
				dialogCadastrarUsuario.setLocationRelativeTo(null);
				dialogCadastrarUsuario.setVisible(true);
			}
		});
		panelEsquerda.add(button);
		JButton button_1 = new JButton("Editar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormEditarUsuarioDialog dialogEditarUsuario = new FormEditarUsuarioDialog();
				dialogEditarUsuario.setLocationRelativeTo(null);
				dialogEditarUsuario.setVisible(true);
			}
		});
		panelEsquerda.add(button_1);
		JButton btnExcluir = new JButton("Excluir"); 
		panelEsquerda.add(btnExcluir);

		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linha = tableUsuarios.getSelectedRow();

				if (linha == -1) {
					JOptionPane.showMessageDialog(AdminUsuariosPermi.this,
							"Por favor, selecione um registro na tabela para excluir.", "Mensagem do Sistema",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				ConfirmarExclusao dialogo = new ConfirmarExclusao();
				dialogo.setLocationRelativeTo(AdminUsuariosPermi.this);
				dialogo.setVisible(true);

				if (dialogo.isConfirmado()) {
					((DefaultTableModel) tableUsuarios.getModel()).removeRow(linha);

				}
			}
		});
		panel_1.add(panelEsquerda, BorderLayout.WEST);

		JPanel panelDireita = new JPanel();
		panelDireita.setLayout(new CardLayout(0, 0));

		panelDireita.add(new JButton("Gerar PDF"), "name_12094181666200");
		panel_1.add(panelDireita, BorderLayout.EAST);

		String[] colunas = { "Nome do Servidor", "Login", "Perfil de Acesso", "Status" };
		Object[][] dados = { { "Ana (Gestora)", "ana.gestor", "Admin", "Ativo" },
				{ "Marcos Silva", "marcos.mot", "Motorista", "Ativo" },
				{ "Fernanda (Recepção)", "fernanda.rec", "Recepcionista", "Ativo" },
				{ "Carlos (Geral)", "carlos.ger", "Servidor Geral", "Ativo" }

		};

		tableUsuarios = new JTable(new DefaultTableModel(dados, colunas) { 
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int linha, int coluna) {
				return false; 
			}
		});
		JScrollPane scrollPaneTabela = new JScrollPane(tableUsuarios);
		scrollPaneTabela.setBounds(0, 31, 1030, 620);
		scrollPaneTabela.getViewport().setBackground(Color.WHITE);
		panel.add(scrollPaneTabela);

		tableUsuarios.setRowHeight(30);
		tableUsuarios.setShowGrid(false);
		
		AdminRegistrarChavesPanel adminRegistrarChavesPanel = new AdminRegistrarChavesPanel();
		adminRegistrarChavesPanel.setBounds(0, 0, 1030, 652);
		panel.add(adminRegistrarChavesPanel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 58, 220, 652);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Configurações");
		lblNewLabel.setBounds(10, 5, 200, 13);
		panel_2.add(lblNewLabel);
		
		JButton btnNewButton_6 = new JButton("Usuários e permissões");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminRegistrarChavesPanel.setVisible(false);
				panel_1.setVisible(true);
				scrollPaneTabela.setVisible(true);
			}
		});
		btnNewButton_6.setBounds(10, 28, 200, 20);
		panel_2.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Cadastro de Chaves");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				scrollPaneTabela.setVisible(false);
				adminRegistrarChavesPanel.setVisible(true);
			}
		});
		btnNewButton_7.setBounds(10, 58, 200, 20);
		panel_2.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Cadastro de Viaturas");
		btnNewButton_8.setBounds(10, 88, 200, 20);
		panel_2.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Manutenção de Viaturas");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_9.setBounds(10, 118, 200, 20);
		panel_2.add(btnNewButton_9);
		tableUsuarios.getTableHeader().setReorderingAllowed(false);
		tableUsuarios.getTableHeader().setPreferredSize(new Dimension(0, 32));

		DefaultTableCellRenderer cabecalho = new DefaultTableCellRenderer();
		cabecalho.setBackground(new Color(245, 245, 245));
		cabecalho.setHorizontalAlignment(JLabel.LEFT);
		cabecalho.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(0, 0, 1, 1, new Color(200, 200, 200)), new EmptyBorder(0, 10, 0, 10)));
		for (int i = 0; i < tableUsuarios.getColumnCount(); i++) {
			tableUsuarios.getColumnModel().getColumn(i).setHeaderRenderer(cabecalho);
		}
		

	}
	
	private class IconeColchete implements Icon {
		private String texto;
		
		public IconeColchete(String texto) {
			this.texto = texto;
		}
		
		public int getIconWidth() {
			return 22;
		}
		
		public int getIconHeight() {
			return 16;
		}
		
		public void paintIcon(Component c, Graphics g, int x, int y) {
			g.setColor(Color.BLACK);
			g.setFont(c.getFont());
			g.drawString(texto, x, y + g.getFontMetrics().getAscent());
			
		}
	}
}