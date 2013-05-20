package dk.easv.belman.BLL;

//<editor-fold defaultstate="collapsed" desc=" Imports ">
import dk.easv.belman.BE.Cut;
import dk.easv.belman.BE.Lists.CutList;
import dk.easv.belman.BE.Item;
import dk.easv.belman.BE.Lists.ItemList;
import dk.easv.belman.BE.Lists.OperatorList;
import dk.easv.belman.BE.ProductionOrder;
import dk.easv.belman.BE.Lists.ProductionOrderList;
import dk.easv.belman.BE.SalesOrder;
import dk.easv.belman.BE.Lists.SalesOrderList;
import dk.easv.belman.BE.StockItem;
import dk.easv.belman.BE.Lists.StockItemList;
import dk.easv.belman.DAL.DataHandler;
import dk.easv.belman.GUI.Main;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//</editor-fold>

public class ListManager {

    private static DataHandler handler; // DAL object.

    /**
     * Checks if the given Product order is urgent or not.
     *
     * @param string Product Order description
     * @return
     */
    public static int isUrgent(String description) {
        return Main.allOrderData.isSleeveIsUrgent(description, Main.URGENT_DAYS);
    }

    /**
     * This method returns a list of all sales orders.
     *
     * @return a SalesOrderList with all the SalesOrders, ProductionOrders and
     * Items.
     */
    public static SalesOrderList getAllSO() {
        try {
            handler = new DataHandler();
            return handler.getAllSO();
        } catch (SQLException | FileNotFoundException ex) {
            Logger.getLogger(ListManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * This method returns all the stock items.
     *
     * @return a StockItemList with all the StockItems.
     */
    public static StockItemList getAllSI() {
        try {
            handler = new DataHandler();
            return handler.getAllSI();
        } catch (SQLException | FileNotFoundException ex) {
            Logger.getLogger(ListManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * This method returns all the cuts that was executed before, with the Item,
     * StockItem and Operator connected to that given cut.
     *
     * @return CutList A list of all cuts.
     */
    public static CutList getAllCuts() {
        try {
            handler = new DataHandler();
            return handler.getAllCuts();
        } catch (SQLException | FileNotFoundException ex) {
            Logger.getLogger(ListManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    /**
     * This method returns all the Operators in an OperatorList.
     *
     * @return OperatorList A list of all operators.
     */
    public static OperatorList getAllOP() {
        try {
            handler = new DataHandler();
            return handler.getAllOP();
        } catch (SQLException | FileNotFoundException ex) {
            Logger.getLogger(ListManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * This method updates a selected Item/Sleeve.
     *
     * @param sleeve The selected item.
     */
    public static void updateItem(Item sleeve) {
        try {
            handler = new DataHandler();
            handler.updateItem(sleeve);
        } catch (SQLException | FileNotFoundException ex) {
            Logger.getLogger(ListManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method inserts a new cut into the database table ItemStock, with the
     * Sleeve id, StockItem id, Operator id, time spent and the time of the cut.
     *
     * @param cut The cut entity that needs to be inserted.
     */
    public static void insertCut(Cut cut) {
        try {
            handler = new DataHandler();
            handler.insertCut(cut);
        } catch (SQLException | FileNotFoundException ex) {
            Logger.getLogger(ListManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @TODO JavaDoc
     * @param stockItem
     */
    public static void updateStock(StockItem stockItem) {
        try {
            handler = new DataHandler();
            handler.updateStock(stockItem);
        } catch (SQLException | FileNotFoundException ex) {
            Logger.getLogger(ListManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ItemList searchForSleeve(String search) {
        if (search.isEmpty()) {
            return Main.allOrderData.getItemList().filterByDone(false);
        } else {
            SalesOrderList sol = new SalesOrderList();

            for (SalesOrder s : Main.allOrderData.getList()) {
                if (s.getDescription().contains(search) || String.valueOf(s.getId()).contains(search)) {
                    if (!sol.hasId(s.getId())) {
                        sol.add(s);
                    }
                }
                for (ProductionOrder p : s.getProductOrderList().getList()) {
                    if (p.getDescription().contains(search) || String.valueOf(p.getId()).contains(search)) {
                        if (!sol.hasId(s.getId())) {
                            sol.add(s);
                        }
                    }
                }
            }
            return sol.getItemList();
        }
    }

    public static void updateCut(Cut cut) {
        try {
            handler = new DataHandler();
            handler.updateCut(cut);
        } catch (SQLException | FileNotFoundException ex) {
            Logger.getLogger(ListManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
