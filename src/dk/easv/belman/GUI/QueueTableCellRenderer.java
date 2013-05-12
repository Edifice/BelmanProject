//package dk.easv.belman.GUI;
//
//import java.awt.Color;
//import java.awt.Component;
//import javax.swing.JTable;
//import javax.swing.table.DefaultTableCellRenderer;
//import javax.swing.table.TableCellRenderer;
//
//public class QueueTableCellRenderer extends DefaultTableCellRenderer implements TableCellRenderer {
//
//    private int materialColumn = 2;
//
//    @Override
//    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//        setBackground(null);
//        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//        setText(String.valueOf(value));
//
//        QueueTableModel model = (QueueTableModel) table.getModel();
//
//        int first = (int) model.getValueAt(0, materialColumn);
//
//        if (column == materialColumn) {
//            int next1 = first;
//            int i = 0;
//            while (next1 == first && model.getRowCount() > i) {
//                next1 = (int) model.getValueAt(i++, materialColumn);
//            }
//
//            int next2 = next1;
//            while ((next2 == next1 || next2 == first) && model.getRowCount() > i) {
//                next2 = (int) model.getValueAt(i++, 2);
//            }
//
//            if (value == first) {
//                setBackground(Color.GREEN);
//            } else {
//                if (value == next1) {
//                    setBackground(Color.YELLOW);
//                } else {
//                    if (value == next2) {
//                        setBackground(Color.ORANGE);
//                    } else {
//                        setBackground(Color.RED);
//                    }
//                }
//            }
//        } else if (row % 2 == 0) {
//            // every second row should be gray, for better readability
//            setBackground(new Color(240, 240, 240));
//        }
//        return this;
//    }
//}
