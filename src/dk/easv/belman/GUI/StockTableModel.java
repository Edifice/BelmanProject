package dk.easv.belman.GUI;

import dk.easv.belman.BE.StockItem;
import dk.easv.belman.BE.StockItemList;
import javax.swing.table.AbstractTableModel;

public class StockTableModel extends AbstractTableModel {

    private StockItemList stockList; // The contents of the table.
    // The names of columns
    private String[] colNames = {"Code", "Mat ID", "Width", "Length", "Thickness", "Batch ID", "Quantity (kg)"};
    // The type of columns
    private Class[] classes = {String.class, Integer.class, Double.class, Double.class, Double.class, String.class, Double.class};

    /**
     * Constructor for the StockTableModel.
     *
     * @param stockList Constructs a table model based on a StockList.
     */
    public StockTableModel(StockItemList stockList) {
        this.stockList = stockList;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return stockList.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Object getValueAt(int row, int col) {

        StockItem item = stockList.get(row);

        switch (col) {
            case 0:
                return item.getCode();
            case 1:
                return item.getMaterialId();
            case 2:
                return item.getWidth();
            case 3:
                return item.getLength();
            case 4:
                return item.getThickness();
            case 5:
                return item.getBatchId();
            case 6:
                return item.getQuantity();
        }
        return null;
    }

    /**
     * Returns the Stock list from the table model.
     *
     * @return StockItemList.
     */
    public StockItemList getStockList() {
        return stockList;
    }

    /**
     * Sets the Stock list on the table model.
     * 
     * @param stockList The StockItemList that needs to be set.
     */
    public void setStockList(StockItemList stockList) {
        this.stockList = stockList;

    }

    /**
     * Gets a StockItem by row.
     * 
     * @param row the number of row from where we want to get the StockItem.
     * @return a StockItem from a selected row.
     */
    public StockItem getStockByRow(int row) {
        return stockList.get(row);
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
