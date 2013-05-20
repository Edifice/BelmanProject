package dk.easv.belman.GUI;

//<editor-fold defaultstate="collapsed" desc=" Imports ">
import dk.easv.belman.BE.Item;
import dk.easv.belman.BE.ProductionOrder;
import dk.easv.belman.BE.SalesOrder;
import dk.easv.belman.BE.StockItem;
import dk.easv.belman.BE.StockItemList;
import javax.swing.table.AbstractTableModel;
//</editor-fold>

public class StockTableModel extends AbstractTableModel {

    private StockItemList stockList; // The contents of the table.
    // The names of columns
    private String[] colNames = {"Code", "Batch ID", "Mat ID", "Width", "Length", "Thickness", "Orders"};
    // The type of columns
    private Class[] classes = {String.class, String.class, Integer.class, Double.class, Double.class, Double.class, Integer.class};

    /**
     * Constructor for the StockTableModel.
     *
     * @param stockList Constructs a table model based on a StockList.
     */
    public StockTableModel(StockItemList stockList) {
        this.setStockList(stockList);
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

    /**
     * Returns the Stock list from the table model.
     *
     * @return StockItemList.
     */
    public StockItemList getStockList() {
        return stockList;
    }

    /**
     * Sets the Stock list on the table model. Only with the stockItems, that
     * have Order to cut.
     *
     * @param stockList The StockItemList that needs to be set.
     */
    public void setStockList(StockItemList stockList) {
        this.stockList = new StockItemList();

        for (StockItem si : stockList.getList()) {
            boolean hasItemToCut = false;
            for (SalesOrder so : Main.allOrderData.getList()) {
                for (ProductionOrder po : so.getProductOrderList().getList()) {
                    for (Item item : po.getItemList().getList()) {
                        if (si.canCut(item)) {
                            hasItemToCut = true;
                        }
                    }
                }
            }
            if (hasItemToCut) {
                this.stockList.add(si);
            }
        }
        this.fireTableDataChanged();
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

    private int stockItemOrderCount(StockItem si) {
        int ret = 0;
        for (SalesOrder so : Main.allOrderData.getList()) {
            for (ProductionOrder po : so.getProductOrderList().getList()) {
                ret += Main.allOrderData.filterByStockItem(si).size();
            }
        }
        return ret;
    }
}
