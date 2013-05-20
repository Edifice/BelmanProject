package dk.easv.belman.BE;

//<editor-fold defaultstate="collapsed" desc=" Imports ">
import dk.easv.belman.GUI.Main;
import java.util.Collections;
import java.util.Comparator;
//</editor-fold>

public class StockItemList extends BList<StockItem> {

    public StockItemList() {
    }
    /**
     * This is where the sorting by ID in an ascending order happens.
     */
    private static Comparator<StockItem> COMPARE_BY_ID = new Comparator<StockItem>() {
        @Override
        public int compare(StockItem o1, StockItem o2) {
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
     * Search the list for a stock item by id
     *
     * @param id
     * @return
     */
    public StockItem getById(int id) {
        for (StockItem si : this.getList()) {
            if (si.getId() == id) {
                return si;
            }
        }
        return null;
    }

    /**
     * This method filters a StockItemList by a selected Item/Sleeve and checks
     * for the StockItems that have the SAME MaterialID, SAME Thickness, SMALLER
     * or the SAME Width, and SMALLER or the SAME Length.
     *
     * @param sList The StockItemList that need to be filtered.
     * @param item the Item for reference.
     *
     * @return A filtered StockItemList.
     */
    public StockItemList filterBySleeve(Item item) {
        StockItemList ret = new StockItemList();

        for (StockItem s : this.getList()) {
            if (item.getMaterialId() == s.getMaterialId() // Check for material id.
                    && item.getCircumference() <= s.getLength() // Check for length.
                    && item.getThickness() == s.getThickness() // Check for thickness.
                    && item.getWidth() <= s.getWidth()) { // Check for width.
                ret.add(s);
            }
        }
        return ret;
    }

    public StockItemList getOnlyUsable() {
        StockItemList sil = new StockItemList();
        for (StockItem si : this.getList()) {
            boolean hasItemToCut = false;
            for (SalesOrder so : Main.allOrderData.getList()) {
                for (ProductionOrder po : so.getProductOrderList().getList()) {
                    for (Item item : po.getItemList().getList()) {
                        if (si.canCut(item)) {
                            hasItemToCut = true;
                        }
                    }
                }
            }
            if (hasItemToCut) {
                sil.add(si);
            }
        }
        return sil;
    }
}
