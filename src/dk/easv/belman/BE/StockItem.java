package dk.easv.belman.BE;

public class StockItem extends IEntity {

    private int id;
    private String code;
    private int materialId;
    private String materialName;
    private double materialDensity;
    private double length;
    private double width;
    private double thickness;
    private String batchId;
    private double quantity;

    public StockItem() {
    }

    public StockItem(int id) {
        // @TODO get by id
        StockItem now = new StockItem();

        this.id = now.id;
        this.code = now.code;
        this.materialId = now.materialId;
        this.materialName = now.materialName;
        this.materialDensity = now.materialDensity;
        this.length = now.length;
        this.width = now.width;
        this.thickness = now.thickness;
        this.batchId = now.batchId;
        this.quantity = now.quantity;
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
        this.id = id;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
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
     * @return the materialName
     */
    public String getMaterialName() {
        return materialName;
    }

    /**
     * @param materialName the materialName to set
     */
    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    /**
     * @return the lenght
     */
    public double getLength() {
        return length;
    }

    /**
     * @param length the lenght to set
     */
    public void setLength(double length) {
        this.length = length;
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
     * @return the batchId
     */
    public String getBatchId() {
        return batchId;
    }

    /**
     * @param batchId the batchId to set
     */
    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    /**
     * @return the quantity
     */
    public double getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the materialDensity
     */
    public double getMaterialDensity() {
        return materialDensity;
    }

    /**
     * @param materialDensity the materialDensity to set
     */
    public void setMaterialDensity(double materialDensity) {
        this.materialDensity = materialDensity;
    }

    /**
     * This method calculates how many sleeves can be cut from the selected
     * stock item
     *
     * @param stockItem is the selected stock item
     * @param sleeve is the selected sleeve
     * @return the number of cuts that can be done
     */
    public int canCutHowMany(Item sleeve) {
        int amount = 0;
        double availableAmount = this.getLength();
        for (int i = 0; i < sleeve.getQuantity(); i++) {
            if (availableAmount > sleeve.getCircumference()) {
                amount++;
                availableAmount = availableAmount - sleeve.getCircumference();
            }
        }
        return amount;
    }

    /**
     * This method makes sure that a selected sleeve can be cut from a selected
     * stock item
     *
     * @param stockItem is the selected stock item
     * @param sleeve is the selected sleeve
     * @return true if the sleeve can be cut from the stock item, false
     * otherwise
     */
    public boolean canCut(Item sleeve) {
        if (this.getMaterialId() == sleeve.getMaterialId() // Check for material id.
                && this.getThickness() == sleeve.getThickness() // Check for thickness.
                && sleeve.getWidth() <= this.getWidth() // Check for width.
                && sleeve.getCircumference() <= this.getLength()) { // Check for circumference.
            return true;
        } else {
            return false;
        }
    }
}
