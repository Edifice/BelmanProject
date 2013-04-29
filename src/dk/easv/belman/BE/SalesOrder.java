package dk.easv.belman.BE;

public class SalesOrder extends IEntity {

    private int id;
    private String description;
    private boolean done;

    public SalesOrder() {
    }

    /**
     * Getting an existing Sales order from DB by id
     *
     * @param pk
     */
    public SalesOrder(int id) {

        // @TODO get by id
        SalesOrder now = new SalesOrder();
        
        this.id = now.id;
        this.description = now.description;
        this.done = now.done;
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
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
}
