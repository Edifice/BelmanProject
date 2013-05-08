/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.easv.belman.GUI;

import dk.easv.belman.BE.Item;
import dk.easv.belman.BE.ItemList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

public class QueueTableModel extends AbstractTableModel {

    private Item item;
    private ItemList items;
    // The names of columns
    private String[] colNames = {"ID", "Due Date", "Coil"};
    // The type of columns
    private Class[] classes = {Integer.class, Long.class, Integer.class};
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
        item = items.get(row);

        switch (col) {
            case 0:
                return item.getId();

            case 1:
                DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                return df.format(new Date(Main.allOrderData.getById(item.getSalesOrderId()).getDueDate()));

            case 2:
                //TODO get the material's name here
                return item.getMaterialId();
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
        if (!items.hasId(item.getId())) {
            items.add(item);
        }
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

    public void reorder(int fromIndex, int toIndex) {
        if (fromIndex < toIndex) {
            for (int i = fromIndex; i < toIndex-1;) {
                Collections.swap(items.getList(), i, ++i);
            }
        } else {
            for (int i = fromIndex; i > toIndex;) {
                Collections.swap(items.getList(), i, --i);
            }
        }
        this.fireTableDataChanged();
    }
}
