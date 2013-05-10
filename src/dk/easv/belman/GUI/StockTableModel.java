package dk.easv.belman.GUI;

import dk.easv.belman.BE.ItemList;
import dk.easv.belman.BE.StockItem;
import dk.easv.belman.BE.StockItemList;
import javax.swing.table.AbstractTableModel;

public class StockTableModel extends AbstractTableModel {

    private StockItemList stockList;
    // The names of columns
    private String[] colNames = {"Code", "Mat ID", "Width", "Length", "Thickness", "Batch ID", "Quantity"};
    // The type of columns
    private Class[] classes = {String.class, Integer.class, Double.class, Double.class, Double.class, String.class, Double.class};

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
                return item.getLenght();
            case 4:
                return item.getThickness();
            case 5:
                return item.getBatchId();
            case 6:
                return item.getQuantity();
        }
        return null;

    }



    public void setStockList(StockItemList stockList) {
        this.stockList = stockList;
        
    }

    public StockItem getStockByRow(int row) {
        return stockList.get(row);
    }

    public String getColumnName(int col) {
        return colNames[col];
    }

    @Override
    public Class<?> getColumnClass(int col) {

        return classes[col];
    }

}
