package dk.easv.belman.BE.Lists;

//<editor-fold defaultstate="collapsed" desc=" Imports ">
import dk.easv.belman.BE.Item;
import dk.easv.belman.BE.ProductionOrder;
import dk.easv.belman.BE.SalesOrder;
import dk.easv.belman.BE.StockItem;
import dk.easv.belman.BLL.ListManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
//</editor-fold>

public class SalesOrderList extends BList<SalesOrder> {

    //<editor-fold defaultstate="collapsed" desc=" SalesOrderList() ">
    public SalesOrderList() {
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Comparator by id used for sorting inside the list ">
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
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Comparator by due-date used for sorting inside the list ">

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
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" sortByID() ">
    /**
     * Basic sort by ID in ascending order.
     */
    public void sortByID() {
        Collections.sort(this.getList(), COMPARE_BY_ID);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" sortByDate() ">
    /**
     * Basic sort by ID in ascending order.
     */
    public void sortByDate() {
        Collections.sort(this.getList(), COMPARE_BY_DATE);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" hasPO(int id) ">
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
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" hasItem(int id) ">
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
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" getById(int id) ">
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
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" getItemById(int id) ">
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
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" getIndex(SalesOrder so) ">
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
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" add(SalesOrder so) ">
    @Override
    public void add(SalesOrder so) {
        for (ProductionOrder po : so.getProductOrderList().getList()) {
            po.setSalesOrderId(so.getId());
            po.setParent(so);
        }
        list.add(so);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" removeItem(Item item) ">
    /**
     * Removes an item from the list's itemlist and removes all unnecessary.
     *
     * @param item Item
     * @return 0 if nothing was deleted, 1 if item was deleted, 2 if PO, 3 if SO
     */
    public int removeItem(Item item) {
        for (SalesOrder so : ((SalesOrderList) this.copy()).getList()) {
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
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" isSleeveIsUrgent(String POdesc, int urgentDays) ">
    /**
     * Search the list for 1 PO and ch
     *
     * @param POdesc
     * @param urgentDays
     * @return int -1 -> dueDate is in the past; 0 -> not urgent; 1 -> urgent
     */
    public int isSleeveIsUrgent(String POdesc, int urgentDays) {
        if (POdesc == null) {
            System.out.println("POdesc is null");
            return 0;
        }
        long oneDay = 1000L * 60 * 60 * 24;
        Date d = new Date();
        long now = d.getTime();

        for (SalesOrder so : this.getList()) {
            for (ProductionOrder po : so.getProductOrderList().getList()) {
                if (po != null) {
                    if (po.getDescription() != null) {
                        if (po.getDescription().equalsIgnoreCase(POdesc)) {
                            if (so.getDueDate() <= (now - oneDay)) {
                                return -1;
                            }
                            return ((so.getDueDate() - (oneDay * urgentDays)) <= now) ? 1 : 0;
                        }
                    } else {
                        System.out.println("PO description is null - " + so.getId());
                    }
                } else {
                    System.out.println("PO is null");
                }
            }
        }
        return 0;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" filterByStockItem(StockItem si) ">
    /**
     * This method filters a SalesOrderList by a selected StockItem and checks
     * for the Items/Sleeves that have the SAME MaterialID, SAME Thickness,
     * SMALLER or the SAME Width, and SMALLER or the SAME Circumference.
     *
     * @param sList The SalesOrderList that need to be filtered.
     * @param stockItem the StockItem for reference.
     *
     * @return CURRENTLY An ItemList with the filtered Items.
     */
    public ItemList filterByStockItem(StockItem si) {
        ItemList resList = new ItemList();

        for (Item sleeve : this.getItemList().getList()) {
            if (si.getMaterialId() == sleeve.getMaterialId() // Check for material id.
                    && si.getThickness() == sleeve.getThickness() // Check for thickness.
                    && sleeve.getWidth() <= si.getWidth() // Check for width.
                    && sleeve.getCircumference() <= si.getLength()) { // Check for circumference.
                resList.add(sleeve);
            }
        }

        return resList;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" getItemList() ">
    public ItemList getItemList() {
        ItemList il = new ItemList();
        for (SalesOrder s : this.getList()) {
            for (ProductionOrder p : s.getProductOrderList().getList()) {
                for (Item item : p.getItemList().getList()) {
                    il.add(item);
                }
            }
        }
        return il;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" getProductionOrderList() ">
    /**
     * @TODO JavaDoc
     * @return
     */
    public ProductionOrderList getProductOrderList() {
        ProductionOrderList pList = new ProductionOrderList();

        for (SalesOrder s : this.getList()) {
            for (ProductionOrder p : s.getProductOrderList().getList()) {
                p.setParent(s);
                pList.add(p);
            }
        }
        return pList;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" update() ">
    @Override
    public void update() {
        this.setList(ListManager.getAllSO().getList());
    }
    //</editor-fold>
}
