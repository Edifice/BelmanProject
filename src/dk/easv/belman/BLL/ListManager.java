package dk.easv.belman.BLL;

import dk.easv.belman.BE.SalesOrderList;
import dk.easv.belman.DAL.DataHandler;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListManager {

    DataHandler handler;
    
    public ListManager(){
        try {
            handler = new DataHandler();
        } catch (FileNotFoundException | SQLException ex) {
            Logger.getLogger(ListManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public SalesOrderList getAll() {
        try {
            return handler.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(ListManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
