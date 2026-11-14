package view;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class BotaoAcaoEditor extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {
	
	private static final long serialVersionUID = 1L;
	private JButton RegistrarSaidaButton;
	private JLabel RegistroSaidaLabel;
	private int LinhaSelecionada;
	private JTable TabelaRegistrosTable;
	private String EstadoAcao;
	
	public BotaoAcaoEditor() {
		RegistrarSaidaButton = new JButton("Registrar saída");
		RegistroSaidaLabel = new JLabel("Saída registrada");
		RegistrarSaidaButton.addActionListener(e -> {
			int Confirmacao = JOptionPane.showConfirmDialog(null, "Confirmar registro de saída", "Confirmar saída", JOptionPane.YES_NO_CANCEL_OPTION);
			if (Confirmacao == JOptionPane.YES_OPTION) {
				DefaultTableModel Modelo = (DefaultTableModel)TabelaRegistrosTable.getModel();
				String HoraSaida = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
				Modelo.setValueAt(HoraSaida, LinhaSelecionada, 5);
				Modelo.setValueAt("Saída registrada", LinhaSelecionada, 6);
				EstadoAcao = "Saída registrada";
			} 
			fireEditingStopped();
		});
	}

	@Override
	public Object getCellEditorValue() {
		return EstadoAcao;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		TabelaRegistrosTable = table;
		LinhaSelecionada = row;
		String EditorComponentAcao = value.toString();
		EstadoAcao = EditorComponentAcao;
		if (EditorComponentAcao.equals("Pendente")) {
			return RegistrarSaidaButton;
		} else {
			return RegistroSaidaLabel;
		}
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		String RendererComponentAcao = (value == null) ? "Pendente" : value.toString();
		if (RendererComponentAcao.equals("Pendente")) {
			return RegistrarSaidaButton;
		} else {
			return RegistroSaidaLabel;
		}
	}
	
}
