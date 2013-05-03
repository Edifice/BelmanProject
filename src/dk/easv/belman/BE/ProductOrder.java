package dk.easv.belman.BE;

public class ProductOrder extends IEntity {

    private int id;
    private int salesOrderId;
    private String description;
    private boolean done;
    
    private ItemList itemList;

    public ProductOrder() {
        itemList = new ItemList();
    }

    /**
     * Getting an existing Sales order from DB by id
     *
     * @param pk
     */
    public ProductOrder(int id) {
        this.setPk(id);

        // @TODO get by id
        ProductOrder now = new ProductOrder();

        this.id = now.id;
        this.salesOrderId = now.salesOrderId;
        this.description = now.description;
        this.done = now.done;
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
     * @return the salesOrderId
     */
    public int getSalesOrderId() {
        return salesOrderId;
    }

    /**
     * @param salesOrderId the salesOrderId to set
     */
    public void setSalesOrderId(int salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    /**
     * @return the itemList
     */
    public ItemList getItemList() {
        return itemList;
    }

    /**
     * @param itemList the itemList to set
     */
    public void setItemList(ItemList itemList) {
        for(Item i : itemList.getList()){
            i.setProductOrderId(this.id);
        }
        this.itemList = itemList;
    }
}
