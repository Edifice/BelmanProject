package DAL;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileManager {

    /**
     * This is a helper class that reads in a file from the given path and
     * creates a configuration file which is returned.
     *
     */
    public static Properties readPropertiesFile(String path) throws Exception{
        try {
            Properties config = new Properties();
            FileInputStream file = new FileInputStream(path);
            config.load(file);
            return config;
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("File not found " + path);
        }
    }
}
