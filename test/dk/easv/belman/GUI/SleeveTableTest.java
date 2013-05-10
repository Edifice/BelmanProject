/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.easv.belman.GUI;

import dk.easv.belman.BE.SalesOrderList;
import dk.easv.belman.BLL.ListManager;
import org.jdesktop.swingx.JXTreeTable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import dk.easv.belman.GUI.SleeveTableModel;

/**
 *
 * @author Martin
 */
public class SleeveTableTest {
    
    public SleeveTableTest() {
    }
    
    @Test
    public void testPopulator() {
    SalesOrderList sol = new ListManager().getAll();
    SleeveTableModel tblModel = new SleeveTableModel(sol);
    
    JXTreeTable table = new JXTreeTable();
    
    
    //assertEquals(sol.getList().get(0).getProductOrderList().getList().get(0).getItemList().getList().get(0), tblModel.getItemByRow(1));
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
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
