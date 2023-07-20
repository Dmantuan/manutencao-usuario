package ufes.service;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class BackgroundColorTableCellRenderer extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Obtém o valor da coluna "Lida" (coluna de índice 3)
        Boolean visualizada = (Boolean) table.getValueAt(row, 3);

        // Define a cor de fundo com base no valor da propriedade "visualizada"
        if (visualizada != null && visualizada) {
            cellComponent.setBackground(Color.GREEN); // Cor de fundo para visualizadas (valor true)
        } else {cellComponent.setBackground(Color.MAGENTA); // Cor de fundo padrão
        }

        return cellComponent;
    }
}
