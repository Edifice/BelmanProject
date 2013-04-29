package dk.easv.belman.BE;

public class SalesOrder extends IEntity {
    
    private int orderId;
    private String orderDescription;
    private boolean isDone;

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the orderId
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the orderDescription
     */
    public String getOrderDescription() {
        return orderDescription;
    }

    /**
     * @param orderDescription the orderDescription to set
     */
    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    /**
     * @return the isDone
     */
    public boolean isDone() {
        return isDone;
    }

    /**
     * @param isDone the isDone to set
     */
    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }
}
