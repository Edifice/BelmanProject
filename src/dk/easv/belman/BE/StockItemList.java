package dk.easv.belman.BE;

import java.util.Collections;
import java.util.Comparator;

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
}
