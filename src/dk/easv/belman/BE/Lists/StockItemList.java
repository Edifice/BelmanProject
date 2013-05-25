package dk.easv.belman.BE.Lists;

//<editor-fold defaultstate="collapsed" desc=" Imports ">
import dk.easv.belman.BE.Item;
import dk.easv.belman.BE.ProductionOrder;
import dk.easv.belman.BE.SalesOrder;
import dk.easv.belman.BE.StockItem;
import dk.easv.belman.BLL.ListManager;
import dk.easv.belman.GUI.Main;
import java.util.Collections;
import java.util.Comparator;
//</editor-fold>

public class StockItemList extends BList<StockItem> {

    //<editor-fold defaultstate="collapsed" desc=" StockItemList() ">
    public StockItemList() {
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" getById(int id) ">
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
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" filterBySleeve(Item item) ">
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
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" getOnlyUsable() ">
    /**
     * Returns a StockItemList that contains only StockItems that can be used for cutting and are not done yet.
     * @return StockItemList
     */
    public StockItemList getOnlyUsable() {
        StockItemList sil = new StockItemList();
        for (StockItem si : this.getList()) {
            boolean hasItemToCut = false;
            for (SalesOrder so : Main.allOrderData.getList()) {
                for (ProductionOrder po : so.getProductOrderList().getList()) {
                    for (Item item : po.getItemList().getList()) {
                        if (si.canCut(item) && !item.isDone()) {
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
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" update() ">
    @Override
    public void update() {
        this.setList(ListManager.getAllSI().getList());
    }
    //</editor-fold>
}
