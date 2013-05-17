package dk.easv.belman.BE;

public class ProductionOrder extends IEntity {

    private int id;
    private int salesOrderId;
    private String description;
    private int quantity;
    private SalesOrder parent;
    private ItemList itemList;

    public ProductionOrder() {
        this.itemList = new ItemList();
    }

    public ProductionOrder(SalesOrder parent) {
        this.itemList = new ItemList();
        this.parent = parent;
    }

    /**
     * Getting an existing Sales order from DB by id
     *
     * @param pk
     */
    public ProductionOrder(int id) {
        this.setPk(id);

        // @TODO get by id
        ProductionOrder now = new ProductionOrder();

        this.id = now.id;
        this.salesOrderId = now.salesOrderId;
        this.description = now.description;
        this.quantity = now.quantity;
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
        for (Item i : itemList.getList()) {
            i.setProductOrderId(this.id);
        }
        this.itemList = itemList;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the parent
     */
    public SalesOrder getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(SalesOrder parent) {
        this.parent = parent;
    }
}
