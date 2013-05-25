package dk.easv.belman.BE;

//<editor-fold defaultstate="collapsed" desc=" Imports ">
import dk.easv.belman.BE.Lists.CutList;
import dk.easv.belman.BLL.ListManager;
import dk.easv.belman.GUI.Main;
//</editor-fold>

public class Item extends IEntity {

    //<editor-fold defaultstate="collapsed" desc=" Global variables ">
    private int id;
    private int productOrderId;
    private int salesOrderId;
    private int materialId;
    private int quantity;
    private double thickness;
    private double width;
    private double circumference;
    private boolean done;
    private ProductionOrder parent;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Item() ">
    public Item() {
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Item(ProductionOrder parent) ">
    public Item(ProductionOrder parent) {
        this.parent = parent;
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

    //<editor-fold defaultstate="collapsed" desc=" getProductOrderId() "> 
    /**
     * @return the productOrderId
     */
    public int getProductOrderId() {
        return productOrderId;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" setProductOrderId(int productOrderId) "> 
    /**
     * @param productOrderId the productOrderId to set
     */
    public void setProductOrderId(int productOrderId) {
        this.productOrderId = productOrderId;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" getMaterialId() "> 
    /**
     * @return the materialId
     */
    public int getMaterialId() {
        return materialId;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" setMaterialId(int materialId) "> 
    /**
     * @param materialId the materialId to set
     */
    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" getThickness() "> 
    /**
     * @return the thickness
     */
    public double getThickness() {
        return thickness;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" setThickness(double thickness) "> 
    /**
     * @param thickness the thickness to set
     */
    public void setThickness(double thickness) {
        this.thickness = thickness;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" getWidth() "> 
    /**
     * @return the width
     */
    public double getWidth() {
        return width;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" setWidth(double width) "> 
    /**
     * @param width the width to set
     */
    public void setWidth(double width) {
        this.width = width;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" getCircumference() "> 
    /**
     * @return the circumference
     */
    public double getCircumference() {
        return circumference;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" setCircumference(double circumference) "> 
    /**
     * @param circumference the circumference to set
     */
    public void setCircumference(double circumference) {
        this.circumference = circumference;
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

    //<editor-fold defaultstate="collapsed" desc=" setDone(boolean done) "> 
    /**
     * @param done the done to set
     */
    public void setDone(boolean done) {
        this.done = done;
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

    //<editor-fold defaultstate="collapsed" desc=" getRemainingCuts() ">
    /**
     * This method gets the remaining cuts of a sleeve
     *
     * @param cutList a list containing the cuts that have been made
     * @param sleeve is the one we check the remainder of
     * @return the amount left to cut for the given sleeve
     */
    public int getRemaningCuts() {
        int initialQuantity = this.getQuantity();
        CutList list = Main.allCutData.getCutsBySleeve(this).filterByArchive(false);
        for (Cut cut : list.getList()) {
            initialQuantity = initialQuantity - cut.getQuantity();
        }
        return initialQuantity;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" getParent() ">
    /**
     * @return the parent
     */
    public ProductionOrder getParent() {
        return parent;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" setParent(ProductionOrder parent ">
    /**
     * @param parent the parent to set
     */
    public void setParent(ProductionOrder parent) {
        this.parent = parent;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" save() ">
    @Override
    public void save() {
        ListManager.updateItem(this);
    }
    //</editor-fold>
}
