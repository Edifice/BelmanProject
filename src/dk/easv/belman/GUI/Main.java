package dk.easv.belman.GUI;

import dk.easv.belman.BE.ProductOrderList;
import dk.easv.belman.BE.SalesOrderList;
import dk.easv.belman.BLL.ListManager;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

    public static SalesOrderList treeData;
    public static ProductOrderList queueData;
    public static SalesOrderList allOrderData;

    public Main() {
        treeData = new SalesOrderList();
        queueData = new ProductOrderList();
        
        //allOrderData = new SalesOrderList();

    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        
        //Set the look and feel of the program
        com.jtattoo.plaf.acryl.AcrylLookAndFeel.setTheme("Green");
        UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
        
        //Creates SalesOrderList with all SalesOrderLists in it
        ListManager lists = new ListManager();
        allOrderData = lists.getAll();
        
        //Program starts from here
        MainGui gui = new MainGui();
        
       

        gui.setExtendedState(MainGui.MAXIMIZED_BOTH);
        gui.getSpnlWest().setDividerLocation(gui.getHeight());
        gui.setVisible(true);
    }
}
