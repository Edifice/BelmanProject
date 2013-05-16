package dk.easv.belman.BLL;

import dk.easv.belman.BE.Cut;
import dk.easv.belman.BE.CutList;
import dk.easv.belman.BE.Item;
import dk.easv.belman.BE.ItemList;
import dk.easv.belman.BE.OperatorList;
import dk.easv.belman.BE.ProductionOrder;
import dk.easv.belman.BE.ProductionOrderList;
import dk.easv.belman.BE.SalesOrder;
import dk.easv.belman.BE.SalesOrderList;
import dk.easv.belman.BE.StockItem;
import dk.easv.belman.BE.StockItemList;
import dk.easv.belman.DAL.DataHandler;
import dk.easv.belman.GUI.Main;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListManager {

    private DataHandler handler; // DAL object.

    public ListManager() {
        try {
            handler = new DataHandler();
        } catch (FileNotFoundException | SQLException ex) {
            Logger.getLogger(ListManager.class.getName()).log(Level.SEVERE, null, ex);
//            throw new Exception(ex.getMessage(), ex.getCause());
        }
    }

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
    public SalesOrderList getAllSO() {
        try {
            return handler.getAllSO();
        } catch (SQLException ex) {
            Logger.getLogger(ListManager.class.getName()).log(Level.SEVERE, null, ex);
//            throw new Exception(ex.getMessage(), ex.getCause());
        }
        return null;
    }

    /**
     * This method returns all the stock items.
     *
     * @return a StockItemList with all the StockItems.
     */
    public StockItemList getAllSI() {
        try {
            return handler.getAllSI();
        } catch (SQLException ex) {
            Logger.getLogger(ListManager.class.getName()).log(Level.SEVERE, null, ex);
//            throw new Exception(ex.getMessage(), ex.getCause());
        }
        return null;
    }

    /**
     * Returns all the Production Orders inside a SalesOrderList.
     *
     * @param sList The SalesOrderList in which we look for production orders.
     * @return A list of all production orders inside that specific
     * SalesOrderList.
     */
    public ProductionOrderList getProductOrderList(SalesOrderList sList) {
        ProductionOrderList list = new ProductionOrderList();
        for (SalesOrder s : sList.getList()) {
            for (ProductionOrder p : s.getProductOrderList().getList()) {
                list.add(p);
            }
        }
        return list;
    }

    /**
     * Gets a given sleeve's product order
     *
     * @param sList The SalesOrderList in which we look for production orders.
     * @param sleeve
     * @return A list of all production orders inside that specific
     * SalesOrderList.
     */
    public ProductionOrder getProductOrder(SalesOrderList sList, Item sleeve) {
        for (SalesOrder s : sList.getList()) {
            for (ProductionOrder p : s.getProductOrderList().getList()) {
                if (p.getId() == sleeve.getProductOrderId()) {
                    return p;
                }
            }
        }
        return null;
    }

    /**
     * Returns a list of all Items from a specific SalesOrderList.
     *
     * @param sList The SalesOrderList from where we want to get the Item list.
     * @return An Item List from a specified SalesOrderList.
     */
    public ItemList getItemList(SalesOrderList sList) {
        ItemList list = new ItemList();
        for (SalesOrder s : sList.getList()) {
            for (ProductionOrder p : s.getProductOrderList().getList()) {
                for (Item item : p.getItemList().getList()) {
                    list.add(item);
                }
            }
        }
        return list;
    }

    /**
     * Returns a sales order list containing all sales orders which product
     * orders are not done
     *
     * @param sList
     * @return a sales order list
     */
    public SalesOrderList getAllSalesOrderNotDone(SalesOrderList sList) {
        SalesOrderList sol = new SalesOrderList();
        for (Item item : getItemList(sList).getList()) {
            if (!item.isDone()) {
                if (!sol.hasId(item.getSalesOrderId())) {
                    sol.add(sList.getById(item.getSalesOrderId()));
                }
            }
        }
        return sol;
    }

    /**
     * This method gets all done production orders. It takes in a sales order
     * list, and loops through each element and gets its production order, then
     * loops through the production orders items, and checks whether they are
     * done or not. We make a local storage for the items, that will contain the
     * production orders not done items, if the lists.size is greater than 0,
     * the production order is not done.
     *
     * @param sList
     * @return a ProductionOrderList containing all done production orders
     */
    public ProductionOrderList getAllDoneProductionOrders(SalesOrderList sList) {
        ProductionOrderList poList = new ProductionOrderList();
        for (ProductionOrder po : getProductOrderList(sList).getList()) {
            ItemList poItems = new ItemList();
            for (Item item : po.getItemList().getList()) {
                if (!item.isDone()) {
                    poItems.add(item);
                }
            }
            if (poItems.size() == 0) {
                poList.add(po);
            }
        }
        return poList;
    }
// @TODO - Need to think about which logic to use
//    /**
//     * Returns a sales order list containing all sales orders which product
//     * orders are done
//     *
//     * @param sList
//     * @return a sales order list
//     */
//    public SalesOrderList getAllDoneSalesOrder(SalesOrderList sList) {
//        SalesOrderList sol = new SalesOrderList();
//        for (SalesOrder s : sList.getList()) {
//            for (ProductionOrder p : s.getProductOrderList().getList()) {
//                boolean isDone = false;
//                for (Item item : p.getItemList().getList()) {
//
//                }
//            }
//        }
//
//        return sol;
//    }

    /**
     * This method gets the remaining cuts of a sleeve
     *
     * @param cutList a list containing the cuts that have been made
     * @param sleeve is the one we check the remainder of
     * @return the amount left to cut for the given sleeve
     */
    public int getRemaningCuts(CutList cutList, Item sleeve) {
        int initialQuantity = sleeve.getQuantity();
//        System.out.println("Initial Quantity: " + initialQuantity);

//        System.out.println("Cuts from that sleeve: " + cutList.size());
        for (Cut cut : cutList.getCutsBySleeve(sleeve).getList()) {
            initialQuantity = initialQuantity - cut.getQuantity();
        }

//        System.out.println("Final Quantity: " + initialQuantity);
        return initialQuantity;

    }

    /**
     * This method returns all the cuts that was executed before, with the Item,
     * StockItem and Operator connected to that given cut.
     *
     * @return CutList A list of all cuts.
     */
    public CutList getAllCuts() {
        try {
            return handler.getAllCuts();
        } catch (SQLException ex) {
            Logger.getLogger(ListManager.class.getName()).log(Level.SEVERE, null, ex);
//            throw new Exception(ex.getMessage(), ex.getCause());
        }
        return null;

    }

    /**
     * This method takes in a SalesOrderList, extracts the Items from it, and
     * only returns the ones that are not done in an ItemList.
     *
     * @param sol
     * @return itemList
     */
    public ItemList getAllItemsNotDone(SalesOrderList sol) {
        ItemList itemList = new ItemList();
        for (Item item : getItemList(sol).getList()) {
            if (!item.isDone()) {
                if (!itemList.hasId(item.getSalesOrderId())) {
                    itemList.add(item);
                }
            }
        }
        return itemList;
    }

    /**
     * This method returns all the Operators in an OperatorList.
     *
     * @return OperatorList A list of all operators.
     */
    public OperatorList getAllOP() {
        try {
            return handler.getAllOP();
        } catch (SQLException ex) {
            Logger.getLogger(ListManager.class.getName()).log(Level.SEVERE, null, ex);
//            throw new Exception(ex.getMessage(), ex.getCause());
        }
        return null;
    }

    /**
     * This method updates a selected Item/Sleeve.
     *
     * @param sleeve The selected item.
     */
    public void updateItem(Item sleeve) {
        try {
            handler.updateItem(sleeve);
        } catch (SQLException ex) {
            Logger.getLogger(ListManager.class.getName()).log(Level.SEVERE, null, ex);
//            throw new Exception(ex.getMessage(), ex.getCause());
        }
    }

    /**
     * This method inserts a new cut into the database table ItemStock, with the
     * Sleeve id, StockItem id, Operator id, time spent and the time of the cut.
     *
     * @param cut The cut entity that needs to be inserted.
     */
    public void insertCut(Cut cut) {
        try {
            handler.insertCut(cut);
        } catch (SQLException ex) {
            Logger.getLogger(ListManager.class.getName()).log(Level.SEVERE, null, ex);
//            throw new Exception(ex.getMessage(), ex.getCause());
        }
    }

    public void updateStock(StockItem stockItem) {
        try {
            handler.updateStock(stockItem);
        } catch (SQLException ex) {
            Logger.getLogger(ListManager.class.getName()).log(Level.SEVERE, null, ex);
//            throw new Exception(ex.getMessage(), ex.getCause());
        }
    }
}
