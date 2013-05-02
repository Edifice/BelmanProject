package dk.easv.belman.DAL;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import dk.easv.belman.BE.Item;
import dk.easv.belman.BE.ItemList;
import dk.easv.belman.BE.ProductOrder;
import dk.easv.belman.BE.ProductOrderList;
import dk.easv.belman.BE.SalesOrder;
import dk.easv.belman.BE.SalesOrderList;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBConnection {

    private Connection connection; // the connection
    private SQLServerDataSource dataSource;
    private final String PATH = "dbconfig.cfg"; // the path to the config file
    private static volatile DBConnection instance = null; // the instance of this class

    private DBConnection() throws SQLException, FileNotFoundException {
        dataSource = new SQLServerDataSource();
        Properties conf = FileManager.readPropertiesFile(PATH);

        dataSource.setUser(conf.getProperty("USERNAME"));
        dataSource.setPassword(conf.getProperty("PASSWORD"));
        dataSource.setServerName(conf.getProperty("SERVERNAME"));
        dataSource.setInstanceName(conf.getProperty("INSTANCENAME"));
        dataSource.setDatabaseName(conf.getProperty("DBNAME"));
        dataSource.setPortNumber(1433);
    }

    /**
     * This method makes it possible that we have one and only one instance of
     * the connection. For more information look up the "Singleton pattern"
     * online.
     *
     * @return the Connection instance
     * @throws SQLException in case the connection failed to the database
     * @throws Exception in case we couldn't read from the configuration file
     */
    public static DBConnection getInstance() throws SQLException, FileNotFoundException {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    /**
     * This method returns a list of all sales order from the database.
     */
    public SalesOrderList getAllSalesOrder() throws SQLException {
        SalesOrderList ret = new SalesOrderList();
        connection = dataSource.getConnection();
        try {
            connection.setAutoCommit(false);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM SalesOrder");
            while (rs.next()) {
                SalesOrder ord = new SalesOrder();
                ord.setId(rs.getInt("order_id"));
                ord.setDescription(rs.getString("order_desc"));
                ord.setDueDate(rs.getTimestamp("due_date").getTime());
                ord.setDone(rs.getBoolean("is_done"));
                ret.add(ord);
            }
            connection.commit();
        } finally {
            connection.setAutoCommit(true);
            connection.close();
        }
        return ret;
    }

    /**
     * This method returns a list of all production order from the database.
     */
    public ProductOrderList getAllProductionOrder() throws SQLException {
        ProductOrderList ret = new ProductOrderList();
        connection = dataSource.getConnection();
        try {
            connection.setAutoCommit(false);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM ProductionOrder");
            while (rs.next()) {
                ProductOrder ord = new ProductOrder();
                ord.setId(rs.getInt("order_id"));
                ord.setDescription(rs.getString("order_desc"));
                ord.setDone(rs.getBoolean("is_done"));
                ord.setSalesOrderId(rs.getInt("sales_order"));
                ret.add(ord);
            }
            connection.commit();
        } finally {
            connection.setAutoCommit(true);
            connection.close();
        }
        return ret;
    }

    /**
     * This method returns all the production orders that are related to a
     * specific sales order.
     */
    public ProductOrderList getAllProductionOrder(int salesOrder) throws SQLException {
        ProductOrderList ret = new ProductOrderList();
        connection = dataSource.getConnection();
        try {
            connection.setAutoCommit(false);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM ProductionOrder WHERE sales_order = " + salesOrder);
            while (rs.next()) {
                ProductOrder ord = new ProductOrder();
                ord.setId(rs.getInt("order_id"));
                ord.setDescription(rs.getString("order_desc"));
                ord.setDone(rs.getBoolean("is_done"));
                ord.setSalesOrderId(rs.getInt("sales_order"));
                ret.add(ord);
            }
            connection.commit();
        } finally {
            connection.setAutoCommit(true);
            connection.close();
        }
        return ret;
    }

    /**
     * This method returns a list of all items from the database.
     */
    public ItemList getAllItem() throws SQLException {
        ItemList ret = new ItemList();
        connection = dataSource.getConnection();
        try {
            connection.setAutoCommit(false);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Item");
            while (rs.next()) {
                Item itm = new Item();
                itm.setId(rs.getInt("id"));
                itm.setQuantity(rs.getInt("quantity"));
                itm.setMaterialId(rs.getInt("material_id"));
                itm.setThickness(rs.getDouble("thickness"));
                itm.setWidth(rs.getDouble("width"));
                itm.setCircumference(rs.getDouble("circumference"));
                itm.setProductOrderId(rs.getInt("production_order"));
                ret.add(itm);
            }
            connection.commit();
        } finally {
            connection.setAutoCommit(true);
            connection.close();
        }
        return ret;
    }

    /**
     * This method returns all the Items that are related to a specific
     * Production Order.
     */
    public ItemList getAllItem(int productionOrder) throws SQLException {
        ItemList ret = new ItemList();
        connection = dataSource.getConnection();
        try {
            connection.setAutoCommit(false);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Item WHERE production_order = " + productionOrder);
            while (rs.next()) {
                Item itm = new Item();
                itm.setId(rs.getInt("id"));
                itm.setQuantity(rs.getInt("quantity"));
                itm.setMaterialId(rs.getInt("material_id"));
                itm.setThickness(rs.getDouble("thickness"));
                itm.setWidth(rs.getDouble("width"));
                itm.setCircumference(rs.getDouble("circumference"));
                itm.setProductOrderId(rs.getInt("production_order"));
                ret.add(itm);
            }
            connection.commit();
        } finally {
            connection.setAutoCommit(true);
            connection.close();
        }
        return ret;
    }
}
//class Test {
//
//    public static void main(String[] args) throws SQLException, FileNotFoundException {
//        DBConnection dbc = DBConnection.getInstance();
//        dbc.getAllSalesOrder();
//    }
//}
