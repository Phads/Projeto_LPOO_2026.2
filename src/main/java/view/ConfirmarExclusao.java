package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class ConfirmarExclusao extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private boolean confirmado = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConfirmarExclusao dialog = new ConfirmarExclusao();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConfirmarExclusao() {
		setBounds(100, 100, 450, 230); //
		setTitle("Atenção");
		setModal(true);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(new Color(236, 233, 216));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblIcone = new JLabel("");
		lblIcone.setBounds(205, 10, 40, 40); //
		lblIcone.setHorizontalAlignment(SwingConstants.CENTER); //
		contentPanel.add(lblIcone);

		JLabel lblPergunta = new JLabel("Tem certeza que deseja excluir o registro selecionado?");
		lblPergunta.setBounds(25, 60, 400, 20); //
		lblPergunta.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblPergunta);

		JLabel lblAviso = new JLabel("(Esta ação não poderá ser desfeita)");
		lblAviso.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblAviso.setBounds(25, 85, 400, 20); //
		lblAviso.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblAviso);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(236, 233, 216));
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSim = new JButton("Sim");
				btnSim.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						confirmado = true;
						dispose();
					}
				});
				btnSim.setActionCommand("OK");
				btnSim.setPreferredSize(new Dimension(80, 28));
				buttonPane.add(btnSim);
				getRootPane().setDefaultButton(btnSim);
			}
			{
				JButton btnNao = new JButton("Não");
				btnNao.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnNao.setActionCommand("Cancel");
				btnNao.setPreferredSize(new Dimension(80, 28));
				buttonPane.add(btnNao);
			}
		}
		lblAviso.setForeground(new Color(100, 100, 100));
		lblAviso.setFont(lblAviso.getFont().deriveFont(10f));
		lblIcone.setIcon(UIManager.getIcon("OptionPane.warningIcon"));
	}

	public boolean isConfirmado() {
		return confirmado;
	}

}
