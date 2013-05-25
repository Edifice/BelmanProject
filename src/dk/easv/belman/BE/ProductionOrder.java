package dk.easv.belman.BE;

//<editor-fold defaultstate="collapsed" desc=" Imports ">
import dk.easv.belman.BE.Lists.ItemList;
//</editor-fold>

public class ProductionOrder extends IEntity {

    //<editor-fold defaultstate="collapsed" desc=" Global variables ">
    private int id;
    private int salesOrderId;
    private String description;
    private int quantity;
    private SalesOrder parent;
    private ItemList itemList;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" ProductionOrder() ">
    public ProductionOrder() {
        this.itemList = new ItemList();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" getId() ">
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" setId(int id) ">
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.setPk(id);
        this.id = id;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" getDescription() ">
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" setDescription(String description) ">
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" getSalesOrderId() ">
    /**
     * @return the salesOrderId
     */
    public int getSalesOrderId() {
        return salesOrderId;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" setSalesOrderId(int salesOrderId) ">
    /**
     * @param salesOrderId the salesOrderId to set
     */
    public void setSalesOrderId(int salesOrderId) {
        this.salesOrderId = salesOrderId;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" getItemList() ">
    /**
     * @return the itemList
     */
    public ItemList getItemList() {
        return itemList;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" setItemList(ItemList itemList) ">
    /**
     * @param itemList the itemList to set
     */
    public void setItemList(ItemList itemList) {
        for (Item i : itemList.getList()) {
            i.setProductOrderId(this.id);
        }
        this.itemList = itemList;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" getQuantity() ">
    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" setQuantity(int quantity) ">
    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" getParent() ">
    /**
     * @return the parent
     */
    public SalesOrder getParent() {
        return parent;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" setParent(SalesOrder parent) ">
    /**
     * @param parent the parent to set
     */
    public void setParent(SalesOrder parent) {
        this.parent = parent;
    }
    //</editor-fold>
}
