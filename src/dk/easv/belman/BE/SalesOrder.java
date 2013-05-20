package dk.easv.belman.BE;

import dk.easv.belman.BE.Lists.ProductionOrderList;

public class SalesOrder extends IEntity {

    private int id;
    private String description;
    private long dueDate;
    private boolean done;
    private ProductionOrderList productOrderList;

    public SalesOrder() {
        productOrderList = new ProductionOrderList(this);
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.setPk(id);
        this.id = id;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the done
     */
    public boolean isDone() {
        return done;
    }

    /**
     * @param done the done to set
     */
    public void setDone(boolean done) {
        this.done = done;
    }

    /**
     * @return the dueDate
     */
    public long getDueDate() {
        return dueDate;
    }

    /**
     * @param dueDate the dueDate to set
     */
    public void setDueDate(long dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * @return the productOrder
     */
    public ProductionOrderList getProductOrderList() {
        return productOrderList;
    }

    /**
     * @param productOrder the productOrder to set
     */
    public void setProductOrderList(ProductionOrderList productOrderList) {
        for (ProductionOrder po : productOrderList.getList()) {
            po.setSalesOrderId(this.id);
            po.setParent(this);
        }
        this.productOrderList = productOrderList;
    }
}
