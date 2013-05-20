package dk.easv.belman.BE;

//<editor-fold defaultstate="collapsed" desc=" Imports ">
import dk.easv.belman.BE.Lists.CutList;
import dk.easv.belman.BLL.ListManager;
import dk.easv.belman.GUI.Main;
//</editor-fold>

public class Item extends IEntity {

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

    public Item() {
    }

    public Item(ProductionOrder parent) {
        this.parent = parent;
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
     * @return the productOrderId
     */
    public int getProductOrderId() {
        return productOrderId;
    }

    /**
     * @param productOrderId the productOrderId to set
     */
    public void setProductOrderId(int productOrderId) {
        this.productOrderId = productOrderId;
    }

    /**
     * @return the materialId
     */
    public int getMaterialId() {
        return materialId;
    }

    /**
     * @param materialId the materialId to set
     */
    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    /**
     * @return the thickness
     */
    public double getThickness() {
        return thickness;
    }

    /**
     * @param thickness the thickness to set
     */
    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

    /**
     * @return the width
     */
    public double getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * @return the circumference
     */
    public double getCircumference() {
        return circumference;
    }

    /**
     * @param circumference the circumference to set
     */
    public void setCircumference(double circumference) {
        this.circumference = circumference;
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

    /**
     * @return the parent
     */
    public ProductionOrder getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(ProductionOrder parent) {
        this.parent = parent;
    }

    @Override
    public void save() {
        ListManager.updateItem(this);
    }
}
