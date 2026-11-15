package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FormEditarUsuarioDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FormEditarUsuarioDialog dialog = new FormEditarUsuarioDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FormEditarUsuarioDialog() {
		setTitle("Editar usuário");
		setBounds(100, 100, 450, 372);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabelNomeCompleto = new JLabel("Nome completo:");
			lblNewLabelNomeCompleto.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabelNomeCompleto.setBounds(10, 15, 105, 12);
			contentPanel.add(lblNewLabelNomeCompleto);
		}
		{
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(105, 66, 255, 25);
			contentPanel.add(textField);
		}
		{
			JLabel lblNewLabelLogin = new JLabel("Login:");
			lblNewLabelLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabelLogin.setBounds(10, 71, 44, 12);
			contentPanel.add(lblNewLabelLogin);
		}
		{
			JLabel lblNewLabelSenha = new JLabel("Senha:");
			lblNewLabelSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabelSenha.setBounds(10, 122, 44, 12);
			contentPanel.add(lblNewLabelSenha);
		}
		{
			JLabel lblNewLabelPerfil = new JLabel("Perfil:");
			lblNewLabelPerfil.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabelPerfil.setBounds(10, 177, 44, 12);
			contentPanel.add(lblNewLabelPerfil);
		}
		{
			JLabel lblNewLabelStatus = new JLabel("Status:");
			lblNewLabelStatus.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabelStatus.setBounds(10, 235, 44, 12);
			contentPanel.add(lblNewLabelStatus);
		}
		{
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(105, 10, 255, 25);
			contentPanel.add(textField_1);
		}
		{
			passwordField = new JPasswordField();
			passwordField.setBounds(105, 117, 255, 25);
			contentPanel.add(passwordField);
		}
		{
			JComboBox comboBoxPerfil = new JComboBox();
			comboBoxPerfil.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Servidor geral", "Motorista ", "Recepcionista"}));
			comboBoxPerfil.setBounds(105, 172, 255, 25);
			contentPanel.add(comboBoxPerfil);
		}
		{
			JComboBox comboBoxStatus = new JComboBox();
			comboBoxStatus.setModel(new DefaultComboBoxModel(new String[] {"Ativo", "Inativo"}));
			comboBoxStatus.setBounds(105, 230, 255, 25);
			contentPanel.add(comboBoxStatus);
		}
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
