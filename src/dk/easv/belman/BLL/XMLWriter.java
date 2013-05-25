package dk.easv.belman.BLL;

//<editor-fold defaultstate="collapsed" desc=" Imports ">
import dk.easv.belman.BE.Cut;
import dk.easv.belman.BE.Lists.CutList;
import dk.easv.belman.DAL.FileManager;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
//</editor-fold>

public class XMLWriter {

    //<editor-fold defaultstate="collapsed" desc=" Add attributes to the XML ">
    /**
     * @TODO JavaDoc
     * @param name
     * @param value
     * @param parent
     * @param doc
     */
    private void _addAttr(String name, String value, Element parent, Document doc) {
        Attr attr = doc.createAttribute(name);
        attr.setValue(value);
        parent.setAttributeNode(attr);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Write a CutList to an XML file ">
    public boolean write(CutList list) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("cutList");
            doc.appendChild(rootElement);

            for (Cut cut : list.getList()) {
                Element staff = doc.createElement("cut");

                _addAttr("id", String.valueOf(cut.getId()), staff, doc);
                _addAttr("operator", cut.getOperator().toString(), staff, doc);

                _addAttr("sleeve_id", String.valueOf(cut.getSleeve().getId()), staff, doc);
                _addAttr("sleeve_material", String.valueOf(cut.getSleeve().getMaterialId()), staff, doc);
                _addAttr("sleeve_quantity_before", String.valueOf(cut.getSleeve().getQuantity()), staff, doc);

                _addAttr("stock_item_code", String.valueOf(cut.getStockItem().getCode()), staff, doc);
                _addAttr("stock_item_batch_id", String.valueOf(cut.getStockItem().getBatchId()), staff, doc);

                _addAttr("time_spent", String.valueOf(cut.getTimeSpent()), staff, doc); // in millisecond
                Date date = new Date(cut.getDate());
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                _addAttr("date",
                        cal.get(Calendar.YEAR) + "-"
                        + cal.get(Calendar.MONTH) + "-"
                        + cal.get(Calendar.DAY_OF_MONTH) + " "
                        + cal.get(Calendar.HOUR_OF_DAY) + ":"
                        + cal.get(Calendar.MINUTE) + ":"
                        + cal.get(Calendar.SECOND),
                        staff, doc);

                _addAttr("quantity", String.valueOf(cut.getQuantity()), staff, doc);
                _addAttr("waste", String.valueOf(cut.getWaste()), staff, doc);

                rootElement.appendChild(staff);
            }
            return FileManager.write(doc);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XMLWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    //</editor-fold>
}
