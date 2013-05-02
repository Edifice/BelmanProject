/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.easv.belman.GUI;

import dk.easv.belman.BE.Item;
import dk.easv.belman.BE.ItemList;
import dk.easv.belman.BE.ProductOrder;
import dk.easv.belman.BE.ProductOrderList;
import dk.easv.belman.BE.SalesOrder;
import dk.easv.belman.BE.SalesOrderList;
import java.sql.Timestamp;
import javax.swing.table.AbstractTableModel;

public class QueueTableModel extends AbstractTableModel{
    // Instance fields containing the employees to show in the table.

    private Item item;
    private ItemList items;
    // The names of columns
    private String[] colNames = {"ID", "Due Date"};
    // The type of columns
    private Class[] classes = {Integer.class, Long.class};
    private final MainGui parent;

    public QueueTableModel(ItemList items, MainGui parent) {
        this.items = items;
        this.parent = parent;

        fireTableDataChanged();


    }

    @Override
    public int getRowCount() {
        return items.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        ProductOrderList pList = parent.getPList();
        SalesOrderList sList = parent.getSList();
        item = items.get(row);

        switch (col) {

            case 0:
                return item.getId();

            case 1:

                for (ProductOrder p : pList.getList()) {
                    if (item.getProductOrderId() == p.getId()) {
                        for (SalesOrder s : sList.getList()) {
                            if (p.getSalesOrderId() == s.getId()) {
                                return new Timestamp(s.getDueDate());
                            }
                        }
                    }
                }


        }
        return null;
    }

    @Override
    public String getColumnName(int col) {
        return colNames[col];
    }

    @Override
    public Class<?> getColumnClass(int col) {

        return classes[col];
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return true;
    }

    public void addItems(Item item) {
        items.add(item);
    }

    /**
     * Return the item instance from the table model with the given row index.
     *
     * @param row the index for the item in the items list.
     * @return the item at the given row index.
     */
    public Item getItemByRow(int row) {
        return items.get(row);
    }

   
}
