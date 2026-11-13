package view;

import java.awt.EventQueue;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AppFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CardLayout sistemaDeRotas;

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
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		LoginPanel loginPanel = new LoginPanel();
		contentPane.add(loginPanel, "name_9118787885100");
		loginPanel.setLayout(null);
		
		AdminRegistrarChavesPanel adminRegistrarChavesPanel = new AdminRegistrarChavesPanel();
		contentPane.add(adminRegistrarChavesPanel, "telaAdminRegistrarChaves");
		
		MenuChavesPanel menuChavesPanel = new MenuChavesPanel();
		contentPane.add(menuChavesPanel, "name_11595737390637500");
		
		MenuViaturasPanel menuViaturasPanel = new MenuViaturasPanel();
		contentPane.add(menuViaturasPanel, "name_11853826368504700");
		
		AdminUsuariosPermi adminUsuariosPermi = new AdminUsuariosPermi();
		contentPane.add(adminUsuariosPermi, "telaAdminUsuarios");
		
		sistemaDeRotas = new CardLayout();
	}
}

