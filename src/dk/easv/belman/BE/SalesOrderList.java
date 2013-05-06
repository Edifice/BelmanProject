package dk.easv.belman.BE;

import java.util.Collections;
import java.util.Comparator;

public class SalesOrderList extends BList<SalesOrder> {

    public SalesOrderList() {
    }
    /**
     * This is where the sorting by ID in an ascending order happens.
     */
    private static Comparator<SalesOrder> COMPARE_BY_ID = new Comparator<SalesOrder>() {
        @Override
        public int compare(SalesOrder o1, SalesOrder o2) {
            int codeDifference = o1.getId() - o2.getId();
            return codeDifference;
        }
    };
    /**
     * This is where the sorting by due date in an ascending order happens.
     */
    private static Comparator<SalesOrder> COMPARE_BY_DATE = new Comparator<SalesOrder>() {
        @Override
        public int compare(SalesOrder o1, SalesOrder o2) {
            int codeDifference = Long.compare(o1.getDueDate(), o2.getDueDate());
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
     * Basic sort by ID in ascending order.
     */
    public void sortByDate() {
        Collections.sort(this.getList(), COMPARE_BY_DATE);
    }

    /**
     * Checks if have PO with the given ID.
     *
     * @param id
     * @return
     */
    public boolean hasPO(int id) {
        boolean ret = false;

        for (SalesOrder so : this.getList()) {
            for (ProductOrder po : so.getProductOrderList().getList()) {
                if (po.getId() == id) {
                    ret = true;
                }
            }
        }

        return ret;
    }

    /**
     * Checks if have Item with the given ID.
     *
     * @param id
     * @return
     */
    public boolean hasItem(int id) {
        boolean ret = false;

        for (SalesOrder so : this.getList()) {
            for (ProductOrder po : so.getProductOrderList().getList()) {
                for (Item item : po.getItemList().getList()) {
                    if (item.getId() == id) {
                        ret = true;
                    }
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
    public SalesOrder getById(int id) {
        for (SalesOrder so : this.getList()) {
            if (so.getId() == id) {
                return so;
            }
        }
        return null;
    }

    /**
     * Returns the items index in the stored array
     *
     * @param so
     * @return
     */
    public int getIndex(SalesOrder so) {
        for (int i = 0; i < this.size(); ++i) {
            if (this.get(i).getId() == so.getId()) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public void add(SalesOrder so) {
        for (ProductOrder po : so.getProductOrderList().getList()) {
            po.setSalesOrderId(so.getId());
        }
        list.add(so);
    }

    /**
     * Removes an item from the list's itemlist and removes all unnecessary.
     *
     * @param item Item
     * @return 0 if nothing was deleted, 1 if item was deleted, 2 if PO, 3 if SO
     */
    public int removeItem(Item item) {
        for (SalesOrder so : this.getList()) {
            for (ProductOrder po : so.getProductOrderList().getList()) {
                for (Item i : po.getItemList().getList()) {
                    if (item.getId() == i.getId()) {
                        po.getItemList().remove(i);

                        // if there is no more item in the list, delete the POL.
                        if (po.getItemList().size() == 0) {
                            so.getProductOrderList().remove(po);
                            
                            // if there is no more PO in the SO, then remove it.
                            if (so.getProductOrderList().size() == 0) {
                                this.remove(so);
                                return 3;
                            }
                            return 2;
                        }
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
}
