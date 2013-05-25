package dk.easv.belman.BE;

//<editor-fold defaultstate="collapsed" desc=" Imports ">
import dk.easv.belman.BE.Lists.ProductionOrderList;
//</editor-fold>

public class SalesOrder extends IEntity {

    //<editor-fold defaultstate="collapsed" desc=" Global variables ">
    private int id;
    private String description;
    private long dueDate;
    private boolean done;
    private ProductionOrderList productOrderList;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" SalesOrder() ">
    public SalesOrder() {
        productOrderList = new ProductionOrderList(this);
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

    //<editor-fold defaultstate="collapsed" desc=" isDone() ">
    /**
     * @return the done
     */
    public boolean isDone() {
        return done;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" setDonne(boolean done) ">
    /**
     * @param done the done to set
     */
    public void setDone(boolean done) {
        this.done = done;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" getDueDate() ">
    /**
     * @return the dueDate
     */
    public long getDueDate() {
        return dueDate;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" setDueDate(long dueDate) ">
    /**
     * @param dueDate the dueDate to set
     */
    public void setDueDate(long dueDate) {
        this.dueDate = dueDate;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" getProductionOrderList() ">
    /**
     * @return the productOrder
     */
    public ProductionOrderList getProductOrderList() {
        return productOrderList;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" setProductionOrderList(ProductionOrderList productionOrderList) ">
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
    //</editor-fold>
}
