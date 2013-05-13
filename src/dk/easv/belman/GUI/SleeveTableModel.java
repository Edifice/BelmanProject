package dk.easv.belman.GUI;

import dk.easv.belman.BE.Item;
import dk.easv.belman.BE.ItemList;
import dk.easv.belman.BE.SalesOrderList;
import dk.easv.belman.BLL.ListManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

public class SleeveTableModel extends AbstractTableModel {

    private SalesOrderList sList; // A list of SalesOrders which contains the production orders and items inside it.
    private ListManager listManager;
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
        listManager = new ListManager();
        iList = listManager.getItemList(sList);
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
                return listManager.getProductOrderList(sList).getById(item.getProductOrderId()).getDescription();
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
     * Removes an item from the list
     * @param item 
     */
    public void removeItem(Item item) {
        iList.remove(item);
    }
    /**
     * Adds an item to the list
     * @param item 
     */
    public void addItem(Item item) {
        iList.add(item);
    }
    

    /**
     * Sets the Item list of a SalesOrderList.
     *
     * @param sList The SalesOrderList where we need to set the items.
     */
    public void setItemList(SalesOrderList sList) {
        this.sList = sList;
        iList = listManager.getItemList(sList);
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

    
}
