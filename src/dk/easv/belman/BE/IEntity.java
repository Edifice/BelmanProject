package dk.easv.belman.BE;

public class IEntity {

    /**
     * Primary key of the Entity.
     */
    private int pk = 0;
    
    public IEntity(){
        
    }
    
    public IEntity(int pk){
        IEntity now = new IEntity();
        now.pk = pk;
        now.update();
    }

    public void save() {
        throw new UnsupportedOperationException("Not implemented method call");
    }

    public void update() {
        //@TODO set pk when getting data!
        throw new UnsupportedOperationException("Not implemented method call");
    }

    /**
     * Getting the primary key of the entity.
     *
     * @return int - primary key
     */
    public int getPk() {
        return pk;
    }

    /**
     * Setting the primary key of the entity.
     *
     * @param pk int - new primary key
     */
    protected void setPk(int pk) {
        this.pk = pk;
    }
}
