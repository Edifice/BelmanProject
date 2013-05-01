package dk.easv.belman.BE;

import dk.easv.belman.BE.Item;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ItemTest {

    public ItemTest() {
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

    @Test
    public void testModel() {
        Item item = new Item();
        
        item.setId(1);
        item.setMaterialId(1);
        item.setProductOrderId(1);
        item.setQuantity(1);
        item.setThickness(0.5);
        item.setWidth(200.4);
        item.setCircumference(1000.24);
        
        assertEquals(1, item.getId());
        assertEquals(1, item.getMaterialId());
        assertEquals(1, item.getProductOrderId());
        assertEquals(1, item.getQuantity());
        assertEquals(0.5, item.getThickness(), 0.00001);
        assertEquals(200.4, item.getWidth(), 0.00001);
        assertEquals(1000.24, item.getCircumference(), 0.00001);
        
        item.save();
        
        Item item2 = new Item(1);
        
        assertEquals(1, item2.getId());
        assertEquals(1, item2.getMaterialId());
        assertEquals(1, item2.getProductOrderId());
        assertEquals(1, item2.getQuantity());
        assertEquals(0.5, item2.getThickness(), 0.00001);
        assertEquals(200.4, item2.getWidth(), 0.00001);
        assertEquals(1000.24, item2.getCircumference(), 0.00001);
    }
}