package dk.easv.belman.BE.Lists;

//<editor-fold defaultstate="collapsed" desc=" Imports ">
import dk.easv.belman.BE.Item;
import dk.easv.belman.BE.ProductionOrder;
import dk.easv.belman.BE.SalesOrder;
import dk.easv.belman.BLL.ListManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
//</editor-fold>

public class ProductionOrderList extends BList<ProductionOrder> {

    //<editor-fold defaultstate="collapsed" desc=" Global variables ">
    private SalesOrder parent; // The parent entity.
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructor ">
    public ProductionOrderList() {
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructor that takes in a SalesOrder as a parent ">
    public ProductionOrderList(SalesOrder parent) {
        this.parent = parent;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Get a ProductionOrder by it's id ">
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
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Add a new ProductionOrder to this list ">
    @Override
    public void add(ProductionOrder po) {
        for (Item it : po.getItemList().getList()) {
            it.setProductOrderId(po.getId());
            it.setParent(po);
        }
        list.add(po);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Filter by the 'done' flag ">
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
    //</editor-fold>
    
}
