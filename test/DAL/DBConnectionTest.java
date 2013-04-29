/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import dk.easv.belman.BE.ProductOrder;
import dk.easv.belman.BE.ProductOrderList;
import dk.easv.belman.BE.SalesOrder;
import dk.easv.belman.BE.SalesOrderList;
import dk.easv.belman.DAL.DBConnection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author AntalJános
 */
public class DBConnectionTest {

    public DBConnectionTest() {
    }
    
    /**
     * Test of getInstance method, of class DBConnection.
     */
    @Test
    public void testGetInstance() throws Exception {
        System.out.println("getInstance");
        
        DBConnection expResult = DBConnection.getInstance();
        DBConnection result = DBConnection.getInstance();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getAllSalesOrder method, of class DBConnection.
     */
    @Test
    public void testGetAllSalesOrder() throws Exception {
        System.out.println("getAllSalesOrder");
        
        DBConnection instance = DBConnection.getInstance();
        
        SalesOrderList expResult = new SalesOrderList();
        SalesOrder ord = new SalesOrder();
        ord.setId(95428);
        ord.setDescription("2013-026");
        ord.setDone(false);
        expResult.add(ord);
        
        ProductOrderList result = instance.getAllProductionOrder();
        
        assertEquals(expResult.get(0).getId(), result.get(0).getId());
        assertEquals(expResult.get(0).getDescription(), result.get(0).getDescription());
        assertEquals(expResult.get(0).isDone(), result.get(0).isDone());
    }

    /**
     * Test of getAllProductionOrder method, of class DBConnection.
     */
    @Test
    public void testGetAllProductionOrder() throws Exception {
        System.out.println("getAllProductionOrder");
        
        DBConnection instance = DBConnection.getInstance();
        
        ProductOrderList expResult = new ProductOrderList();
        ProductOrder ord = new ProductOrder();
        ord.setId(228955);
        ord.setDescription("2013-026-010-0");
        ord.setDone(false);
        ord.setSalesOrderId(95428);
        expResult.add(ord);
        
        ProductOrderList result = instance.getAllProductionOrder();
        
        assertEquals(expResult.get(0).getId(), result.get(0).getId());
        assertEquals(expResult.get(0).getDescription(), result.get(0).getDescription());
        assertEquals(expResult.get(0).isDone(), result.get(0).isDone());
        assertEquals(expResult.get(0).getSalesOrderId(), result.get(0).getSalesOrderId());
    }
}