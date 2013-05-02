/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.easv.belman.BE;

import java.util.ArrayList;
import java.util.List;

public class MyTreeNode {

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

    @Override
    public String toString() {
        return String.valueOf(id);
    }

    public Item getItem() {
        return item;
    }
}