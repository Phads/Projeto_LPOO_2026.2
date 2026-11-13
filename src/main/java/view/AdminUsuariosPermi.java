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
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicTreeUI;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JTable;

public class AdminUsuariosPermi extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */

	private JScrollPane scrollPane;
	private JTree tree;
	private JTable tableUsuarios;

	private Color corDeFundo = new Color(236, 233, 216);

	public AdminUsuariosPermi() {
		setPreferredSize(new Dimension(1280, 720));
		setBackground(corDeFundo); //
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new BorderLayout(10, 10));

		JPanel menuBar = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 8));
		menuBar.setBackground(corDeFundo);
		menuBar.setPreferredSize(new Dimension(0, 38));

		add(menuBar, BorderLayout.NORTH);

		JButton btnNewButton = new JButton("Visão Geral");
		menuBar.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Chaves de Salas");
		menuBar.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Viaturas");
		menuBar.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Manutenção de Frota");
		menuBar.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Portaria/Acesso");
		menuBar.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Administração");
		menuBar.add(btnNewButton_5);

		menuBar.setOpaque(false);
		for (Component item : menuBar.getComponents()) {
			((JComponent) item).setOpaque(false);
		}

		btnNewButton_5.setFont(btnNewButton_5.getFont().deriveFont(Font.BOLD));

		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(220, 0));
		scrollPane.setBorder(BorderFactory.createLineBorder(new Color(140, 140, 140)));

		add(scrollPane, BorderLayout.WEST);


		DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Raiz");

		DefaultMutableTreeNode config = new DefaultMutableTreeNode("Configurações");

		config.add(new DefaultMutableTreeNode("Usuários e Permissões"));
		config.add(new DefaultMutableTreeNode("Cadastro de Chaves/Salas"));
		config.add(new DefaultMutableTreeNode("Cadastro de Viaturas"));
		config.add(new DefaultMutableTreeNode("Manutenção de Viaturas"));

		DefaultMutableTreeNode auditoria = new DefaultMutableTreeNode("Auditoria de Logs");

		raiz.add(config);
		auditoria.add(new DefaultMutableTreeNode("Registros"));
		raiz.add(auditoria);

		tree = new JTree(new DefaultTreeModel(raiz));
		tree.setRootVisible(false);
		tree.expandRow(0);
		tree.setBorder(new EmptyBorder(5, 5, 5, 5));
		scrollPane.setViewportView(tree); 
		
		DefaultTreeCellRenderer visual = (DefaultTreeCellRenderer) tree.getCellRenderer();
		visual.setLeafIcon(null);
		visual.setOpenIcon(null);
		visual.setClosedIcon(null);
		
		visual.setBackgroundSelectionColor(new Color(10, 36, 106));
		visual.setTextSelectionColor(Color.WHITE);
		visual.setBorderSelectionColor(null);
		
		tree.putClientProperty("JTree.lineStyle", "None");
		tree.setRowHeight(20);
		
		tree.setSelectionRow(1);

		JPanel panel = new JPanel();
		panel.setBackground(corDeFundo);
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel(new BorderLayout(0, 0));
		panel.add(panel_1, BorderLayout.NORTH);

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
				FormExcluirUsuarioDialog dialogExcluirUsuario = new FormExcluirUsuarioDialog();
				dialogExcluirUsuario.setLocationRelativeTo(null);
				dialogExcluirUsuario.setVisible(true);
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

		JPanel panelDireita = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		panelDireita.add(new JButton("Gerar PDF"));
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
		scrollPaneTabela.getViewport().setBackground(Color.WHITE);
		panel.add(scrollPaneTabela, BorderLayout.CENTER);

		tableUsuarios.setRowHeight(30);
		tableUsuarios.setShowGrid(false);
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
		
		tree.setShowsRootHandles(true);
		
		BasicTreeUI visualArvore = (BasicTreeUI) tree.getUI();
		visualArvore.setExpandedIcon(new IconeColchete("[-]"));
		visualArvore.setCollapsedIcon(new IconeColchete("[+]"));

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
