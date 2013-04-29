package BE;

import dk.easv.belman.BE.ProductOrder;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProductOrderTest {

    public ProductOrderTest() {
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
        ProductOrder order = new ProductOrder();
        
        Date now = new Date();
        long time = now.getTime();

        assertNull(order.getDescription());
        assertEquals(0, order.getId());

        order.setId(1);
        order.setSalesOrderId(1);
        order.setDescription("test");
        order.setDueDate(time);
        order.setDone(true);

        assertEquals(1, order.getId());
        assertEquals(1, order.getSalesOrderId());
        assertNotNull(order.getDescription());
        assertEquals("test", order.getDescription());
        assertEquals(time, order.getDueDate());
        assertTrue(order.isDone());

        order.save();

        ProductOrder order2 = new ProductOrder(1);

        assertEquals(1, order2.getId());
        assertEquals(1, order2.getSalesOrderId());
        assertNotNull(order2.getDescription());
        assertEquals("test", order2.getDescription());
        assertEquals(time, order2.getDueDate());
        assertTrue(order2.isDone());
    }
}