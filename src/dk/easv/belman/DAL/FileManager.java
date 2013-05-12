package dk.easv.belman.DAL;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileManager {

    /**
     * This is a helper class that reads in a file from the given path and
     * creates a configuration file which is returned.
     * 
     * @TODO Throw error to the UI through the BLL for FileNotFoundException error. Also a check at startup.
     *
     */
    public static Properties readPropertiesFile(String path) {
        Properties config = new Properties();
        try {
            config = new Properties();
            FileInputStream file = new FileInputStream(path);
            config.load(file);
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return config;
    }
}
