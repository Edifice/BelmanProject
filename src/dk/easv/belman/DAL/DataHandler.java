package dk.easv.belman.DAL;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import dk.easv.belman.BE.Item;
import dk.easv.belman.BE.Operator;
import dk.easv.belman.BE.OperatorList;
import dk.easv.belman.BE.ProductOrder;
import dk.easv.belman.BE.SalesOrder;
import dk.easv.belman.BE.SalesOrderList;
import dk.easv.belman.BE.StockItem;
import dk.easv.belman.BE.StockItemList;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataHandler extends DBConnection {

    public DataHandler() throws FileNotFoundException, SQLException { // Throws the errors because the DBConnection class deals with the databse and local files.
        super(); // Calls the constructor of the DBConnection class.
    }

    /**
     * This method returns a list of all sales order from the database.
     *
     * @return a SalesOrderList with all the SalesOrders, ProductionOrders and
     * Items.
     */
    public SalesOrderList getAllSO() throws SQLException {

//        int so_i = 0, po_i = 0, i_i = 0; // for statistics

        SalesOrderList ret = new SalesOrderList();
        connection = dataSource.getConnection();
        try {
            connection.setAutoCommit(false);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT "
                    + "	i.id as item_id, "
                    + "	i.quantity as item_quantity, "
                    + "	i.material_id as item_material,"
                    + "	i.thickness as item_thickness,"
                    + "	i.width as item_width,"
                    + "	i.circumference as item_circumference,"
                    + "	i.is_done as item_done,"
                    + "	i.production_order as po_id, "
                    + "	po.order_desc as po_desc,"
                    + "	po.is_done as po_done,"
                    + "	po.sales_order as so_id,"
                    + "	so.order_desc as so_desc,"
                    + "	so.is_done as so_done,"
                    + "	so.due_date AS so_due_date "
                    + "FROM Item AS i "
                    + "RIGHT JOIN ProductionOrder AS po ON po.order_id = i.production_order "
                    + "RIGHT JOIN SalesOrder AS so ON so.order_id = po.sales_order "
                    + "ORDER BY so_due_date ASC, so_id ASC, po_id ASC, item_id ASC;");
            while (rs.next()) {
                boolean SO_new = false;
                boolean PO_new = false;

                SalesOrder so = ret.getById(rs.getInt("so_id"));
                ProductOrder po = null;

                if (so == null) {
                    SO_new = true;
                    PO_new = true;
                } else {
                    if (so.getProductOrderList().getById(rs.getInt("po_id")) == null) {
                        PO_new = true;
                    }
                }

                // if ther is no SO for this item, then create one
                if (SO_new) {
                    so = new SalesOrder();
                    so.setId(rs.getInt("so_id"));
                    so.setDescription(rs.getString("so_desc"));
                    so.setDone(rs.getBoolean("so_done"));
                    so.setDueDate(rs.getTimestamp("so_due_date").getTime());
                }
                if (!PO_new) {
                    po = so.getProductOrderList().getById(rs.getInt("po_id"));
                }

                // if ther is no PO for this Item
                if (po == null) {
                    po = new ProductOrder();
                    po.setId(rs.getInt("po_id"));
                    po.setDescription(rs.getString("po_desc"));
                    po.setDone(rs.getBoolean("po_done"));
                }

                Item item = new Item();
                item.setId(rs.getInt("item_id"));
                item.setQuantity(rs.getInt("item_quantity"));
                item.setMaterialId(rs.getInt("item_material"));
                item.setThickness(rs.getDouble("item_thickness"));
                item.setWidth(rs.getDouble("item_width"));
                item.setCircumference(rs.getDouble("item_circumference"));
                item.setDone(rs.getBoolean("item_done"));
                item.setSalesOrderId(rs.getInt("so_id"));

                po.getItemList().add(item);

                //saving data to `ret`
                if (SO_new) {
                    so.getProductOrderList().add(po);
                    ret.add(so);
//                    so_i++;
//                    po_i++;
//                    i_i++;
                } else {
                    if (PO_new) {
                        so.getProductOrderList().add(po);
                        ret.set(so);
//                        po_i++;
//                        i_i++;
                    } else {
                        so.getProductOrderList().set(po);
                        ret.set(so);
//                        i_i++;
                    }
                }
            }
            connection.commit();
        } finally {
            connection.setAutoCommit(true);
            connection.close();
        }
//        System.out.println("statistics: \n\tSalesOrderList size: " + so_i + ", \n\tProdcutionOrderList size: " + po_i + ", \n\tItemList size: " + i_i);
        return ret;
    }

    /**
     * This method updates a selected Item/Sleeve in the database.
     *
     * @param sleeve The selected item.
     */
    public void updateItem(Item sleeve) throws SQLException {
        connection = dataSource.getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement st = connection.prepareStatement("UPDATE Item "
                    + " SET is_done = ?"
                    + "WHERE id = ?");
            st.setInt(1, sleeve.getQuantity());
            st.setBoolean(2, sleeve.isDone());
            st.setInt(3, sleeve.getId());
            st.executeUpdate();
            connection.commit();
        } finally {
            connection.setAutoCommit(true);
            connection.close();
        }
