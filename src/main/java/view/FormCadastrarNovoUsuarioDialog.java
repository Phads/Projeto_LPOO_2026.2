package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class FormCadastrarNovoUsuarioDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNomeCompleto;
	private JTextField textFieldLogin;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FormCadastrarNovoUsuarioDialog dialog = new FormCadastrarNovoUsuarioDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FormCadastrarNovoUsuarioDialog() {
		setTitle("Cadastrar novo usuário");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabelNomeCompleto = new JLabel("Nome completo:");
		lblNewLabelNomeCompleto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabelNomeCompleto.setBounds(25, 10, 106, 12);
		contentPanel.add(lblNewLabelNomeCompleto);
		
		textFieldNomeCompleto = new JTextField();
		textFieldNomeCompleto.setBounds(128, 8, 186, 26);
		contentPanel.add(textFieldNomeCompleto);
		textFieldNomeCompleto.setColumns(10);
		
		JLabel lblNewLabelLogin = new JLabel("Login:");
		lblNewLabelLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabelLogin.setBounds(25, 46, 44, 12);
		contentPanel.add(lblNewLabelLogin);
		
		JLabel lblNewLabelSenha = new JLabel("Senha:");
		lblNewLabelSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabelSenha.setBounds(25, 83, 44, 12);
		contentPanel.add(lblNewLabelSenha);
		
		JLabel lblNewLabelPerfil = new JLabel("Perfil:");
		lblNewLabelPerfil.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabelPerfil.setBounds(25, 118, 44, 12);
		contentPanel.add(lblNewLabelPerfil);
		
		JLabel lblNewLabelStatus = new JLabel("Status:");
		lblNewLabelStatus.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabelStatus.setBounds(25, 154, 44, 12);
		contentPanel.add(lblNewLabelStatus);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(128, 43, 186, 26);
		contentPanel.add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(128, 80, 186, 26);
		contentPanel.add(passwordField);
		
		JComboBox comboBoxPerfil = new JComboBox();
		comboBoxPerfil.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Servidor geral", "Motorista", "Recepcionista"}));
		comboBoxPerfil.setBounds(128, 114, 186, 26);
		contentPanel.add(comboBoxPerfil);
		
		JComboBox comboBoxStatus = new JComboBox();
		comboBoxStatus.setModel(new DefaultComboBoxModel(new String[] {"Ativo", "Inativo"}));
		comboBoxStatus.setBounds(128, 150, 186, 26);
		contentPanel.add(comboBoxStatus);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Salvar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
