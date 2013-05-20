package dk.easv.belman.GUI;

//<editor-fold defaultstate="collapsed" desc=" Imports ">
import dk.easv.belman.BE.CutList;
import dk.easv.belman.BE.OperatorList;
import dk.easv.belman.BE.SalesOrder;
import dk.easv.belman.BE.SalesOrderList;
import dk.easv.belman.BE.StockItemList;
import dk.easv.belman.BLL.ListManager;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
//</editor-fold>

public class Main {

    //<editor-fold defaultstate="collapsed" desc=" Global storage and settings variables ">
    public static SalesOrderList allOrderData; // Initial order data is stored right from the startup of the program.
    public static StockItemList allStockData; // Initial stock data is stored right from the startup of the program.
    public static OperatorList allOperatorData; // Initial operators are stored right from the statup of the program.
    public static CutList allCuts; // Initial cut data is stored right from the startup of the program.
    public static final int URGENT_DAYS = 3; // The number of days to set a SalesOrder to Urgent if that is within.
    private static final int SCHEDULER_PERIOD = 10; // Scheduler period in minutes.
    private static final String pathToIcon = "img/logo.jpg"; // Path to the icon. @TODO Convert it to .ico and rename it from logo to icon
    private static MainGui gui; // The main UI component.
    //</editor-fold>

    public static void main(String[] args) {
        //<editor-fold defaultstate="collapsed" desc=" Initialized the allOrderData, allStockData and allOperatorData with data from the database. ">
        allOrderData.update();
        allStockData.update();
        allOperatorData.update();
        allCuts.update();
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc=" Set the look and feel of the program ">
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc=" Start the GUI ">
        // Program starts from here
        gui = new MainGui();
        gui.setExtendedState(MainGui.MAXIMIZED_BOTH); // Starts the program in full screen mode.
        ImageIcon icon = new ImageIcon(pathToIcon);
        gui.setIconImage(icon.getImage());
        gui.setVisible(true);
        initScheduler();
        //</editor-fold>
    }

    //<editor-fold defaultstate="collapsed" desc=" Initialize scheduled task ">
    /**
     * Initializing scheduled task to update the stored data in a given period
     * of time.
     */
    private static void initScheduler() {
        Runnable scheduledTask;
        scheduledTask = new Runnable() {
            @Override
            public void run() {
                ArrayList<Integer> old_ids = new ArrayList<>();
                for (SalesOrder so_old : allOrderData.getList()) {
                    old_ids.add(so_old.getId());
                }
                allOrderData.update();
                allStockData.update();
                boolean alert = false;
                for (SalesOrder so_new : allOrderData.getList()) {
                    if (!old_ids.contains(so_new.getId())) {
                        alert = true;
                    }
                }
                gui.scheduledUpdate(alert);
            }
        };

        ScheduledExecutorService scheduler;
        scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(scheduledTask, SCHEDULER_PERIOD, SCHEDULER_PERIOD, TimeUnit.MINUTES);
    }
    //</editor-fold>
}
