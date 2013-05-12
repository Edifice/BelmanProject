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

    private SalesOrderList sList; // A list of SalesOrders which contains the production orders and items inside it.
    private ItemList iList; // The contents of the table.
    // The names of columns
    private String[] colNames = {"Description", "Due Date", "Mat ID", "Width", "Circumferance", "Thickness", "Quantity"};
    // The type of columns
    private Class[] classes = {String.class, Long.class, Integer.class, Double.class, Double.class, Double.class, Integer.class};

    /**
     * Constructor for the SleeveTableModel.
     *
     * @param sList Constructs a table model based on a SalesOrdeList.
     */
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

    /**
     * @return The SalesOrderList that is being used by the table model.
     */
    public SalesOrderList getSList() {
        return sList;
    }

    /**
     * Returns all the Production Orders inside a SalesOrderList.
     *
     * @param sList The SalesOrderList in which we look for production orders.
     * @return A list of all production orders inside that specific
     * SalesOrderList.
     */
    private ProductOrderList getPList(SalesOrderList sList) {
        ProductOrderList pList = new ProductOrderList();
        for (SalesOrder s : sList.getList()) {
            for (ProductOrder p : s.getProductOrderList().getList()) {
                pList.add(p);
            }
        }
        return pList;
    }

    /**
     * Sets the Item list of a SalesOrderList.
     *
     * @param sList The SalesOrderList where we need to set the items.
     */
    public void setItemList(SalesOrderList sList) {
        this.sList = sList;
        iList = getItemList(sList);
    }

    /**
     * Sets the Item list.
     * 
     * @param iList the Item list.
     */
    public void setItemList(ItemList iList) {
        this.iList = iList;
    }

    /**
     * Gets an Item by row.
     * 
     * @param row the number of row from where we want to get the Item.
     * @return an Item from a selected row.
     */
    public Item getItemByRow(int row) {
        return iList.get(row);
    }

    @Override
    public String getColumnName(int col) {
        return colNames[col];
    }

    @Override
    public Class<?> getColumnClass(int col) {
        return classes[col];
    }

    /**
     * Returns a list of all Items from a specific SalesOrderList.
     * 
     * @param sList The SalesOrderList from where we want to get the Item list.
     * @return An Item List from a specified SalesOrderList.
     */
    private ItemList getItemList(SalesOrderList sList) {
        ItemList iList_l = new ItemList();
        for (SalesOrder s : sList.getList()) {
            for (ProductOrder p : s.getProductOrderList().getList()) {
                for (Item item : p.getItemList().getList()) {
                    iList_l.add(item);
                }
            }
        }
        return iList_l;
    }
}
