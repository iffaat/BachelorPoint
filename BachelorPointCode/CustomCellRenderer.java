import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // Call the parent class to perform the default rendering
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        // Customize the cell rendering
        if (isSelected) {
            // Cell is selected, set the background and text color accordingly
            cellComponent.setBackground(Color.BLUE); // Change the background color for selected cells
            cellComponent.setForeground(Color.WHITE); // Change the text color for selected cells
        } else {
            // Cell is not selected, set the default background and text color
            cellComponent.setBackground(Color.DARK_GRAY); // Change the background color for unselected cells
            cellComponent.setForeground(Color.WHITE); // Change the text color for unselected cells
        }

        return cellComponent;
    }
}