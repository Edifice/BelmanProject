package dk.easv.belman.BE;

//<editor-fold defaultstate="collapsed" desc=" Imports ">
import dk.easv.belman.BLL.ListManager;
//</editor-fold>

public class StockItem extends IEntity {

    //<editor-fold defaultstate="collapsed" desc=" Global variables ">
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
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" StockItem() ">
    public StockItem() {
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
        this.id = id;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" getCode() ">
    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" setCode(String code) ">    
    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
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

    //<editor-fold defaultstate="collapsed" desc=" getMaterialName() "> 
    /**
     * @return the materialName
     */
    public String getMaterialName() {
        return materialName;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" setMaterialName(String materialName) "> 
    /**
     * @param materialName the materialName to set
     */
    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" getLength() "> 
    /**
     * @return the lenght
     */
    public double getLength() {
        return length;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" setLength(double length) "> 
    /**
     * @param length the lenght to set
     */
    public void setLength(double length) {
        this.length = length;
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

    //<editor-fold defaultstate="collapsed" desc=" getBatchId() "> 
    /**
     * @return the batchId
     */
    public String getBatchId() {
        return batchId;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" setBatchId(String batchId) "> 
    /**
     * @param batchId the batchId to set
     */
    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" getQuantity() "> 
    /**
     * @return the quantity
     */
    public double getQuantity() {
        return quantity;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" setQuantity(double quantity) "> 
    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" getMaterialDensity() "> 
    /**
     * @return the materialDensity
     */
    public double getMaterialDensity() {
        return materialDensity;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" setMaterialDensity(double materialDensity) "> 
    /**
     * @param materialDensity the materialDensity to set
     */
    public void setMaterialDensity(double materialDensity) {
        this.materialDensity = materialDensity;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" canCutHowMany(Item sleeve) ">
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
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" canCut(Item sleeve) ">
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
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" update() ">
    public void update() {
        ListManager.updateStock(this);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" save() ">
    @Override
    public void save() {
        ListManager.updateStock(this);
    }
    //</editor-fold>
}
