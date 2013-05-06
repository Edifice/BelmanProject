package dk.easv.belman.GUI;

import dk.easv.belman.BE.ProductOrderList;
import dk.easv.belman.BE.SalesOrderList;
import dk.easv.belman.BLL.ListManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

    public static SalesOrderList treeData;
    public static ProductOrderList queueData;
    public static SalesOrderList allOrderData;

    public static void main(String[] args) {

        //Set the look and feel of the program
        //<editor-fold defaultstate="collapsed" desc=" Look and feel settings ">
        com.jtattoo.plaf.acryl.AcrylLookAndFeel.setTheme("Green");
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        treeData = new SalesOrderList();
        queueData = new ProductOrderList();

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
