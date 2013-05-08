package dk.easv.belman.GUI;

import dk.easv.belman.BE.Item;
import dk.easv.belman.BE.ProductOrder;
import dk.easv.belman.BE.SalesOrder;
import dk.easv.belman.BE.SalesOrderList;
import dk.easv.belman.BE.MyTreeNode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.jdesktop.swingx.treetable.AbstractTreeTableModel;

public class MyTreeTableModel extends AbstractTreeTableModel {

    private MyTreeNode root; // The root tree node.    
//    private SalesOrderList sol;

    public MyTreeTableModel() {
        
        for (int i = 0; i < Main.allOrderData.size(); i++){
        Main.treeData.add(Main.allOrderData.get(i));
        }
        populateTable(Main.treeData);
    }

    public MyTreeTableModel(SalesOrderList so) {        
        root = new MyTreeNode();
        populateTable(so);
    }

    /**
     * TODO JavaDoc
     * @param sol 
     */
    private void populateTable(SalesOrderList sol) {
        root = new MyTreeNode();

        for (SalesOrder s : sol.getList()) {
            MyTreeNode sRoot = new MyTreeNode(s);
            root.getChildren().add(sRoot);

            for (ProductOrder p : s.getProductOrderList().getList()) {
                MyTreeNode pRoot = new MyTreeNode(p);
                sRoot.getChildren().add(pRoot);

                for (Item item : p.getItemList().getList()) {
                    pRoot.getChildren().add(new MyTreeNode(item));
                }
            }
        }
        Main.treeData = sol;
    }

    @Override
    public int getColumnCount() {
        return 8; // ?
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
        MyTreeNode treenode = (MyTreeNode) node;
        switch (column) {

            case 0:
                return treenode.getId();
            case 1:
                return treenode.getDescription();
            case 2:
                if (treenode.getDueDate() != 0) {
                    DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                    return df.format(new Date(treenode.getDueDate()));
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
        return 0;
    }

    @Override
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