package dk.easv.belman.GUI.Models;

//<editor-fold defaultstate="collapsed" desc=" Imports ">
import dk.easv.belman.BE.ProductionOrder;
import dk.easv.belman.BE.Lists.ProductionOrderList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.AbstractTableModel;
//</editor-fold>

public class POTableModel extends AbstractTableModel {

    //<editor-fold defaultstate="collapsed" desc=" Global variables ">
    private ProductionOrderList poList; // A list of cuts
    // The names of columns
    private String[] colNames = {"PO Description", "Date"};
    // The type of columns
    private Class[] classes = {String.class, Long.class};
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Constructor ">
    /**
     * Constructor for the SleeveTableModel.
     *
     * @param sList Constructs a table model based on a SalesOrdeList.
     */
    public POTableModel(ProductionOrderList poList) {
        this.poList = poList;
        fireTableDataChanged();
    }
        //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Get the number of rows ">
    @Override
    public int getRowCount() {
        return poList.size();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Get the number of columns ">
    @Override
    public int getColumnCount() {
        return colNames.length;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Get a value from a specific cell ">
    @Override
    public Object getValueAt(int row, int col) {

        ProductionOrder po = poList.get(row);

        switch (col) {
            case 0:
                return po.getDescription();
            case 1:
                DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
                return df.format(new Date(po.getParent().getDueDate()));
        }
        return null;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Get a ProductionOrder by row ">
    /**
     * Gets a PO by row.
     *
     * @param row the number of row from where we want to get the PO.
     * @return a PO from a selected row.
     */
    public ProductionOrder getPOByRow(int row) {
        return poList.get(row);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Get a specific column name ">
    @Override
    public String getColumnName(int col) {
        return colNames[col];
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Get a specific column class ">
    @Override
    public Class<?> getColumnClass(int col) {
        return classes[col];
    }
        //</editor-fold>

}
