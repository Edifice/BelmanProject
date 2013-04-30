package dk.easv.belman.UI;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import org.jdesktop.swingx.JXTreeTable;

public final class OrderListing {

    private MyTreeTableModel treeTableModel;
    private MainGui parent;
    private JXTreeTable treeTable;

    public OrderListing(MainGui parent) {
        this.parent = parent;

        setOrderListing();
    }

    public void setOrderListing() {
        parent.getSpnlWest().setLeftComponent(getPanel());
    }

    private JPanel getPanel() {
        JPanel p = new JPanel(new BorderLayout());
        JScrollPane sp = new JScrollPane(getTreeTable());
        p.add(sp);
        return p;
    }

    private JXTreeTable getTreeTable() {
        treeTableModel = new MyTreeTableModel();
        treeTable = new JXTreeTable(treeTableModel);
        treeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // Build the tree table panel

        treeTable.setColumnControlVisible(true);
        treeTable.setShowGrid(true);
        treeTable.expandAll();
        treeTable.packAll();
        return treeTable;
    }
}
