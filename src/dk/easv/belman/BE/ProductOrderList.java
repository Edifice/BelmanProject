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

        for (ProductOrder po : this.getList()) {
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
     * @param id
     * @return
     */
    public ProductOrder getById(int id) {
        for (ProductOrder po : this.getList()) {
            if (po.getId() == id) {
                return po;
            }
        }
        return null;
    }
    
    @Override
    public void add(ProductOrder po){
        for(Item it : po.getItemList().getList()){
            it.setProductOrderId(po.getId());
        }
        list.add(po);
    }
}
