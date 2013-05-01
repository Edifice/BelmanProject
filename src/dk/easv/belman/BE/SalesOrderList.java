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
     * Basic sort by ID in ascending order.
     */
    public void sortByID() {
        Collections.sort(this.getList(), COMPARE_BY_ID);
    }
}
