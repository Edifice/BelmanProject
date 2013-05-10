//package dk.easv.belman.GUI;
//
//import dk.easv.belman.BE.MyTreeNode;
//import dk.easv.belman.BE.SalesOrderList;
//import java.awt.BorderLayout;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.ListSelectionModel;
//import org.jdesktop.swingx.JXTreeTable;
//
//public final class OrderListing {
//
//    private MainGui parent; // Parent object.
//    private JXTreeTable treeTable; // The TreeTable.
//    private MyTreeTableModel treeTableModel; // The model for the TreeTable.
//    private MyTreeNode treeNode; // One selected object from the TreeTable.
//
//    public OrderListing(MainGui parent) {
//        // Create the initial TreeTable.
//        treeTableModel = new MyTreeTableModel();
//        treeTable = new JXTreeTable(treeTableModel);
//        // Set the parent for this object.
//        this.parent = parent;
//        // Set up the panes.
//        setOrderListing();
//    }
//
//    /**
//     * TODO JavaDoc
//     */
//    public void setOrderListing() {
//        parent.getSpnlWest().setLeftComponent(getPanel());
//        addListeners();
//    }
//
//    /**
//     * TODO JavaDoc
//     * @return 
//     */
//    public JPanel getPanel() {
//        JPanel p = new JPanel(new BorderLayout());
//        JScrollPane sp = new JScrollPane(setTreeTable());
//        p.add(sp);
//        return p;
//    }
//
//    /**
//     * TODO JavaDoc
//     *
//     * @param so
//     */
//    public void setTreeTableModel(SalesOrderList so) {
//        treeTableModel = new MyTreeTableModel(so);
//        treeTable.setTreeTableModel(treeTableModel);
//    }
//
//    /**
//     * TODO JavaDoc
//     *
//     * @return
//     */
//    public JXTreeTable setTreeTable() {
//        // Build the tree table panel
//        treeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        treeTable.setColumnControlVisible(true);
//        treeTable.setShowGrid(true);
//        treeTable.expandAll();
//        treeTable.packAll();
//        return treeTable;
//    }
//
//    /**
//     * This method takes in a mouse action and returns the currently selected
//     * element from the TreeTable.
//     *
//     * @param e Mouse Event
//     * @return currently selected node
//     */
//    private MyTreeNode getSelectedNode(java.awt.event.MouseEvent e) {
//        final int rowIndex = treeTable.rowAtPoint(e.getPoint());
//
//        if (rowIndex < 0) {
//            return null;
//        }
//        treeNode = (MyTreeNode) treeTable.getPathForRow(rowIndex).getLastPathComponent();
//
//        return treeNode;
//    }
//
//    /**
//     * This method takes in a key action and looks up the currently selected
//     * item/order in the TreeTable. If the up key is pressed it returns the
//     * currently selected row - 1, if the down button is selected it returns the
//     * currently selected + 1 element from the TreeTable.
//     *
//     * @param e Key Event
//     * @return the currently selected node
//     */
//    private MyTreeNode getSelectedNode(java.awt.event.KeyEvent e) {
//        int keyUp = KeyEvent.VK_UP;
//        int keyDown = KeyEvent.VK_DOWN;
//        if (e.getKeyCode() == keyUp && ((treeTable.getSelectedRow() - 1) >= 0)) {
//            treeNode = (MyTreeNode) treeTable.getPathForRow(treeTable.getSelectedRow() - 1).getLastPathComponent();
//        } else if (e.getKeyCode() == keyDown && ((treeTable.getSelectedRow() + 1) < treeTable.getRowCount())) {
//            treeNode = (MyTreeNode) treeTable.getPathForRow(treeTable.getSelectedRow() + 1).getLastPathComponent();
//        } else {
//            treeNode = (MyTreeNode) treeTable.getPathForRow(treeTable.getSelectedRow()).getLastPathComponent();
//
//        }
//        return treeNode;
//    }
//
//    /**
//     * Sets the parents panes
//     */
//    public void addListeners() {
//        // Listening for clicks on the TreeTable.
//        treeTable.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(final MouseEvent e) {
//                treeNode = getSelectedNode(e);
//                if (e.getClickCount() != 2) {
//                    parent.setDescriptionPane(treeNode);
//                } else {
//                    if (treeNode.getItem() != null) {
//                        if (treeNode.getId() == treeNode.getItem().getId()) {
//                            parent.setQueueTable(treeNode.getItem());
//                        }
//                    } else {
//                        System.out.println("You clicked on a non Item row!");
//                    }
//                }
//            }
//        });
//        // Listening for key presses on the TreeTable.
//        treeTable.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                int keyUp = KeyEvent.VK_UP;
//                int keyDown = KeyEvent.VK_DOWN;
//                int keyEnter = KeyEvent.VK_ENTER;
//                treeNode = getSelectedNode(e);
//                if (e.getKeyCode() == keyUp || e.getKeyCode() == keyDown) {
//                    parent.setDescriptionPane(treeNode);
//                } else if (e.getKeyCode() == keyEnter) {
//                    if (treeNode.getId() == treeNode.getItem().getId()) { // TODO Deal with the nullpointerexception when clicking or pressing enter on anything other than a item
//                        parent.setQueueTable(treeNode.getItem());
//                    }
//                }
//            }
//        });
//    }
//}
