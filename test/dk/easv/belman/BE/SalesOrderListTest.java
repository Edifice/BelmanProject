/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.easv.belman.BE;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author AntalJános
 */
public class SalesOrderListTest {

    public SalesOrderListTest() {
    }

    /**
     * Test of add method, of class SalesOrderList.
     */
    @Test
    public void testAdd() {
        System.out.println("add(Type elem)");

        SalesOrderList instance = new SalesOrderList();

        SalesOrder order1 = new SalesOrder();
        order1.setId(95428);
        order1.setDescription("2013-026");
        order1.setDone(false);
        instance.add(order1);

        assertEquals(1, instance.size());
        assertEquals(order1, instance.get(0));

        SalesOrder order2 = new SalesOrder();
        order2.setId(95432);
        order2.setDescription("3113-04046");
        order2.setDone(false);
        instance.add(order2);

        assertEquals(2, instance.size());
        assertEquals(order2, instance.get(1));
        assertNotSame(order2, instance.get(0));

        System.out.println("add(Type elem) - done!");
    }

    /**
     * Test of add method, of class SalesOrderList.
     */
    @Test
    public void testAddTo() {
        System.out.println("add(int i, Type elem)");

        SalesOrderList instance = new SalesOrderList();

        SalesOrder order1 = new SalesOrder();
        order1.setId(95428);
        order1.setDescription("2013-026");
        order1.setDone(false);
        instance.add(0, order1);

        assertEquals(1, instance.size());
        assertEquals(order1, instance.get(0));

        SalesOrder order2 = new SalesOrder();
        order2.setId(95432);
        order2.setDescription("3113-04046");
        order2.setDone(false);
        instance.add(0, order2);

        assertEquals(2, instance.size());
        assertEquals(order2, instance.get(0));
        assertNotSame(order2, instance.get(1));

        assertEquals(order1, instance.get(1));
        assertNotSame(order1, instance.get(0));

        System.out.println("add(int i, Type elem) - done!");
    }

    /**
     * Test of sort method, of class SalesOrderList.
     */
    @Test
    public void testSortByID() {
        System.out.println("sortByID()");

        SalesOrderList instance = new SalesOrderList();

        SalesOrder order1 = new SalesOrder();
        order1.setId(72699);
        order1.setDescription("9710-05021");
        Date date = null;
        String dateStr = "2013-03-26 00:00:00.000";
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            date = formatter.parse(dateStr);
        } catch (ParseException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
        order1.setDueDate(date.getTime());
        order1.setDone(false);
        instance.add(order1);

        SalesOrder order2 = new SalesOrder();
        order2.setId(64727);
        order2.setDescription("4710-11003");
        Date date2 = null;
        String dateStr2 = "2013-03-15 00:00:00.000";
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            date2 = formatter.parse(dateStr2);
        } catch (ParseException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
        order2.setDueDate(date2.getTime());
        order2.setDone(false);
        instance.add(order2);

        SalesOrder order3 = new SalesOrder();
        order3.setId(69634);
        order3.setDescription("4911-02125");
        Date date3 = null;
        String dateStr3 = "2013-04-12 00:00:00.000";
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            date3 = formatter.parse(dateStr3);
        } catch (ParseException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
        order3.setDueDate(date3.getTime());
        order3.setDone(false);
        instance.add(order3);

        // Before sorting
        assertEquals(3, instance.size());
        assertEquals(order1, instance.get(0));
        assertNotSame(order1, instance.get(1));
        assertNotSame(order1, instance.get(2));
        assertEquals(order2, instance.get(1));
        assertNotSame(order2, instance.get(0));
        assertNotSame(order2, instance.get(2));
        assertEquals(order3, instance.get(2));
        assertNotSame(order3, instance.get(0));
        assertNotSame(order3, instance.get(1));

        // Sort
        instance.sortByID();

        // After sorting - it should be the opposite
        assertEquals(3, instance.size());
        assertEquals(order1, instance.get(2));
        assertNotSame(order1, instance.get(0));
        assertNotSame(order1, instance.get(1));
        assertEquals(order2, instance.get(0));
        assertNotSame(order2, instance.get(1));
        assertNotSame(order2, instance.get(2));
        assertEquals(order3, instance.get(1));
        assertNotSame(order3, instance.get(0));
        assertNotSame(order3, instance.get(2));

        System.out.println("sortByID() - done!");
    }
    
     /**
     * Test of sort method, of class SalesOrderList.
     */
    @Test
    public void testSortByTime() {
        System.out.println("sortByDueDate()");

        SalesOrderList instance = new SalesOrderList();

        SalesOrder order1 = new SalesOrder();
        order1.setId(64727);
        order1.setDescription("9710-05021");
        Date date = null;
        String dateStr = "2013-03-26 00:00:00.000";
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            date = formatter.parse(dateStr);
        } catch (ParseException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
        order1.setDueDate(date.getTime());
        order1.setDone(false);
        instance.add(order1);

        SalesOrder order2 = new SalesOrder();
        order2.setId(72699);
        order2.setDescription("4911-02125");
        Date date2 = null;
        String dateStr2 = "2013-04-12 00:00:00.000";
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            date2 = formatter.parse(dateStr2);
        } catch (ParseException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
        order2.setDueDate(date2.getTime());
        order2.setDone(false);
        instance.add(order2);
        
        SalesOrder order3 = new SalesOrder();
        order3.setId(69634);
        order3.setDescription("4710-11003");
        Date date3 = null;
        String dateStr3 = "2013-03-15 00:00:00.000";
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            date3 = formatter.parse(dateStr3);
        } catch (ParseException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
        order3.setDueDate(date3.getTime());
        order3.setDone(false);
        instance.add(order3);

        // Before sorting
        assertEquals(3, instance.size());
        assertEquals(order1, instance.get(0));
        assertNotSame(order1, instance.get(1));
        assertNotSame(order1, instance.get(2));
        assertEquals(order2, instance.get(1));
        assertNotSame(order2, instance.get(0));
        assertNotSame(order2, instance.get(2));
        assertEquals(order3, instance.get(2));
        assertNotSame(order3, instance.get(0));
        assertNotSame(order3, instance.get(1));

        // Sort
        instance.sortByDate();

        // After sorting - it should be the opposite
        assertEquals(3, instance.size());
        assertEquals(order1, instance.get(1));
        assertNotSame(order1, instance.get(0));
        assertNotSame(order1, instance.get(2));
        assertEquals(order2, instance.get(2));
        assertNotSame(order2, instance.get(0));
        assertNotSame(order2, instance.get(1));
        assertEquals(order3, instance.get(0));
        assertNotSame(order3, instance.get(1));
        assertNotSame(order3, instance.get(2));

        System.out.println("sortByDueDate() - done!");
    }
}