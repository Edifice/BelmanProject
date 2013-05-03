package dk.easv.belman.DAL;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    protected Connection connection;
    protected SQLServerDataSource dataSource;
    private final String PATH = "dbconfig.cfg"; // the path to the config file
    private static volatile DBConnection instance = null; // the instance of this class

    protected DBConnection() throws SQLException, FileNotFoundException {
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
}