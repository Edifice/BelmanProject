package dk.easv.belman.BE;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class EntityRelationTest {

    private Item item1;
    private Item item2;
    private Item item3;
    private Item item4;
    private ProductionOrder po1;
    private ProductionOrder po2;
    private ProductionOrder po3;
    private ProductionOrder po4;
    private ProductionOrder po5;
    private SalesOrder so1;
    private SalesOrder so2;
    private SalesOrder so3;
    private SalesOrderList sol1;

    public EntityRelationTest() {
    }

    @Before
    public void setUp() {

        //Item
        item1 = new Item();
        item1.setId(1);
        item1.setDone(false);
        item1.setMaterialId(1);
        item1.setQuantity(2);
        item1.setThickness(1.5);
        item1.setWidth(21.5);
        
        item2 = new Item();
        item2.setId(2);
        item2.setDone(false);
        item2.setMaterialId(155);
        item2.setQuantity(42);
        item2.setThickness(1.45);
        item2.setWidth(21.55);
        
        item3 = new Item();
        item3.setId(3);
        item3.setDone(false);
        item3.setMaterialId(21);
        item3.setQuantity(21);
        item3.setThickness(17.5);
        item3.setWidth(21.59);
        
        item4 = new Item();
        item4.setId(4);
        item4.setDone(false);
        item4.setMaterialId(8);
        item4.setQuantity(1);
        item4.setThickness(7.5);
        item4.setWidth(2.9);


        //PO
        po1 = new ProductionOrder();
        po1.setDescription("aaa");
        po1.setId(1);

        po2 = new ProductionOrder();
        po2.setDescription("bbb");
        po2.setId(2);

        po3 = new ProductionOrder();
        po3.setDescription("ccc");
        po3.setId(3);

        po4 = new ProductionOrder();
        po4.setDescription("ddd");
        po4.setId(4);

        po5 = new ProductionOrder();
        po5.setDescription("eee");
        po5.setId(5);

        //SO
        so1 = new SalesOrder();
        so1.setId(1);
        so1.setDescription("so1");
        so1.setDone(false);
        so1.setDueDate(1220227200);

        so2 = new SalesOrder();
        so2.setId(2);
        so2.setDescription("so2");
        so2.setDone(false);
        so2.setDueDate(1220124200);

        so3 = new SalesOrder();
        so3.setId(3);
        so3.setDescription("so3");
        so3.setDone(false);
        so3.setDueDate(1220217200);

        //Relations
        ItemList il1 = new ItemList();
        il1.add(item1);
        item1.setParent(po1);
        po1.setItemList(il1);

        ItemList il2 = new ItemList();
        il2.add(item2);
        item2.setParent(po2);
        il2.add(item3);
        item3.setParent(po2);
        po2.setItemList(il2);

        ItemList il3 = new ItemList();
        il3.add(item4);
        item4.setParent(po3);
        po3.setItemList(il3);

        ProductionOrderList pol1 = new ProductionOrderList();
        pol1.add(po1);
        po1.setParent(so1);
        pol1.add(po2);
        po2.setParent(so1);
        so1.setProductOrderList(pol1);

        ProductionOrderList pol2 = new ProductionOrderList();
        pol2.add(po3);
        po3.setParent(so2);
        so2.setProductOrderList(pol2);

        sol1 = new SalesOrderList();
        sol1.add(so2);
    }

    @Test
    public void testSOhasPOs() {
        //the right element is in its parent
        assertEquals("aaa", so1.getProductOrderList().get(0).getDescription());
        // it have its parent's id stored
        assertEquals(1, so1.getProductOrderList().get(1).getSalesOrderId());
    }

    @Test
    public void testPOhasItems() {
        assertEquals(2, po1.getItemList().get(0).getQuantity());
    }

    @Test
    public void testSOhasItems() {
        assertEquals(2, so1.getProductOrderList().get(0).getItemList().get(0).getQuantity());
    }

    @Test
    public void testDeleteItemOfSOL() {
        sol1.removeItem(item4);
        assertEquals(0, sol1.size());
    }
}