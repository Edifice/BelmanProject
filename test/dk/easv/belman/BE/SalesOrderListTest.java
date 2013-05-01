/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.easv.belman.BE;

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
    public void testSort() {
        System.out.println("sortByID()");

        SalesOrderList instance = new SalesOrderList();

        SalesOrder order1 = new SalesOrder();
        order1.setId(95432);
        order1.setDescription("3113-04046");
        order1.setDone(false);
        instance.add(order1);

        SalesOrder order2 = new SalesOrder();
        order2.setId(95294);
        order2.setDescription("4113-04001");
        order2.setDone(false);
        instance.add(order2);

        SalesOrder order3 = new SalesOrder();
        order3.setId(95428);
        order3.setDescription("2013-026");
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
}