package dk.easv.belman.GUI;

import dk.easv.belman.BE.SalesOrderList;
import dk.easv.belman.BE.StockItemList;
import dk.easv.belman.BLL.ListManager;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

    public static StockItemList allStockData; // A global (static) variable where all the initial stock data is stored right from the startup of the program.
    public static SalesOrderList allOrderData; // A global (static) variable where all the initial order data is stored right from the startup of the program.
    private static final int SCHEDULER_PERIOD = 10; // Scheduler period in minutes.
    private static MainGui gui; // The main UI component.

    public static void main(String[] args) {
        // Set the look and feel of the program
        //<editor-fold defaultstate="collapsed" desc=" Look and feel settings ">
        //com.jtattoo.plaf.acryl.AcrylLookAndFeel.setTheme("Green");
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        // Initialized the allOrderData and allStockData with data from the database.
        final ListManager lists = new ListManager();
        allOrderData = lists.getAllSO();
        allStockData = lists.getAllSI();

        // Program starts from here
        gui = new MainGui();        
        gui.setExtendedState(MainGui.MAXIMIZED_BOTH); // Starts the program in full screen mode.
        gui.setVisible(true);

        // @TODO JavaDOC
        Runnable scheduledTask;
        scheduledTask = new Runnable() {
            @Override
            public void run() {
                allOrderData = lists.getAllSO();
                gui.scheduledUpdate(true);
            }
        };
        
        // @TODO JavaDOC
        ScheduledExecutorService scheduler;
        scheduler = Executors.newScheduledThreadPool(1);
        //scheduler.scheduleAtFixedRate(scheduledTask, SCHEDULER_PERIOD, SCHEDULER_PERIOD, TimeUnit.MINUTES);
        //scheduler.scheduleAtFixedRate(scheduledTask, 5, 5, TimeUnit.SECONDS); // for test
    }
}
