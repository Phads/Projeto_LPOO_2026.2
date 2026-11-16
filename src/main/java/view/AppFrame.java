package view;

import java.awt.EventQueue;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppFrame frame = new AppFrame();
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
	public AppFrame() {
		setTitle("Sistema de Logística e Controle da Defesa Civil");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Visão Geral");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				navWindow("name_visaoGeralPanel");
			}
		});
		mntmNewMenuItem_5.setSelected(true);
		menuBar.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Portaria/Acesso");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				navWindow("name_JanelaPortariaPanel");
			}
		});
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Chaves de Salas");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				navWindow("name_menuChavesPanel");
			}
		});
		menuBar.add(mntmNewMenuItem_4);
		menuBar.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Viaturas");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				navWindow("name_menuVitaturasPanel");
			}
		});
		menuBar.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Manutenção de Frotas");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				navWindow("name_ManutençãoFrotaPanel");
			}
		});
		menuBar.add(mntmNewMenuItem_1);
		JMenuItem mntmCadastroViatura = new JMenuItem("Cadastrar Viatura");
		mntmCadastroViatura.addActionListener(e -> navWindow("name_cadastroViaturaPanel"));
		menuBar.add(mntmCadastroViatura);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Administração");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				navWindow("telaAdminUsuarios");
			}
		});
		menuBar.add(mntmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		LoginPanel loginPanel = new LoginPanel();
		contentPane.add(loginPanel, "name_loginPanel");
		loginPanel.setLayout(null);
		
		AdminRegistrarChavesPanel adminRegistrarChavesPanel = new AdminRegistrarChavesPanel();
		contentPane.add(adminRegistrarChavesPanel, "name_adminRegistrarChaves");
		
		MenuChavesPanel menuChavesPanel = new MenuChavesPanel();
		contentPane.add(menuChavesPanel, "name_menuChavesPanel");
		
		MenuViaturasPanel menuViaturasPanel = new MenuViaturasPanel();
		contentPane.add(menuViaturasPanel, "name_menuVitaturasPanel");
		
		AdminUsuariosPermi adminUsuariosPermi = new AdminUsuariosPermi();
		contentPane.add(adminUsuariosPermi, "telaAdminUsuarios");
		CadastroViaturaPanel cadastroViaturaPanel = new CadastroViaturaPanel();
		contentPane.add(cadastroViaturaPanel, "name_cadastroViaturaPanel");

		VisaoGeralPanel visaoGeralPanel = new VisaoGeralPanel();
		contentPane.add(visaoGeralPanel, "name_visaoGeralPanel");

		JanelaPortariaPanel janelaPortariaPanel = new JanelaPortariaPanel();
		contentPane.add(janelaPortariaPanel, "name_JanelaPortariaPanel");
		
		ManutencaoViaturasPanel manutencaoViaturasPanel = new ManutencaoViaturasPanel();
		contentPane.add(manutencaoViaturasPanel, "name_ManutençãoFrotaPanel");
	}
	
	public void navWindow(String viewName) {
	    CardLayout nav = (CardLayout) contentPane.getLayout();
	    nav.show(contentPane, viewName);
	}
}

