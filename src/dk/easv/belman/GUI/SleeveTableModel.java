package dk.easv.belman.GUI;

import dk.easv.belman.BE.Item;
import dk.easv.belman.BE.ItemList;
import dk.easv.belman.BE.ProductOrder;
import dk.easv.belman.BE.ProductOrderList;
import dk.easv.belman.BE.SalesOrder;
import dk.easv.belman.BE.SalesOrderList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

public class SleeveTableModel extends AbstractTableModel {

    private SalesOrderList sList;
    private ItemList iList;
    // The names of columns
    private String[] colNames = {"Description", "Due Date", "Mat ID", "Width", "Circumferance", "Thickness", "Quantity"};
    // The type of columns
    private Class[] classes = {String.class, Long.class, Integer.class, Double.class, Double.class, Double.class, Integer.class};

    public SleeveTableModel(SalesOrderList sList) {
        this.sList = sList;
        iList = getItemList(sList);
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return iList.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Object getValueAt(int row, int col) {

        Item item = iList.get(row);
        switch (col) {
            case 0:
                return getPList(sList).getById(item.getProductOrderId()).getDescription();
                
            case 1:
                DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                return df.format(new Date(Main.allOrderData.getById(item.getSalesOrderId()).getDueDate()));
            case 2:
                return item.getMaterialId();
            case 3:
                return item.getWidth();
            case 4:
                return item.getCircumference();
            case 5:
                return item.getThickness();
            case 6:
                return item.getQuantity();
        }
        return null;

    }

    public SalesOrderList getSList() {
        return sList;
    }

    private ProductOrderList getPList(SalesOrderList sList) {
        ProductOrderList pList = new ProductOrderList();
        for (SalesOrder s : sList.getList()) {
            for (ProductOrder p : s.getProductOrderList().getList()) {
                pList.add(p);
            }
        }
        return pList;
    }

    public void setItemList(SalesOrderList sList) {
        this.sList = sList;
        iList = getItemList(sList);
    }
    public void setItemList(ItemList iList){
        this.iList = iList;
    }

    public Item getItemByRow(int row) {
        return iList.get(row);
    }

    public String getColumnName(int col) {
        return colNames[col];
    }

    @Override
    public Class<?> getColumnClass(int col) {

        return classes[col];
    }

    private ItemList getItemList(SalesOrderList sList) {
        ItemList iList = new ItemList();
        for (SalesOrder s : sList.getList()) {
            for (ProductOrder p : s.getProductOrderList().getList()) {
                for (Item item : p.getItemList().getList()) {
                    iList.add(item);
                }
            }
        }
        return iList;
    }
}
