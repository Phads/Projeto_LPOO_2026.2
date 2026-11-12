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

public class MenuViaturasPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    public MenuViaturasPanel() {

    	setBackground(new Color(227, 227, 227));
        

        JButton btnReportar = new JButton("Cadastrar Manutenção");
        btnReportar.setFont(new Font("Arial", Font.PLAIN, 14));

        JButton btnPDF = new JButton("Relatório de Frota (PDF)");
        btnPDF.setFont(new Font("Arial", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane();

        JTable table = new JTable();
        table.setForeground(new Color(0, 0, 0));
        table.setBackground(SystemColor.control);

        table.setModel(new DefaultTableModel(
            new Object[][] {
                {"Toyota Hillux","Na base", "ABC-1234", "-", "-", "-","Saida"},
                {"Fiat Toro", "Em rota", "ABC-5678", "Motorista Logado", "Externo", "20:13","Retorno"},
                {"Van Renault","Manutenção", "DCV-3333", "-", "Oficina Central", "Ontem","Bloqueado"},
               
            },
            new String[] {
                "Veiculo",
                "Placa",
                "Status",
                "Motorista",
                "Destino",
                "Saída",
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
        				.addGroup(gl_panel.createSequentialGroup()
        					.addComponent(btnReportar, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
        					.addGap(8)
        					.addComponent(btnPDF, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE))
        				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE))
        			.addGap(12))
        );
        gl_panel.setVerticalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addGap(51)
        			.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnReportar, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnPDF, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
        			.addGap(12)
        			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
        			.addGap(12))
        );

        setLayout(gl_panel);
    }
    }

