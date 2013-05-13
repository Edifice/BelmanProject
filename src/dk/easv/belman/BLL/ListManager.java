package dk.easv.belman.BLL;

import dk.easv.belman.BE.Item;
import dk.easv.belman.BE.ItemList;
import dk.easv.belman.BE.OperatorList;
import dk.easv.belman.BE.ProductOrder;
import dk.easv.belman.BE.ProductOrderList;
import dk.easv.belman.BE.SalesOrder;
import dk.easv.belman.BE.SalesOrderList;
import dk.easv.belman.BE.StockItemList;
import dk.easv.belman.DAL.DataHandler;
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
    public ProductOrderList getProductOrderList(SalesOrderList sList) {
        ProductOrderList list = new ProductOrderList();
        for (SalesOrder s : sList.getList()) {
            for (ProductOrder p : s.getProductOrderList().getList()) {
                list.add(p);
            }
        }
        return list;
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
            for (ProductOrder p : s.getProductOrderList().getList()) {
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
     * Returns a sales order list containing all sales orders which product
     * orders are done
     *
     * @param sList
     * @return a sales order list
     */
    public SalesOrderList getAllDoneSalesOrder(SalesOrderList sList) {
        SalesOrderList sol = new SalesOrderList();
        for (Item item : getItemList(sList).getList()) {
            if (item.isDone()) {
                if (!sol.hasId(item.getSalesOrderId())) {
                    sol.add(sList.getById(item.getSalesOrderId()));
                }
            }
        }
        return sol;
    }

//    @TODO
//    public CutList getAllCuts() {
//        try {
//            return handler.getAllCuts();
//        } catch (SQLException ex) {
//            Logger.getLogger(ListManager.class.getName()).log(Level.SEVERE, null, ex);
//            throw new Exception(ex.getMessage(), ex.getCause());
//        }
//        return null;
//
//    }
    /**
     * @TODO JavaDOC
     * @return
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

    public void updateItem(Item sleeve) {
        try {
            handler.updateItem(sleeve);
        } catch (SQLException ex) {
            Logger.getLogger(ListManager.class.getName()).log(Level.SEVERE, null, ex);
            //            throw new Exception(ex.getMessage(), ex.getCause());
        }
    }
}
