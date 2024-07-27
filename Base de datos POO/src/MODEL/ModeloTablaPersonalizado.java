package MODEL;

import javax.swing.table.DefaultTableModel;
import java.util.HashSet;
import java.util.Set;

public class ModeloTablaPersonalizado extends DefaultTableModel {
    private Set<Integer> filasEditables = new HashSet<>();

    public ModeloTablaPersonalizado(Object[][] data, Object[] columnNames, int length) {
        super(data, columnNames);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return column != 3 && column != 4 && (filasEditables.contains(row) || column == 5);
    }

    public void agregarFilaEditable() {
        int fila = getRowCount();
        addRow(new Object[]{"", 0.0, 0.0, 0.0, "", ""});
        filasEditables.add(fila);
    }
}
