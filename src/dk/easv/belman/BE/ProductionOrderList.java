package dk.easv.belman.BE;

//<editor-fold defaultstate="collapsed" desc=" Imports ">
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
//</editor-fold>

public class ProductionOrderList extends BList<ProductionOrder> {

    private SalesOrder parent; // The parent entity.

    public ProductionOrderList() {
    }

    public ProductionOrderList(SalesOrder parent) {
        this.parent = parent;
    }
    
    /**
     * This is where the sorting by ID in an ascending order happens.
     */
    private static Comparator<ProductionOrder> COMPARE_BY_ID = new Comparator<ProductionOrder>() {
        @Override
        public int compare(ProductionOrder o1, ProductionOrder o2) {
            int codeDifference = o1.getId() - o2.getId();
            return codeDifference;
        }
    };

    /**
     * Basic sort by ID in ascending order.
     */
    public void sortByID() {
        Collections.sort(this.getList(), COMPARE_BY_ID);
    }

    /**
     * Checks if have Item with the given ID.
     *
     * @param id
     * @return
     */
    public boolean hasItem(int id) {
        boolean ret = false;

        for (ProductionOrder po : this.getList()) {
            for (Item item : po.getItemList().getList()) {
                if (item.getId() == id) {
                    ret = true;
                }
            }
        }

        return ret;
    }

    /**
     * Search the list for 1 item by id
     *
     * @param id
     * @return
     */
    public ProductionOrder getById(int id) {
        for (ProductionOrder po : this.getList()) {
            if (po.getId() == id) {
                return po;
            }
        }
        return null;
    }

    @Override
    public void add(ProductionOrder po) {
        for (Item it : po.getItemList().getList()) {
            it.setProductOrderId(po.getId());
            it.setParent(po);
        }
        list.add(po);
    }

    /**
     * @TODO JavaDoc
     * @return 
     */
    public ProductionOrderList filterIsDone() {
        ProductionOrderList pol = (ProductionOrderList) this.copy();
        for (Iterator<ProductionOrder> it = new ArrayList<>(pol.getList()).iterator(); it.hasNext();) {
            ProductionOrder po = it.next();
            boolean delete = false;
            for (Iterator<Item> it2 = new ArrayList<>(po.getItemList().getList()).iterator(); it2.hasNext();) {
                Item item = it2.next();
                if (item.isDone()) {
                    delete = true;
                }
            }
            if (delete) {
                pol.remove(po);
            }
        }
        return pol;
    }
}
