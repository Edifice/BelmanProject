//package dk.easv.belman.GUI;
//
//import dk.easv.belman.BE.Item;
//import dk.easv.belman.BE.ItemList;
//import dk.easv.belman.BE.ProductOrder;
//import dk.easv.belman.BE.ProductOrderList;
//import dk.easv.belman.BE.SalesOrder;
//import dk.easv.belman.BE.SalesOrderList;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import javax.swing.table.AbstractTableModel;
//
//public class StockTableModel extends AbstractTableModel {
//
//    private StockItemList stockList;
//    private ItemList iList;
//    // The names of columns
//    private String[] colNames = {"Code", "Mat ID", "Width", "Length", "Thickness", "Batch ID", "Quantity"};
//    // The type of columns
//    private Class[] classes = {String.class, Integer.class, Double.class, Double.class, Double.class, String.class, Double.class};
//
//    public StockTableModel(StockItemList stockList) {
//        this.stockList = stockList;        
//        fireTableDataChanged();
//    }
//
//    @Override
//    public int getRowCount() {
//        return iList.size();
//    }
//
//    @Override
//    public int getColumnCount() {
//        return colNames.length;
//    }
//
//    @Override
//    public Object getValueAt(int row, int col) {
//
//        StockItem item = stockList.get(row);
//        switch (col) {
//            case 0:
//                return item.
//                
//            case 1:
//                DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//                return df.format(new Date(Main.allOrderData.getById(item.getSalesOrderId()).getDueDate()));
//            case 2:
//                return item.getMaterialId();
//            case 3:
//                return item.getWidth();
//            case 4:
//                return item.getCircumference();
//            case 5:
//                return item.getThickness();
//            case 6:
//                return item.getQuantity();
//        }
//        return null;
//
//    }
//
//
//
//    public void setStockList(StockItemList stockList) {
//        this.stockList = stockList;
//        
//    }
//
//    public Item getStockByRow(int row) {
//        return stockList.get(row);
//    }
//
//    public String getColumnName(int col) {
//        return colNames[col];
//    }
//
//    @Override
//    public Class<?> getColumnClass(int col) {
//
//        return classes[col];
//    }
//
//}
