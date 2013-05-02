package dk.easv.belman.UI;

import dk.easv.belman.BE.Item;
import dk.easv.belman.BE.ItemList;
import dk.easv.belman.BE.ProductOrder;
import dk.easv.belman.BE.ProductOrderList;
import dk.easv.belman.BE.SalesOrder;
import dk.easv.belman.BE.SalesOrderList;
import dk.esav.belman.BLL.ListManager;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.swingx.treetable.AbstractTreeTableModel;

public class MyTreeTableModel extends AbstractTreeTableModel {

    private MyTreeNode root;
    private ListManager allLists;
    private ProductOrderList pList;

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

    private void populateTable() {
        root = new MyTreeNode();
        SalesOrderList sList = allLists.getAllSalesOrder();
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

class MyTreeNode {

    private List<MyTreeNode> children = new ArrayList<>();
    private String description, name, function;
    private double thickness, width, circumference;
    private int quantity, id, matId;
    private long dueDate;
    private SalesOrder sOrder;
    private ProductOrder pOrder;
    private Item item;

    public MyTreeNode() {
    }

    public MyTreeNode(SalesOrder salesOrder) {
        this.id = salesOrder.getId();
        this.description = salesOrder.getDescription();
        this.dueDate = salesOrder.getDueDate();
        this.function = "SalesOrder";
        this.sOrder = salesOrder;
    }

    public MyTreeNode(ProductOrder productOrder) {
        this.id = productOrder.getId();
        this.description = productOrder.getDescription();
        this.function = "ProductOrder";
        this.pOrder = productOrder;
    }

    public MyTreeNode(Item item) {
        this.id = item.getId();
        this.matId = item.getMaterialId();
        this.circumference = item.getCircumference();
        this.thickness = item.getThickness();
        this.width = item.getWidth();
        this.quantity = item.getQuantity();
        this.function = "Item";
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public String getFunction() {
        return function;
    }

    public String getName() {
        return name;
    }

    public double getThickness() {
        return thickness;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<MyTreeNode> getChildren() {
        return children;
    }

    public int getMatId() {
        return matId;
    }

    public long getDueDate() {
        return dueDate;
    }

    public String getDescription() {
        return description;
    }

    public double getWidth() {
        return width;
    }

    public double getCircumference() {
        return circumference;
    }

    public int getQuantity() {
        return quantity;
    }

    public String toString() {
        return String.valueOf(id);
    }

    public Item getItem() {
        return item;
    }
}