package dk.easv.belman.BE;

public class Cut extends IEntity {
    private Item sleeve;
    private StockItem stockItem;
    private Operator operator;
    private long timeSpent;
    private long date;
    private int quantity;
    
    public Cut() {   
    }

    public Cut(Item sleeve, StockItem stockItem, Operator operator, long timeSpent, long date, int quantity) {
        this.sleeve = sleeve;
        this.stockItem = stockItem;
        this.operator = operator;
        this.timeSpent = timeSpent;
        this.date = date;
        this.quantity = quantity;
    }

    /**
     * @return the sleeve
     */
    public Item getSleeve() {
        return sleeve;
    }

    /**
     * @param sleeve the sleeve to set
     */
    public void setSleeve(Item sleeve) {
        this.sleeve = sleeve;
    }

    /**
     * @return the stockItem
     */
    public StockItem getStockItem() {
        return stockItem;
    }

    /**
     * @param stockItem the stockItem to set
     */
    public void setStockItem(StockItem stockItem) {
        this.stockItem = stockItem;
    }

    /**
     * @return the timeSpent
     */
    public long getTimeSpent() {
        return timeSpent;
    }

    /**
     * @param timeSpent the timeSpent to set
     */
    public void setTimeSpent(long timeSpent) {
        this.timeSpent = timeSpent;
    }
    
    public Operator getOperator() {
        return operator;
    }
    
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    /**
     * @return the date
     */
    public long getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(long date) {
        this.date = date;
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
