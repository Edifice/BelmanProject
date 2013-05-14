package dk.easv.belman.BE;

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

    public Item() {
    }

    public Item(int id) {
        this.setPk(id);

        // @TODO get by id
        Item now = new Item();

        this.id = now.id;
        this.productOrderId = now.productOrderId;
        this.materialId = now.materialId;
        this.thickness = now.thickness;
        this.width = now.width;
        this.circumference = now.circumference;
        this.quantity = now.quantity;
        this.done = now.done;
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
}
