/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.easv.belman.BE;

import dk.easv.belman.BE.SalesOrder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dani
 */
public class SalesOrderTest {

    public SalesOrderTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Testing class variables.
     */
    @Test
    public void testClass() {
        SalesOrder order = new SalesOrder();

        assertNull(order.getDescription());
        assertEquals(0, order.getId());

        order.setDescription("test");
        order.setDone(true);
        order.setId(1);
        
        assertNotNull(order.getDescription());
        assertEquals("test", order.getDescription());
        assertEquals(1, order.getId());
        assertTrue(order.isDone());

        order.save();
        
        SalesOrder order2 = new SalesOrder(1);
        
        assertNotNull(order2.getDescription());
        assertEquals("test", order2.getDescription());
        assertEquals(1, order2.getId());
        assertTrue(order2.isDone());
    }
}