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

    protected ArrayList<Type> list;

    public BList() {
        list = new ArrayList<>();
    }

    /**
     * Setting the stored list. It can be useful, when copying lists.
     *
     * @param list
     */
    public void setList(ArrayList<Type> list) {
        this.list = list;
    }

    /**
     * Returns the stored list. In case of need.
     *
     * @return stored list as ArrayList
     */
    public ArrayList<Type> getList() {
        return list;
    }

    /**
     * Saving all list elements.
     */
    public void save() {
        throw new UnsupportedOperationException("You need to create a method in the child Entity");
    }

    /**
     * Updating all list elements from the database.
     */
    public void update() {
        throw new UnsupportedOperationException("You need to create a method in the child Entity");
    }

    /**
     * Getting 1 element from the list.
     *
     * @return the element at the specified index.
     */
    public Type get(int i) {
        return list.get(i);
    }

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

    /**
     * Adding a new element to the end of the list.
     *
     * @param elem
     */
    public void add(Type elem) {
        list.add(elem);
    }

    /**
     * Returns the size of the stored list.
     *
     * @return int size
     */
    public int size() {
        return list.size();
    }

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
}
