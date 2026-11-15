package view;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LoginPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField txtOpa;

	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuário");
		lblNewLabel.setBounds(339, 210, 46, 14);
		add(lblNewLabel);
		
		txtOpa = new JTextField();
		txtOpa.setBounds(339, 228, 265, 20);
		add(txtOpa);
		txtOpa.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setBounds(339, 259, 46, 14);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(339, 280, 265, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				java.awt.Container painelPrincipal = getParent();
				
				CardLayout proximaTela = (CardLayout) painelPrincipal.getLayout();
				proximaTela.show(painelPrincipal, "telaAdminRegistrarChaves");
			}
		});
		
		btnNewButton.setBounds(432, 337, 89, 23);
		add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("SEPDEC Gestão Logistica");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(390, 135, 173, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Login");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(453, 160, 46, 14);
		add(lblNewLabel_3);

	}
}
