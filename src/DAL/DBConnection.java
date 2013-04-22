package DAL;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    private Connection connection;
    private SQLServerDataSource dataSource;
    private final String PATH = "dbconfig.cfg";
    private static volatile DBConnection instance = null;

    private DBConnection() throws SQLException, Exception {
        dataSource = new SQLServerDataSource();
        Properties conf = FileManager.readPropertiesFile(PATH);

        dataSource.setUser(conf.getProperty("USERNAME"));
        dataSource.setPassword(conf.getProperty("PASSWORD"));
        dataSource.setServerName(conf.getProperty("SERVERNAME"));
        dataSource.setInstanceName(conf.getProperty("INSTANCENAME"));
        dataSource.setDatabaseName(conf.getProperty("DBNAME"));
    }

    public static DBConnection getInstance() throws SQLException, Exception {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }
}
