package dk.easv.belman.GUI.Models;

//<editor-fold defaultstate="collapsed" desc=" Imports ">
import dk.easv.belman.BE.Item;
import dk.easv.belman.BE.ProductionOrder;
import dk.easv.belman.BE.SalesOrder;
import dk.easv.belman.BE.StockItem;
import dk.easv.belman.BE.Lists.StockItemList;
import dk.easv.belman.GUI.Main;
import javax.swing.table.AbstractTableModel;
//</editor-fold>

public class StockTableModel extends AbstractTableModel {

    //<editor-fold defaultstate="collapsed" desc=" Global variables ">
    private StockItemList stockList; // The contents of the table.
    // The names of columns
    private String[] colNames = {"Code", "Batch ID", "Mat ID", "Width", "Length", "Thickness", "Orders"};
    // The type of columns
    private Class[] classes = {String.class, String.class, Integer.class, Double.class, Double.class, Double.class, Integer.class};
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructor ">
    /**
     * Constructor for the StockTableModel.
     *
     * @param stockList Constructs a table model based on a StockList.
     */
    public StockTableModel(StockItemList stockList) {
        this.stockList = stockList;
        fireTableDataChanged();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Get row count ">
    @Override
    public int getRowCount() {
        return stockList.size();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Get column count ">
    @Override
    public int getColumnCount() {
        return colNames.length;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Get a value from a specific cell ">
    @Override
    public Object getValueAt(int row, int col) {

        StockItem item = stockList.get(row);

        switch (col) {
            case 0:
                return item.getCode();
            case 1:
                return item.getBatchId();
            case 2:
                return item.getMaterialId();
            case 3:
                return item.getWidth();
            case 4:
                return item.getLength();
            case 5:
                return item.getThickness();
            case 6:
                return this.stockItemOrderCount(item);
        }
        return null;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Get the StockList ">
    /**
     * Returns the Stock list from the table model.
     *
     * @return StockItemList.
     */
    public StockItemList getStockList() {
        return stockList;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Reset/Set a StockList ">
    /**
     * Sets the Stock list on the table model. Only with the stockItems, that
     * have Order to cut.
     *
     * @param stockList The StockItemList that needs to be set.
     */
    public void setStockList(StockItemList stockList) {
        this.stockList = stockList;
        this.fireTableDataChanged();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Get a specific Stock item by row ">
    /**
     * Gets a StockItem by row.
     *
     * @param row the number of row from where we want to get the StockItem.
     * @return a StockItem from a selected row.
     */
    public StockItem getStockByRow(int row) {
        return stockList.get(row);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Get the name of a specific column ">
    @Override
    public String getColumnName(int col) {
        return colNames[col];
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Get the class of a specific column ">
    @Override
    public Class<?> getColumnClass(int col) {
        return classes[col];
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" How many orders does a stock item has ">
    private int stockItemOrderCount(StockItem si) {
        return Main.allOrderData.filterByStockItem(si).size();
    }
    //</editor-fold>
}
