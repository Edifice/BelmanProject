/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.easv.belman.DAL;

import dk.easv.belman.BE.Item;
import dk.easv.belman.BE.ItemList;
import dk.easv.belman.BE.ProductOrder;
import dk.easv.belman.BE.ProductOrderList;
import dk.easv.belman.BE.SalesOrder;
import dk.easv.belman.BE.SalesOrderList;
import dk.easv.belman.DAL.DBConnection;
import java.security.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        System.out.println("Testing getInstance()");

        DBConnection expResult = DBConnection.getInstance();
        DBConnection result = DBConnection.getInstance();

        assertEquals(expResult, result);

        expResult = null;
        expResult = DBConnection.getInstance();
        assertEquals(expResult, result);

        result = null;
        result = DBConnection.getInstance();
        assertEquals(expResult, result);

        System.out.println("Testing getInstance() - Done!");
    }

    /**
     * Test of getAllSalesOrder method, of class DBConnection.
     */
    @Test
    public void testGetAllSalesOrder() throws Exception {
        System.out.println("Testing getAllSalesOrder()");

        DBConnection instance = DBConnection.getInstance();

        SalesOrderList expResult = new SalesOrderList();
        SalesOrder ord = new SalesOrder();
        ord.setId(64727);
        ord.setDescription("9710-05021");
        Date date = null;
        String dateStr = "2013-03-26 00:00:00.000";
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            date = formatter.parse(dateStr);
        } catch (ParseException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
        ord.setDueDate(date.getTime());
        ord.setDone(false);
        expResult.add(ord);

        SalesOrderList result = instance.getAllSalesOrder();

        assertEquals(expResult.get(0).getId(), result.get(0).getId());
        assertEquals(expResult.get(0).getDescription(), result.get(0).getDescription());
        assertEquals(expResult.get(0).getDueDate(), result.get(0).getDueDate());
        assertEquals(expResult.get(0).isDone(), result.get(0).isDone());

        SalesOrder ord2 = new SalesOrder();
        ord2.setId(69634);
        ord2.setDescription("4710-11003");
        Date date2 = null;
        String dateStr2 = "2013-03-15 00:00:00.000";
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            date2 = formatter.parse(dateStr2);
        } catch (ParseException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
        ord2.setDueDate(date2.getTime());
        ord2.setDone(false);
        expResult.add(ord2);

        assertEquals(expResult.get(1).getId(), result.get(1).getId());
        assertEquals(expResult.get(1).getDescription(), result.get(1).getDescription());
        assertEquals(expResult.get(1).getDueDate(), result.get(1).getDueDate());
        assertEquals(expResult.get(1).isDone(), result.get(1).isDone());

        System.out.println("Testing getAllSalesOrder() - Done!");
    }

    /**
     * Test of getAllProductionOrder method, of class DBConnection.
     */
    @Test
    public void testGetAllProductionOrder() throws Exception {
        System.out.println("Testing getAllProductionOrder()");

        DBConnection instance = DBConnection.getInstance();

        ProductOrderList expResult = new ProductOrderList();
        ProductOrder ord = new ProductOrder();
        ord.setId(188514);
        ord.setDescription("4411-09002-070-0");
        ord.setDone(false);
        ord.setSalesOrderId(78549);
        expResult.add(ord);

        ProductOrderList result = instance.getAllProductionOrder();

        assertEquals(expResult.get(0).getId(), result.get(0).getId());
        assertEquals(expResult.get(0).getDescription(), result.get(0).getDescription());
        assertEquals(expResult.get(0).isDone(), result.get(0).isDone());
        assertEquals(expResult.get(0).getSalesOrderId(), result.get(0).getSalesOrderId());

        ProductOrder ord2 = new ProductOrder();
        ord2.setId(196030);
        ord2.setDescription("9710-05021-010-1");
        ord2.setDone(false);
        ord2.setSalesOrderId(64727);
        expResult.add(ord2);

        ProductOrder ord3 = new ProductOrder();
        ord3.setId(204523);
        ord3.setDescription("4512-04005-010-0");
        ord3.setDone(false);
        ord3.setSalesOrderId(85045);
        expResult.add(ord3);

        assertEquals(expResult.get(2).getId(), result.get(2).getId());
        assertEquals(expResult.get(2).getDescription(), result.get(2).getDescription());
        assertEquals(expResult.get(2).isDone(), result.get(2).isDone());
        assertEquals(expResult.get(2).getSalesOrderId(), result.get(2).getSalesOrderId());

        System.out.println("Testing getAllProductionOrder() - Done!");
    }

    /**
     * Test of getAllProductionOrder method, of class DBConnection.
     */
    @Test
    public void testGetAllProductionOrderBySalesOrder() throws Exception {
        System.out.println("Testing getAllProductionOrder(int salesOrder)");

        DBConnection instance = DBConnection.getInstance();

        int salesOrder = 95428;

        ProductOrderList expResult = new ProductOrderList();
        ProductOrder ord = new ProductOrder();
        ord.setId(228955);
        ord.setDescription("2013-026-010-0");
        ord.setDone(false);
        ord.setSalesOrderId(95428);
        expResult.add(ord);

        ProductOrderList result = instance.getAllProductionOrder(salesOrder);

        assertEquals(expResult.get(0).getId(), result.get(0).getId());
        assertEquals(expResult.get(0).getDescription(), result.get(0).getDescription());
        assertEquals(expResult.get(0).isDone(), result.get(0).isDone());
        assertEquals(expResult.get(0).getSalesOrderId(), result.get(0).getSalesOrderId());

        ProductOrder ord2 = new ProductOrder();
        ord2.setId(228956);
        ord2.setDescription("2013-026-020-0");
        ord2.setDone(false);
        ord2.setSalesOrderId(95428);
        expResult.add(ord2);

        assertEquals(expResult.get(1).getId(), result.get(1).getId());
        assertEquals(expResult.get(1).getDescription(), result.get(1).getDescription());
        assertEquals(expResult.get(1).isDone(), result.get(1).isDone());
        assertEquals(expResult.get(1).getSalesOrderId(), result.get(1).getSalesOrderId());

        System.out.println("Testing getAllProductionOrder(int salesOrder) - Done!");
    }

    /**
     * Test of getAllItem method, of class DBConnection.
     */
    @Test
    public void testGetAllItem() throws Exception {
        System.out.println("Testing getAllItems()");

        DBConnection instance = DBConnection.getInstance();

        ItemList expResult = new ItemList();
        Item itm = new Item();
        itm.setId(1);
        itm.setQuantity(2);
        itm.setMaterialId(10);
        itm.setThickness(0.4);
        itm.setWidth(271.4);
        itm.setCircumference(1342.72);
        itm.setDone(false);
        itm.setProductOrderId(225835);
        expResult.add(itm);

        ItemList result = instance.getAllItem();

        assertEquals(expResult.get(0).getId(), result.get(0).getId());
        assertEquals(expResult.get(0).getQuantity(), result.get(0).getQuantity());
        assertEquals(expResult.get(0).isDone(), result.get(0).isDone());
        assertEquals(expResult.get(0).getMaterialId(), result.get(0).getMaterialId());
        assertEquals(expResult.get(0).getThickness(), result.get(0).getThickness(), 0);
        assertEquals(expResult.get(0).getWidth(), result.get(0).getWidth(), 0);
        assertEquals(expResult.get(0).getCircumference(), result.get(0).getCircumference(), 0);
        assertEquals(expResult.get(0).getProductOrderId(), result.get(0).getProductOrderId());

        Item itm2 = new Item();
        itm2.setId(2);
        itm2.setQuantity(69);
        itm2.setMaterialId(10);
        itm2.setThickness(0.5);
        itm2.setWidth(1235.0);
        itm2.setCircumference(2455.15);
        itm2.setDone(false);
        itm2.setProductOrderId(222576);
        expResult.add(itm2);

        Item itm3 = new Item();
        itm3.setId(3);
        itm3.setQuantity(69);
        itm3.setMaterialId(10);
        itm3.setThickness(0.5);
        itm3.setWidth(1235.0);
        itm3.setCircumference(2458.30);
        itm3.setDone(false);
        itm3.setProductOrderId(222576);
        expResult.add(itm3);

        assertEquals(expResult.get(2).getId(), result.get(2).getId());
        assertEquals(expResult.get(2).getQuantity(), result.get(2).getQuantity());
        assertEquals(expResult.get(2).isDone(), result.get(2).isDone());
        assertEquals(expResult.get(2).getMaterialId(), result.get(2).getMaterialId());
        assertEquals(expResult.get(2).getThickness(), result.get(2).getThickness(), 0);
        assertEquals(expResult.get(2).getWidth(), result.get(2).getWidth(), 0);
        assertEquals(expResult.get(2).getCircumference(), result.get(2).getCircumference(), 0);
        assertEquals(expResult.get(2).getProductOrderId(), result.get(2).getProductOrderId());

        System.out.println("Testing getAllItems() - Done!");
    }

    /**
     * Test of getAllItem method, of class DBConnection.
     */
    @Test
    public void testGetAllItemByProductionOrder() throws Exception {
        System.out.println("Testing getAllItems(int productionOrder)");

        DBConnection instance = DBConnection.getInstance();

        int productionOrder = 228956;

        ItemList expResult = new ItemList();
        Item itm = new Item();
        itm.setId(145);
        itm.setQuantity(3);
        itm.setMaterialId(10);
        itm.setThickness(0.4);
        itm.setWidth(347);
        itm.setDone(false);
        itm.setCircumference(280.86);
        itm.setProductOrderId(228956);
        expResult.add(itm);

        ItemList result = instance.getAllItem(productionOrder);

        assertEquals(expResult.get(0).getId(), result.get(0).getId());
        assertEquals(expResult.get(0).getQuantity(), result.get(0).getQuantity());
        assertEquals(expResult.get(0).isDone(), result.get(0).isDone());
        assertEquals(expResult.get(0).getMaterialId(), result.get(0).getMaterialId());
        assertEquals(expResult.get(0).getThickness(), result.get(0).getThickness(), 0);
        assertEquals(expResult.get(0).getWidth(), result.get(0).getWidth(), 0);
        assertEquals(expResult.get(0).getCircumference(), result.get(0).getCircumference(), 0);
        assertEquals(expResult.get(0).getProductOrderId(), result.get(0).getProductOrderId());

        System.out.println("Testing getAllItems(int productionOrder) - Done!");
    }
}