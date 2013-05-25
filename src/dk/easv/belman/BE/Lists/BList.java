package dk.easv.belman.BE.Lists;

//<editor-fold defaultstate="collapsed" desc=" Imports ">
import dk.easv.belman.BE.IEntity;
import static dk.easv.belman.BLL.Serialize.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
//</editor-fold>

/**
 * Belman List. To use it, you should extend this class as in this example:
 * public class ProductOrderList extends BList<ProductOrder>{ }
 *
 * This "List" class will have the basic functions we need on every list.
 *
 * @param <Type> Dynamic class, that extends IEntity by default
 */
public class BList<Type extends IEntity> implements Serializable {
    
    //<editor-fold defaultstate="collapsed" desc=" Global variables ">
    protected ArrayList<Type> list;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Constructor ">
    public BList() {
        list = new ArrayList<>();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Set a new list ">
    /**
     * Setting the stored list. It can be useful, when copying lists.
     *
     * @param list
     */
    public void setList(ArrayList<Type> list) {
        this.list = list;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Get the current list ">
    /**
     * Returns the stored list. In case of need.
     *
     * @return stored list as ArrayList
     */
    public ArrayList<Type> getList() {
        return list;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Save function ">
    /**
     * Saving all list elements.
     */
    public void save() {
        throw new UnsupportedOperationException("You need to create a method in the child Entity");
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Update function ">
    /**
     * Updating all list elements from the database.
     */
    public void update() {
        throw new UnsupportedOperationException("You need to create a method in the child Entity");
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Get a specific element from the list ">
    /**
     * Getting 1 element from the list.
     *
     * @return the element at the specified index.
     */
    public Type get(int i) {
        return list.get(i);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Set a specific element in the list ">
    /**
     * Set 1 specific element in the list
     *
     * @param elem element with the updated values
     */
    public void set(Type elem) {
        int index = -1;

        for (int i = 0; i < size(); ++i) {
            if (list.get(i).getPk() == elem.getPk()) {
                index = i;
            }
        }
        if (index != -1) {
            list.set(index, elem);
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Add a new element to the list ">
    /**
     * Adding a new element to the end of the list.
     *
     * @param elem
     */
    public void add(Type elem) {
        list.add(elem);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Get the size of the list ">
    /**
     * Returns the size of the stored list.
     *
     * @return int size
     */
    public int size() {
        return list.size();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Check if there's an element in the list with a specified id ">
    /**
     * Returns true, if the stored list have this specific item (checks by id)
     *
     * @param id
     * @return
     */
    public boolean hasId(int id) {
        boolean ret = false;
        for (Type t : list) {
            if (t.getPk() == id) {
                ret = true;
            }
        }
        return ret;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Remove a specific element from the list ">
    /**
     * Removes a specific element from the stored list.
     *
     * @param elem
     */
    public void remove(Type elem) {
        int index = -1;

        for (int i = 0; i < size(); ++i) {
            if (list.get(i).getPk() == elem.getPk()) {
                index = i;
            }
        }
        if (index != -1) {
            list.remove(index);
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" "Deep" copy feature ">
    public BList copy() {
        try {
            BList ret;
            serialize(this);
            ret = (BList) deSerialize();
            return ret;
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(BList.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    //</editor-fold>
}
