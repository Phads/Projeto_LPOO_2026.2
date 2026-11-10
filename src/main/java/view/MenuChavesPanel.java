package view;

import java.awt.Color;

import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JCheckBoxMenuItem;

public class MenuChavesPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private JTable table;
    private JTextField txtBuscar;

    public MenuChavesPanel() {

        setBackground(new Color(227, 227, 227));

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(SystemColor.activeCaptionBorder);
        menuBar.setPreferredSize(new java.awt.Dimension(0, 38));
        

        JButton btnReportar = new JButton("Reportar Perda / Recuperar");
        btnReportar.setFont(new Font("Arial", Font.PLAIN, 14));

        JButton btnPDF = new JButton("Gerar PDF");
        btnPDF.setFont(new Font("Arial", Font.PLAIN, 14));

        txtBuscar = new JTextField();
        txtBuscar.setForeground(new Color(128, 128, 128));
        txtBuscar.setFont(new Font("Arial", Font.PLAIN, 14));
        txtBuscar.setText(" Buscar sala...");
        txtBuscar.setBorder(new LineBorder(new Color(190, 185, 165)));

        JScrollPane scrollPane = new JScrollPane();

        table = new JTable();
        table.setForeground(new Color(0, 0, 0));
        table.setBackground(SystemColor.control);

        table.setModel(new DefaultTableModel(
            new Object[][] {
                {"Sala 101 - Administrativo", "Disponível", "-", "-", "Pegar"},
                {"Sala 102 - Reunião", "Disponível", "-", "-", "Pegar"},
                {"Sala 204 - TI", "Emprestada", "Ana (Admin)", "10:30", "Devolver"},
                {"Almoxarifado", "Disponível", "-", "-", "Pegar"}
            },
            new String[] {
                "Sala / Bloco",
                "Status",
                "Responsável Atual",
                "Hora Retirada",
                "Ação"
            }
        ));

        table.setFont(new Font("Arial", Font.PLAIN, 15));
        table.setRowHeight(32);
        table.setGridColor(new Color(215, 215, 215));
        table.setSelectionBackground(new Color(15, 43, 105));
        table.setSelectionForeground(Color.WHITE);
        table.setFillsViewportHeight(true);

        table.getTableHeader().setFont(new Font("Arial", Font.PLAIN, 15));
        table.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 40));
        table.getTableHeader().setReorderingAllowed(false);

        table.getColumnModel().getColumn(0).setPreferredWidth(285);
        table.getColumnModel().getColumn(1).setPreferredWidth(175);
        table.getColumnModel().getColumn(2).setPreferredWidth(210);
        table.getColumnModel().getColumn(3).setPreferredWidth(160);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);

        scrollPane.setViewportView(table);

        GroupLayout gl_panel = new GroupLayout(this);

        gl_panel.setHorizontalGroup(
            gl_panel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel.createSequentialGroup()
                    .addGap(12)
                    .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                        .addComponent(menuBar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(gl_panel.createSequentialGroup()
                            .addComponent(btnReportar, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                            .addGap(8)
                            .addComponent(btnPDF, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
                            .addGap(8)
                            .addComponent(txtBuscar, GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE))
                        .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1150, Short.MAX_VALUE))
                    .addGap(12))
        );

        gl_panel.setVerticalGroup(
            gl_panel.createSequentialGroup()
                .addGap(5)
                .addComponent(menuBar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addGap(8)
                .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                    .addComponent(btnReportar, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPDF, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                .addGap(12)
                .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                .addGap(12)
        );
        
        JMenuItem mntmNewMenuItem_5 = new JMenuItem("Visão Geral");
        mntmNewMenuItem_5.setSelected(true);
        menuBar.add(mntmNewMenuItem_5);
        
        JMenuItem mntmNewMenuItem_4 = new JMenuItem("Chaves de Salas");
        menuBar.add(mntmNewMenuItem_4);
        
        JMenuItem mntmNewMenuItem = new JMenuItem("Viaturas");
        menuBar.add(mntmNewMenuItem);
        
        JMenuItem mntmNewMenuItem_1 = new JMenuItem("Manutenção de Frotas");
        menuBar.add(mntmNewMenuItem_1);
        
        JMenuItem mntmNewMenuItem_2 = new JMenuItem("Portaria/Acesso");
        menuBar.add(mntmNewMenuItem_2);
        
        JMenuItem mntmNewMenuItem_3 = new JMenuItem("Administração");
        menuBar.add(mntmNewMenuItem_3);

        setLayout(gl_panel);
    }
}
