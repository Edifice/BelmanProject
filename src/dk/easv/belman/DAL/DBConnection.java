package dk.easv.belman.DAL;

//<editor-fold defaultstate="collapsed" desc=" Imports ">
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
//</editor-fold>

public class DBConnection {

    //<editor-fold defaultstate="collapsed" desc=" Global variables ">    
    protected Connection connection;
    protected SQLServerDataSource dataSource;
    private final String PATH = "dbconfig.cfg"; // the path to the config file
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructor ">
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
    //</editor-fold>
}