package BE;

import dk.easv.belman.BE.Item;
import dk.easv.belman.BE.ItemList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ItemListTest {

    public ItemListTest() {
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
        ItemList list = new ItemList();
        
        Item item = new Item();
        
        item.setId(1);
        item.setMaterialId(1);
        item.setProductOrderId(1);
        item.setQuantity(1);
        item.setThickness(0.5);
        item.setWidth(200.4);
        item.setCircumference(1000.24);
        
        assertEquals(0, list.size());
        list.add(item);
        assertEquals(1, list.size());
        list.save();
        
        ItemList list2 = new ItemList();
        assertEquals(0, list2.size());
        list2.selectAll();
        assertEquals(1, list2.size());
        
        ItemList list3 = new ItemList();
        assertEquals(0, list3.size());
        list3.selectByPk(new int[]{1});
        assertEquals(1, list3.size());
        
    }

}