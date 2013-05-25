package dk.easv.belman.BE;

//<editor-fold defaultstate="collapsed" desc=" Imports ">
import dk.easv.belman.BLL.ListManager;
//</editor-fold>

public class Cut extends IEntity {

    //<editor-fold defaultstate="collapsed" desc=" Global variables ">
    private int id;
    private Item sleeve;
    private StockItem stockItem;
    private Operator operator;
    private long timeSpent;
    private long date;
    private int quantity;
    private double waste;
    private boolean archived;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Cut() ">
    public Cut() {
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" getSleeve() ">
    /**
     * @return the sleeve
     */
    public Item getSleeve() {
        return sleeve;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" setSleeve(Item sleeve) ">
    /**
     * @param sleeve the sleeve to set
     */
    public void setSleeve(Item sleeve) {
        this.sleeve = sleeve;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" getStockItem() ">
    /**
     * @return the stockItem
     */
    public StockItem getStockItem() {
        return stockItem;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" setStockItem(StockItem stockItem) ">
    /**
     * @param stockItem the stockItem to set
     */
    public void setStockItem(StockItem stockItem) {
        this.stockItem = stockItem;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" getTimeSpent() ">
    /**
     * @return the timeSpent
     */
    public long getTimeSpent() {
        return timeSpent;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" setTimeSpent(long timeSpent) ">
    /**
     * @param timeSpent the timeSpent to set
     */
    public void setTimeSpent(long timeSpent) {
        this.timeSpent = timeSpent;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" getOperator() ">
    /**
     *
     * @return
     */
    public Operator getOperator() {
        return operator;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" setOperator(Operator operator) ">
    /**
     *
     * @param operator
     */
    public void setOperator(Operator operator) {
        this.operator = operator;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" getDate() ">
    /**
     * @return the date
     */
    public long getDate() {
        return date;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" setDate(long date) ">
    /**
     * @param date the date to set
     */
    public void setDate(long date) {
        this.date = date;
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
    
    //<editor-fold defaultstate="collapsed" desc=" getWaste() ">
    /**
     * @return the waste
     */
    public double getWaste() {
        return waste;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" setWaste(double waste) ">
    /**
     * @param waste the waste to set
     */
    public void setWaste(double waste) {
        this.waste = waste;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" isArchived() ">
    /**
     * @return the archived
     */
    public boolean isArchived() {
        return archived;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" setArchived(boolean archived) ">
    /**
     * @param archived the archived to set
     */
    public void setArchived(boolean archived) {
        this.archived = archived;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" save() ">
    @Override
    public void save() {
        if (this.getId() == 0) {
            ListManager.insertCut(this);
        } else {
            ListManager.updateCut(this);
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" recordCut() ">
    /**
     * This method updates the StockItem's length.
     *
     * @param cut The cut that was done, which contains the StockItem and the
     * Sleeve as well.
     * @return stockItem The updated StockItem.
     */
    public Cut recordCut() {
        stockItem.setLength(stockItem.getLength() - (this.getQuantity() * this.getSleeve().getCircumference()));
        stockItem.save();
        return this;
    }
    //</editor-fold>
}
