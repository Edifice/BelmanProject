package dk.easv.belman.BE;

import java.util.Collections;
import java.util.Comparator;

public class ProductOrderList extends BList<ProductOrder> {

    public ProductOrderList() {
    }
    
    /**
     * This is where the sorting by ID in an ascending order happens.
     */
    private static Comparator<ProductOrder> COMPARE_BY_ID = new Comparator<ProductOrder>() {
        @Override
        public int compare(ProductOrder o1, ProductOrder o2) {
            int codeDifference = o1.getId() - o2.getId();
            return codeDifference;
        }
    };
    
    /**
     * This is where the sorting by due date in an ascending order happens.
     */
    private static Comparator<ProductOrder> COMPARE_BY_DATE = new Comparator<ProductOrder>() {
        @Override
        public int compare(ProductOrder o1, ProductOrder o2) {
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
     * Basic sort by ID in ascending order.
     */
    public void sortByDate() {
        Collections.sort(this.getList(), COMPARE_BY_DATE);
    }
}
