package dk.easv.belman.GUI;

import dk.easv.belman.BE.ProductOrderList;
import dk.easv.belman.BE.SalesOrderList;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

    public static SalesOrderList treeData;
    public static ProductOrderList queueData;

    public Main() {
        treeData = new SalesOrderList();
        queueData = new ProductOrderList();
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        com.jtattoo.plaf.acryl.AcrylLookAndFeel.setTheme("Green", "INSERT YOUR LICENSE KEY HERE", "my company");
        UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
        MainGui gui = new MainGui();

        // select the Look and Feel

        gui.setExtendedState(MainGui.MAXIMIZED_BOTH);
        gui.getSpnlWest().setDividerLocation(gui.getHeight() - 40);
        gui.setVisible(true);
    }
}
