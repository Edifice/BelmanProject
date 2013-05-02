package dk.easv.belman.GUI;

import dk.easv.belman.BE.ProductOrderList;
import dk.easv.belman.BE.SalesOrderList;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import org.jdesktop.swingx.JXTreeTable;

public final class OrderListing {

    private MyTreeTableModel treeTableModel;
    private MyTreeNode treeNode;
    private MainGui parent;
    private JXTreeTable treeTable;

    public OrderListing(MainGui parent) {
        this.parent = parent;
        setOrderListing();
        setParentPanes();
       

    }

    public ProductOrderList getPList() {
        return treeTableModel.getPList();
    }
    public SalesOrderList getSList() {
        return treeTableModel.getSList();
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

    public JXTreeTable getTreeTable() {
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

    private MyTreeNode getSelectedNode(java.awt.event.MouseEvent e) {
        final int rowIndex = treeTable.rowAtPoint(e.getPoint());

        if (rowIndex < 0) {
            return null;
        }
        treeNode = (MyTreeNode) treeTable.getPathForRow(rowIndex).getLastPathComponent();

        return treeNode;
    }
    /**
     * Sets the parents panes
     */
    public void setParentPanes() {
        treeTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                treeNode = getSelectedNode(e);
                if (e.getClickCount() != 2) {
                    parent.setDescriptionPane(treeNode);
                } else {
                    if (treeNode.getId() == treeNode.getItem().getId()){
                    parent.setQueueTable(treeNode.getItem());
                    }
                }


            }
        });
    }
}
