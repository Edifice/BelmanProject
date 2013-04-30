package dk.easv.belman.UI;

import dk.easv.belman.BE.BList;
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
    
    public MyTreeTableModel() {
        init();
        populateTable();
        
        
    }
    
    private void init() {
        allLists = new ListManager();
        
    }
    
    private void populateTable() {
        
        
        root = new MyTreeNode();


//        for (int i = 0; i < 4; i++) {
//            sOrders.add(new SalesOrder(i));
//        }
//        pOrders.add(new ProductionOrder(0, 0, "01-01-2013"));
//        pOrders.add(new ProductionOrder(1, 1, "02-02-2013"));
//        pOrders.add(new ProductionOrder(2, 1, "03-02-2013"));
//        pOrders.add(new ProductionOrder(3, 3, "03-02-2013"));
//        pOrders.add(new ProductionOrder(4, 4, "03-02-2013"));
//        pOrders.add(new ProductionOrder(4, 2, "03-02-2013"));
//
//        items.add(new Item("10", 1, 300, 400, 0.22, 30));
//        items.add(new Item("15", 1, 500, 400, 0.22, 30));
//        items.add(new Item("12", 2, 800, 400, 0.22, 30));
//        items.add(new Item("5", 2, 800, 400, 0.22, 30));
//        items.add(new Item("7", 0, 800, 400, 0.22, 30));
//        items.add(new Item("8", 3, 800, 400, 0.22, 30));
//        items.add(new Item("333", 4, 800, 400, 0.22, 30));
//        items.add(new Item("40", 4, 800, 400, 0.22, 30));

        for (SalesOrder s : allLists.getAllSalesOrder().getList()) {
            //Uncomment this to set ID as name
            //String sName = String.valueOf(s.getId());

            //Change to sName;
            MyTreeNode sRoot = new MyTreeNode(s.getId(), s.getDescription());
            
            root.getChildren().add(sRoot);
            
            for (ProductOrder p : allLists.getAllProductOrder(s.getId()).getList()) {
                //Uncomment this to set ID as name
                //String pName = String.valueOf(p.getId());

                //Change first param to pName;
                MyTreeNode pRoot = new MyTreeNode(p.getId(), p.getDescription(), p.getDueDate());
                //if (s.getId() == p.getSId()) {
                sRoot.getChildren().add(pRoot);
                //}

                for (Item item : allLists.getAllItems(p.getId()).getList()) {
                    //if (p.getId() == item.getOrdId()) {
                    pRoot.getChildren().add(new MyTreeNode(item.getId(), item.getMaterialId(), item.getWidth(), item.getCircumference(), item.getThickness(), item.getQuantity()));
                    //}
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
    private String description, name;
    private double thickness, width, circumference;
    private int quantity, id, matId;
    private long dueDate;
    
    public MyTreeNode() {
    }
    //Sales order node

    public MyTreeNode(int id, String description) {
        this.id = id;
        this.description = description;
        
        
    }
    //Production order node

    public MyTreeNode(int id, String description, long dueDate) {
        this.id = id;
        this.description = description;
        this.dueDate = dueDate;
    }
    
    //Item order node
    public MyTreeNode(int id, int matId, double width, double thickness, double circumference, int quantity) {
        
        this.matId = matId;
        this.id = id;
        this.width = width;
        this.circumference = circumference;
        this.quantity = quantity;
        this.thickness = thickness;
    }
    
    public int getId() {
        return id;
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
        return "MyTreeNode: " + id;
    }
}
//class SalesOrder {
//
//    private int id;
//
//    public SalesOrder(int id) {
//        this.id = id;
//    }
//
//    public int getId() {
//        return id;
//    }
//}
//
//class ProductionOrder {
//
//    private int id;
//    private int sId;
//    private String dueDate;
//
//    public ProductionOrder(int id, int sId, String dueDate) {
//        this.id = id;
//        this.sId = sId;
//        this.dueDate = dueDate;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public int getSId() {
//        return sId;
//    }
//
//    public String getDueDate() {
//        return dueDate;
//    }
//}
//
//class Item {
//
//    private String matId;
//    private int ordId, quantity;
//    private double length, width, circumference;
//
//    public Item(String matId, int ordId, double length, double width, double circumference, int quantity) {
//        this.matId = matId;
//        this.ordId = ordId;
//        this.length = length;
//        this.width = width;
//        this.circumference = circumference;
//        this.quantity = quantity;
//    }
//
//    public String getMatId() {
//        return matId;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public double getWidth() {
//        return width;
//    }
//
//    public double getCircumference() {
//        return circumference;
//    }
//
//    public int getOrdId() {
//        return ordId;
//    }
//
//    public double getLength() {
//        return length;
//    }
// }