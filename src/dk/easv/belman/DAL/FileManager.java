package dk.easv.belman.DAL;

//<editor-fold defaultstate="collapsed" desc=" Imports ">
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Calendar;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
//</editor-fold>

public class FileManager {

    //<editor-fold defaultstate="collapsed" desc=" Read the properties file ">
    /**
     * This is a helper class that reads in a file from the given path and
     * creates a configuration file which is returned.
     *
     * @TODO Throw error to the UI through the BLL for FileNotFoundException
     * error and also a check at startup
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
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Write a file (for the XML) ">
    /**
     * @TODO JavaDoc and comments
     * @param list
     * @return
     */
    public static boolean write(Document doc) {
        try {
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            Calendar c = Calendar.getInstance();

            StreamResult result = new StreamResult(new File("Belman_export_" + c.get(Calendar.YEAR) + "_" + c.get(Calendar.MONTH) + "_" + c.get(Calendar.DAY_OF_MONTH) + "_" + c.get(Calendar.HOUR_OF_DAY) + "_" + c.get(Calendar.MINUTE) + "_" + c.get(Calendar.SECOND) + ".xml"));

            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);

            transformer.transform(source, result);

            System.out.println("File saved!");
            return true;
        } catch (TransformerException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    //</editor-fold>
    
    public static void write(Properties propFile){
        try {
            //save properties to project root folder
            propFile.store(new FileOutputStream("settings.cfg"), null);
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
