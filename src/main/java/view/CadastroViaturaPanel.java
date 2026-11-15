package view;

import javax.swing.*;
import java.awt.*;

public class CadastroViaturaPanel extends JPanel {
    public CadastroViaturaPanel(){
        setBackground(new Color(227, 227, 227));
        setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel lblTitulo = new JLabel("Cadastro de Viaturas");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(lblTitulo);
        JLabel lblModelo = new JLabel("Modelo do Veículo:");
        lblModelo.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(lblModelo);
        JTextField txtModelo = new JTextField();
        txtModelo.setFont(new Font("Arial", Font.PLAIN, 14));
        add(txtModelo);
        JLabel lblPlaca = new JLabel("Placa:");
        lblPlaca.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(lblPlaca);
        JTextField txtPlaca = new JTextField();
        txtPlaca.setMaximumSize(new Dimension(400, 35));
        add(txtPlaca);
        JLabel lblStatus = new JLabel("Status Inicial:");
        lblStatus.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(lblStatus);
        JComboBox<String> cbStatus = new JComboBox<>(new String[]{"Na base", "Em rota", "Manutenção"});
        cbStatus.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(cbStatus);
        JButton btnSalvar = new JButton("Salvar Viatura");
        btnSalvar.setBackground(new Color(15, 43, 105));
        btnSalvar.setForeground(Color.WHITE);
        JButton btnCancelar = new JButton("Cancelar");
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        painelBotoes.setBackground(new Color(227, 227, 227));
        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnCancelar);
        painelBotoes.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(painelBotoes);
        btnCancelar.addActionListener(e -> {
            txtModelo.setText("");
            txtPlaca.setText("");
            cbStatus.setSelectedIndex(0);
        });
        btnSalvar.addActionListener(e -> {
            String modelo = txtModelo.getText().trim();
            String placa = txtPlaca.getText().trim();
            String status = cbStatus.getSelectedItem().toString();
            if(modelo.isEmpty() || placa.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha o modelo e a placa da viatura!");
                return;
            }
            JOptionPane.showMessageDialog(this,"Viatura cadastrada!\nModelo: " + modelo + "\nPlaca: " + placa + "\nStatus: " + status);
            txtModelo.setText("");
            txtPlaca.setText("");
            cbStatus.setSelectedIndex(0);


        });




    }
}
