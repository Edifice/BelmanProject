package dk.easv.belman.GUI;

import dk.easv.belman.BE.MyTreeNode;
import dk.easv.belman.BE.ProductOrderList;
import dk.easv.belman.BE.SalesOrderList;
import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

    public SalesOrderList getSalesOrderList() {
        return treeTableModel.getSalesOrderList();
    }

    public void setOrderListing() {
        parent.getSpnlWest().setLeftComponent(getPanel());
    }

    private JPanel getPanel() {
        JPanel p = new JPanel(new BorderLayout());
        JScrollPane sp = new JScrollPane(setTreeTable());
        p.add(sp);
        return p;
    }
    public MyTreeTableModel getTreeTableModel() {
        return treeTableModel;
    }
    public JXTreeTable setTreeTable() {
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

    /**
     * This method takes in a mouse action and returns the currently selected
     * element from the TreeTable.
     *
     * @param e Mouse Event
     * @return currently selected node
     */
    private MyTreeNode getSelectedNode(java.awt.event.MouseEvent e) {
        final int rowIndex = treeTable.rowAtPoint(e.getPoint());

        if (rowIndex < 0) {
            return null;
        }
        treeNode = (MyTreeNode) treeTable.getPathForRow(rowIndex).getLastPathComponent();

        return treeNode;
    }

    /**
     * This method takes in a key action and looks up the currently selected
     * item/order in the TreeTable. If the up key is pressed it returns the
     * currently selected row - 1, if the down button is selected it returns the
     * currently selected + 1 element from the TreeTable.
     *
     * @param e Key Event
     * @return the currently selected node
     */
    private MyTreeNode getSelectedNode(java.awt.event.KeyEvent e) {
        int keyUp = KeyEvent.VK_UP;
        int keyDown = KeyEvent.VK_DOWN;
        if (e.getKeyCode() == keyUp && ((treeTable.getSelectedRow() - 1) >= 0)) {
            treeNode = (MyTreeNode) treeTable.getPathForRow(treeTable.getSelectedRow() - 1).getLastPathComponent();
        } else if (e.getKeyCode() == keyDown && ((treeTable.getSelectedRow() + 1) < treeTable.getRowCount())) {
            treeNode = (MyTreeNode) treeTable.getPathForRow(treeTable.getSelectedRow() + 1).getLastPathComponent();
        } else {
            treeNode = (MyTreeNode) treeTable.getPathForRow(treeTable.getSelectedRow()).getLastPathComponent();

        }
        return treeNode;
    }

    /**
     * Sets the parents panes
     */
    public void setParentPanes() {
        // Listening for clicks on the TreeTable.
        treeTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                treeNode = getSelectedNode(e);
                if (e.getClickCount() != 2) {
                    parent.setDescriptionPane(treeNode);
                } else {
                    if (treeNode.getId() == treeNode.getItem().getId()) {
                        parent.setQueueTable(treeNode.getItem());
                    }
                }
            }
        });
        // Listening for key presses on the TreeTable.
        treeTable.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyUp = KeyEvent.VK_UP;
                int keyDown = KeyEvent.VK_DOWN;
                int keyEnter = KeyEvent.VK_ENTER;
                treeNode = getSelectedNode(e);
                if (e.getKeyCode() == keyUp || e.getKeyCode() == keyDown) {
                    parent.setDescriptionPane(treeNode);
                } else if (e.getKeyCode() == keyEnter) {
                    if (treeNode.getId() == treeNode.getItem().getId()) { // ?
                        parent.setQueueTable(treeNode.getItem());
                    }
                }
            }
        });
    }
}
