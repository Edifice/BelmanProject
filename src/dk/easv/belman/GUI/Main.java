package dk.easv.belman.GUI;

//<editor-fold defaultstate="collapsed" desc=" Imports ">
import dk.easv.belman.BE.Lists.CutList;
import dk.easv.belman.BE.Lists.OperatorList;
import dk.easv.belman.BE.SalesOrder;
import dk.easv.belman.BE.Lists.SalesOrderList;
import dk.easv.belman.BE.Lists.StockItemList;
import dk.easv.belman.BE.Setting;
import dk.easv.belman.DAL.SettingsManager;
import java.awt.Color;
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
    public static Setting settings; //
    public static SalesOrderList allOrderData = new SalesOrderList(); // Initial order data is stored right from the startup of the program.
    public static StockItemList allStockData = new StockItemList(); // Initial stock data is stored right from the startup of the program.
    public static OperatorList allOperatorData = new OperatorList(); // Initial operators are stored right from the statup of the program.
    public static CutList allCutData = new CutList(); // Initial cut data is stored right from the startup of the program.
    public static int urgentDays; // The number of days to set a SalesOrder to Urgent if that is within.
    public static int schedulerPeriod; // Scheduler period in minutes.
    public static Color urgentColor; //
    public static Color expiredColor; //
    private static final String pathToIcon = "img/icon.png"; // Path to the icon.
    public static MainGui gui; // The main UI component.
    //</editor-fold>

    public static void main(String[] args) {
        //<editor-fold defaultstate="collapsed" desc=" Initialized the settings. ">
        settings = SettingsManager.getSettings();
        urgentDays = settings.getUrgentWithIn();
        schedulerPeriod = settings.getRefreshPeriod();
        urgentColor = new Color(settings.getUrgentColorRGB());
        expiredColor = new Color(settings.getExpiredColorRGB());
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Initialized the allOrderData, allStockData and allOperatorData with data from the database. ">
        allOrderData.update(); // Initially updates and fills up allOrderData with a SalesOrderList.
        allStockData.update(); // Initially updates and fills up allStockData with a StockItemList.
        allOperatorData.update(); // Initially updates and fills up allOperatordata with an OperatorList.
        allCutData.update(); // Initially updates and fills up allCutData with a CutList.
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
        ImageIcon icon = new ImageIcon(pathToIcon); // Initializes the icon.
        gui.setIconImage(icon.getImage()); // Sets the icon.
        gui.setVisible(true); // Makes the UI visible.
        initScheduler(); // Initializes the scheduler.
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
                ArrayList<Integer> old_ids = new ArrayList<>(); // Save the IDs of the current SalesOrders.
                for (SalesOrder so_old : allOrderData.getList()) {
                    old_ids.add(so_old.getId());
                }
                allOrderData.update(); // Update allOrderData with new data from the database.
                allStockData.update(); // Update allStockData with new data from the database.
                
                // Checks if there's any new order. 
                boolean alert = false;
                for (SalesOrder so_new : allOrderData.getList()) {
                    if (!old_ids.contains(so_new.getId())) {
                        alert = true;
                    }
                }
                gui.scheduledUpdate(alert); // If yes, alert the UI.
            }
        };

        ScheduledExecutorService scheduler;
        scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(scheduledTask, schedulerPeriod, schedulerPeriod, TimeUnit.MINUTES);
    }
    //</editor-fold>
}
