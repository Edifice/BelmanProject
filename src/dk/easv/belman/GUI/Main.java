package dk.easv.belman.GUI;

import dk.easv.belman.BE.ProductOrderList;
import dk.easv.belman.BE.SalesOrderList;
import dk.easv.belman.BLL.ListManager;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

    public static SalesOrderList treeData;
    public static ProductOrderList queueData;
    public static SalesOrderList allOrderData;
    private static final int SCHEDULER_PERIOD = 10; // minutes

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
        final ListManager lists = new ListManager();
        allOrderData = lists.getAll();

        //Program starts from here
        final MainGui gui = new MainGui();

        gui.setExtendedState(MainGui.MAXIMIZED_BOTH);
        gui.getSpnlWest().setDividerLocation(gui.getHeight());
        gui.setVisible(true);

        Runnable scheduledTask;
        scheduledTask = new Runnable() {
            @Override
            public void run() {
                allOrderData = lists.getAll();
                gui.scheduledUpdate(true);
            }
        };

        ScheduledExecutorService scheduler;
        scheduler = Executors.newScheduledThreadPool(1);
        //scheduler.scheduleAtFixedRate(scheduledTask, SCHEDULER_PERIOD, SCHEDULER_PERIOD, TimeUnit.MINUTES);
        scheduler.scheduleAtFixedRate(scheduledTask, 5, 5, TimeUnit.SECONDS); // for test
    }
}
