package dk.easv.belman.BLL;

//<editor-fold defaultstate="collapsed" desc=" Imports ">
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
//</editor-fold>

public class Serialize implements Serializable {

    //<editor-fold defaultstate="collapsed" desc=" Global variables ">
    private static String outFile = "belman.serialize"; // Temporary file
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Serialize an object ">
    /**
     * @TODO JavaDoc
     * @param serializableObject
     * @throws IOException
     */
    public static void serialize(Object serializableObject) throws IOException {
        FileOutputStream fos = new FileOutputStream(outFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(serializableObject);
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" De-serialize an object ">
    /**
     * @TODO JavaDoc
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Object deSerialize() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(outFile);
        ObjectInputStream ois = new ObjectInputStream(fis);
        return ois.readObject();
    }
    //</editor-fold>
}
