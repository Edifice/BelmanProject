package dk.easv.belman.BLL;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serialize implements Serializable {

    private static String outFile = "belman.serialize";

    public static void serialize(Object serializableObject) throws IOException {
        FileOutputStream fos = new FileOutputStream(outFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(serializableObject);
    }

    public static Object deSerialize() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(outFile);
        ObjectInputStream ois = new ObjectInputStream(fis);
        return ois.readObject();
    }
}
