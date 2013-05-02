package dk.easv.belman.BLL;

import dk.easv.belman.BE.ItemList;
import dk.easv.belman.BE.ProductOrderList;
import dk.easv.belman.BE.SalesOrderList;
import dk.easv.belman.DAL.DBConnection;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListManager {

    DBConnection myConnection;

    public ListManager() {
        try {
            myConnection = DBConnection.getInstance();
        } catch (SQLException ex) {
            Logger.getLogger(ListManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ListManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public SalesOrderList getAllSalesOrder() {
        try {
            return myConnection.getAllSalesOrder();
        } catch (SQLException ex) {
            Logger.getLogger(ListManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ProductOrderList getAllProductOrder() {
        try {
            return myConnection.getAllProductionOrder();
        } catch (SQLException ex) {
            Logger.getLogger(ListManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ProductOrderList getAllProductOrder(int salesOrderId) {
        try {
            return myConnection.getAllProductionOrder(salesOrderId);
        } catch (SQLException ex) {
            Logger.getLogger(ListManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;    
    }
    public ItemList getAllItem() {
        try {
            return myConnection.getAllItem();
        } catch (SQLException ex) {
            Logger.getLogger(ListManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ItemList getAllItems(int productionOrderId) {
        try {
            return myConnection.getAllItem(productionOrderId);
        } catch (SQLException ex) {
            Logger.getLogger(ListManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public SalesOrderList getAll() {
        try {
            return myConnection.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(ListManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
