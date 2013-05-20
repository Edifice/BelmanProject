package dk.easv.belman.GUI.Models;

//<editor-fold defaultstate="collapsed" desc=" Imports ">
import dk.easv.belman.BE.Item;
import dk.easv.belman.BE.Lists.ItemList;
import dk.easv.belman.BE.Lists.SalesOrderList;
import dk.easv.belman.GUI.Main;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.AbstractTableModel;
//</editor-fold>

public class SleeveTableModel extends AbstractTableModel {

    private ItemList iList; // The contents of the table.
    // The names of columns
    private String[] colNames = {"Description", "Due Date", "Mat ID", "Width", "Circumferance", "Thickness", "Quantity", "Left"};
    // The type of columns
    private Class[] classes = {String.class, Long.class, Integer.class, Double.class, Double.class, Double.class, Integer.class, Integer.class};

    /**
     * Constructor for the SleeveTableModel.
     *
     * @param sList Constructs a table model based on a SalesOrdeList.
     */
    public SleeveTableModel(ItemList list) {
        this.iList = list;
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
                return item.getParent().getDescription();
            case 1:
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
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
            case 7:
                return item.getRemaningCuts();
        }
        return null;
    }

    /**
     * Removes an item from the list
     *
     * @param item
     */
    public void removeItem(Item item) {
        iList.remove(item);
    }

    /**
     * Adds an item to the list
     *
     * @param item
     */
    public void addItem(Item item) {
        iList.add(item);
    }

    /**
     * Sets the Item list.
     *
     * @param iList the Item list.
     */
    public void setItemList(ItemList iList) {
        this.iList = iList;
        this.fireTableDataChanged();
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
