package dk.easv.belman.GUI.Models;

//<editor-fold defaultstate="collapsed" desc=" Imports ">
import dk.easv.belman.BE.Cut;
import dk.easv.belman.BE.Lists.CutList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.AbstractTableModel;
//</editor-fold>

public class CutTableModel extends AbstractTableModel {

    private CutList cutList; // A list of cuts
    // The names of columns
    private String[] colNames = {"PO Description", "Date", "Operator", "Time", "Quantity"};
    // The type of columns
    private Class[] classes = {String.class, Long.class, String.class, Long.class, Integer.class};

    /**
     * Constructor for the SleeveTableModel.
     *
     * @param sList Constructs a table model based on a SalesOrdeList.
     */
    public CutTableModel(CutList cutList) {
        this.cutList = cutList;

        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return cutList.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Object getValueAt(int row, int col) {

        Cut cut = cutList.get(row);

        switch (col) {
            case 0:
                return cut.getSleeve().getParent().getDescription();
            case 1:
                DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                return df.format(new Date(cut.getDate()));
            case 2:
                return cut.getOperator().toString();
            case 3:
                return cut.getTimeSpent();
            case 4:
                return cut.getQuantity();
        }
        return null;
    }

    /**
     * Sets the Cut list to new cutList
     *
     * @param cutList the list of cuts to set
     */
    public void setCutList(CutList cutList) {
        this.cutList = cutList;
        this.fireTableDataChanged();
    }

    /**
     * Gets a Cut by row.
     *
     * @param row the number of row from where we want to get the Cut.
     * @return a Cut from a selected row.
     */
    public Cut getCutByRow(int row) {
        return cutList.get(row);
    }

    @Override
    public String getColumnName(int col) {
        return colNames[col];
    }

    @Override
    public Class<?> getColumnClass(int col) {
        return classes[col];
    }
}
