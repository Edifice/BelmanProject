package dk.easv.belman.BE;

//<editor-fold defaultstate="collapsed" desc=" Imports ">
import java.io.Serializable;
//</editor-fold>

/**
 * Main entity, what we are extending to create our framework entities. This
 * have the basic functionality for our entities.
 */
public class IEntity implements Serializable {

    //<editor-fold defaultstate="collapsed" desc=" Global variables ">
    /**
     * Primary key of the Entity.
     */
    private int pk = 0;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" save() ">
    /**
     * Saves this entity to the database. And after saving it refreshes it.
     */
    public void save() {
        throw new UnsupportedOperationException("You need to create a method in the child Entity");
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" getPk() ">
    /**
     * Getting the primary key of the entity.
     *
     * @return int - primary key
     */
    public int getPk() {
        return pk;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" setPk(int pk) ">
    /**
     * Setting the primary key of the entity.
     *
     * @param pk int - new primary key
     */
    protected void setPk(int pk) {
        this.pk = pk;
    }
    //</editor-fold>
}
