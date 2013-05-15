package dk.easv.belman.BE;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

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
            for (ProductionOrder po : so.getProductOrderList().getList()) {
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
            for (ProductionOrder po : so.getProductOrderList().getList()) {
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
     * Search the list for 1 item by id and return it.
     *
     * @param id The id of the SalesOrder that we are looking for.
     * @return SalesOrder
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
     * Search the list for 1 item by id and return it.
     *
     * @param id The id of the Item/Sleeve we are looking for.
     * @return Item
     */
    public Item getItemById(int id) {
        for (SalesOrder so : this.getList()) {
            for (ProductionOrder po : so.getProductOrderList().getList()) {
                for (Item sleeve : po.getItemList().getList()) {
                    if (sleeve.getId() == id) {
                        return sleeve;
                    }
                }
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
        for (ProductionOrder po : so.getProductOrderList().getList()) {
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
            for (ProductionOrder po : so.getProductOrderList().getList()) {
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

    /**
     * Search the list for 1 PO and ch
     *
     * @param POdesc
     * @param urgentDays
     * @return boolean isUrgent or not
     */
    public boolean isSleeveIsUrgent(String POdesc, int urgentDays) {
        long oneDay = 1000L * 60 * 60 * 24;
        Date d = new Date();
        long now = d.getTime();

        for (SalesOrder so : this.getList()) {
            for (ProductionOrder po : so.getProductOrderList().getList()) {
                if (po.getDescription().equalsIgnoreCase(POdesc)) {
                    return (so.getDueDate() - (oneDay * urgentDays)) <= now;
                }
            }
        }
        return false;
    }
}
