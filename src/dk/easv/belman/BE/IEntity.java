package dk.easv.belman.BE;

//<editor-fold defaultstate="collapsed" desc=" Imports ">
import java.io.Serializable;
//</editor-fold>

/**
 * Main entity, what we are extending to create our framework entities. This
 * have the basic functionality for our entities.
 */
public class IEntity implements Serializable {

    /**
     * Primary key of the Entity.
     */
    private int pk = 0;

    public IEntity() {
    }

    public IEntity(int pk) {
        IEntity now = new IEntity();
        now.pk = pk;
        now.update();
    }

    /**
     * Saves this entity to the database. And after saving it refreshes it.
     */
    public void save() {
        //@TODO 
        this.update();
        throw new UnsupportedOperationException("Not implemented method call");
    }

    /**
     * Refreshes the Entity from the DB by primary key.
     */
    public void update() {
        //@TODO
        throw new UnsupportedOperationException("Not implemented method call");
    }

    /**
     * Changes the Entity to another one.
     *
     * @param indexes
     */
    public void selectByPk(int index) {
        //@TODO
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