//        System.out.println("Statistics: \n\Item/Sleeve was set to: "+sleeve.isDone());
    }

    /**
     * This method returns all the Stock items from the database.
     *
     * @return a StockItemList with all the StockItems.
     */
    public StockItemList getAllSI() throws SQLException {

        StockItemList ret = new StockItemList();
        connection = dataSource.getConnection();
        try {
            connection.setAutoCommit(false);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT "
                    + "	StockItem.*, "
                    + "	Material.material_name,"
                    + " Material.material_density "
                    + "	FROM StockItem"
                    + "	INNER JOIN Material"
                    + " ON Material.material_id = StockItem.material_id");
            while (rs.next()) {
                StockItem item = new StockItem();
                item.setId(rs.getInt("id"));
                item.setCode(rs.getString("code"));
                item.setMaterialId(rs.getInt("material_id"));
                item.setMaterialName(rs.getString("material_name"));
                item.setMaterialDensity(rs.getDouble("material_density"));
                item.setLength(rs.getDouble("length"));
                item.setWidth(rs.getDouble("width"));
                item.setThickness(rs.getDouble("thickness"));
                item.setBatchId(rs.getString("batch_id"));
                item.setQuantity(rs.getDouble("quantity"));
                ret.add(item);
            }
            connection.commit();
        } finally {
            connection.setAutoCommit(true);
            connection.close();
        }
//        System.out.println("Statistics: \n\tStockItemList size: " + ret.size());
        return ret;
    }
    
    /**
     * This method returns all the Operators in an OperatorList from the database.
     *
     * @return OperatorList A list of all operators.
     */
    public OperatorList getAllOP() throws SQLException {
        OperatorList ret = new OperatorList();
        connection = dataSource.getConnection();
        try {
            connection.setAutoCommit(false);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT "
                    + "	Operator.*, "
                    + "	Address.*"
                    + "	FROM Operator"
                    + "	INNER JOIN Address"
                    + " ON Address.id = Operator.address_id");
            while (rs.next()) {
                Operator op = new Operator();
                op.setId(rs.getInt("id"));
                op.setFirstName(rs.getString("first_name"));
                op.setLastName(rs.getString("last_name"));
                op.setSsn(rs.getLong("ssn"));
                op.setPhoneNo(rs.getString("phone_no"));
                op.setAddressStreetName(rs.getString("street_name"));
                op.setAddressStreetNo(rs.getString("street_no"));
                op.setAddressCity(rs.getString("city"));
                op.setAddressZipCode(rs.getString("zip_code"));
                op.setAddressCountry(rs.getString("country"));
                ret.add(op);
            }
            connection.commit();
        } finally {
            connection.setAutoCommit(true);
            connection.close();
        }
        System.out.println("Statistics: \n\tOperatorList size: " + ret.size());
        return ret;
    }
    
}
