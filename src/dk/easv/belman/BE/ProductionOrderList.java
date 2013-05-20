package dk.easv.belman.BE;

//<editor-fold defaultstate="collapsed" desc=" Imports ">
import dk.easv.belman.BLL.ListManager;
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
            for (Item item : po.getItemList().getList()) {
                if (!item.isDone()) {
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
