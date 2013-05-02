package dk.easv.belman.GUI;

import dk.easv.belman.BE.Item;
import dk.easv.belman.BE.ItemList;
import dk.easv.belman.BE.ProductOrder;
import dk.easv.belman.BE.ProductOrderList;
import dk.easv.belman.BE.SalesOrder;
import dk.easv.belman.BE.SalesOrderList;
import dk.easv.belman.BE.MyTreeNode;
import dk.easv.belman.BLL.ListManager;
import java.sql.Timestamp;
import org.jdesktop.swingx.treetable.AbstractTreeTableModel;

public class MyTreeTableModel extends AbstractTreeTableModel {

    private MyTreeNode root;
    private ListManager allLists;
    private ProductOrderList pList;
    private SalesOrderList sList;

    public MyTreeTableModel() {
        init();
        populateTable();
    }

    private void init() {
        allLists = new ListManager();
    }

    public ListManager getAllLists() {
        return allLists;
    }

    public ProductOrderList getPList() {
        return pList;
    }
    public SalesOrderList getSList() {
        return sList;
    }

    private void populateTable() {
        root = new MyTreeNode();
        sList = allLists.getAllSalesOrder();
        int sOrdId = 0;
        pList = allLists.getAllProductOrder();
        ItemList items = allLists.getAllItem();

        for (SalesOrder s : sList.getList()) {
            MyTreeNode sRoot = new MyTreeNode(s);
            root.getChildren().add(sRoot);
            sOrdId = s.getId();

            for (ProductOrder p : pList.getList()) {
                if (p.getSalesOrderId() == s.getId()) {
                    MyTreeNode pRoot = new MyTreeNode(p);
                    sRoot.getChildren().add(pRoot);

                    for (Item item : items.getList()) {
                        if (item.getProductOrderId() == p.getId()) {
                            pRoot.getChildren().add(new MyTreeNode(item));
                        }
                    }
                }
            }
        }
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Description";
            case 2:
                return "DueDate";
            case 3:
                return "Material ID";
            case 4:
                return "Width";
            case 5:
                return "Circumferance";
            case 6:
                return "Thickness";
            case 7:
                return "Quantity";
            default:
                return "Unknown";
        }
    }

    @Override
    public Object getValueAt(Object node, int column) {
        //System.out.println("getValueAt: " + node + ", " + column);
        MyTreeNode treenode = (MyTreeNode) node;
        switch (column) {

            case 0:
                return treenode.getId();
            case 1:
                return treenode.getDescription();
            case 2:
                if (treenode.getDueDate() != 0) {
                    return new Timestamp(treenode.getDueDate());
                } else {
                    return "";
                }
            case 3:
                if (treenode.getMatId() != 0) {
                    return treenode.getMatId();
                } else {
                    return "";
                }
            case 4:
                if (treenode.getWidth() != 0) {
                    return treenode.getWidth();
                } else {
                    return "";
                }
            case 5:
                if (treenode.getCircumference() != 0) {
                    return treenode.getCircumference();
                } else {
                    return "";
                }
            case 6:
                if (treenode.getThickness() != 0) {
                    return treenode.getThickness();
                } else {
                    return "";
                }
            case 7:
                if (treenode.getQuantity() != 0) {
                    return treenode.getQuantity();
                } else {
                    return "";
                }
            default:
                return "Unknown";
        }

    }

    @Override
    public Object getChild(Object node, int index) {
        MyTreeNode treenode = (MyTreeNode) node;
        return treenode.getChildren().get(index);
    }

    @Override
    public int getChildCount(Object parent) {
        MyTreeNode treenode = (MyTreeNode) parent;
        return treenode.getChildren().size();
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        MyTreeNode treenode = (MyTreeNode) parent;
        for (int i = 0; i > treenode.getChildren().size(); i++) {
            if (treenode.getChildren().get(i) == child) {
                return i;
            }
        }

        // TODO Auto-generated method stub
        return 0;
    }

    public boolean isLeaf(Object node) {
        MyTreeNode treenode = (MyTreeNode) node;
        if (treenode.getChildren().size() > 0) {
            return false;
        }
        return true;
    }

    @Override
    public Object getRoot() {
        return root;
    }
}