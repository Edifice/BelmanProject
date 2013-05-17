package dk.easv.belman.DAL;

import dk.easv.belman.BE.Cut;
import dk.easv.belman.BE.CutList;
import dk.easv.belman.BE.Item;
import dk.easv.belman.BE.Operator;
import dk.easv.belman.BE.OperatorList;
import dk.easv.belman.BE.ProductionOrder;
import dk.easv.belman.BE.SalesOrder;
import dk.easv.belman.BE.SalesOrderList;
import dk.easv.belman.BE.StockItem;
import dk.easv.belman.BE.StockItemList;
import dk.easv.belman.GUI.Main;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;

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
                    + "	i.material_id as item_material,"
                    + "	i.thickness as item_thickness,"
                    + "	i.width as item_width,"
                    + "	i.circumference as item_circumference,"
                    + "	i.is_done as item_done,"
                    + "	i.production_order as po_id, "
                    + "	po.order_desc as po_desc,"
                    + "	po.quantity as po_quantity,"
                    + "	po.sales_order as so_id,"
                    + "	so.order_desc as so_desc,"
                    + "	so.due_date AS so_due_date "
                    + "FROM Item AS i "
                    + "RIGHT JOIN ProductionOrder AS po ON po.order_id = i.production_order "
                    + "RIGHT JOIN SalesOrder AS so ON so.order_id = po.sales_order "
                    + "ORDER BY so_due_date ASC, so_id ASC, po_id ASC, item_id ASC;");
            while (rs.next()) {
                boolean SO_new = false;
                boolean PO_new = false;

                SalesOrder so = ret.getById(rs.getInt("so_id"));
                ProductionOrder po = null;

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
                    so.setDueDate(rs.getTimestamp("so_due_date").getTime());
                }
                if (!PO_new) {
                    po = so.getProductOrderList().getById(rs.getInt("po_id"));
                }

                // if ther is no PO for this Item
                if (po == null) {
                    po = new ProductionOrder();
                    po.setId(rs.getInt("po_id"));
                    po.setDescription(rs.getString("po_desc"));
                    po.setQuantity(rs.getInt("po_quantity"));
                }

                Item item = new Item();
                item.setId(rs.getInt("item_id"));
                item.setMaterialId(rs.getInt("item_material"));
                item.setThickness(rs.getDouble("item_thickness"));
                item.setWidth(rs.getDouble("item_width"));
                item.setQuantity(rs.getInt("po_quantity"));
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
                    + "SET is_done = ? "
                    + "WHERE id = ?");
            st.setInt(1, sleeve.isDone() ? 1 : 0);
            st.setInt(2, sleeve.getId());
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
                    + "CoilType.width, "
                    + "CoilType.thickness, "
                    + "CoilType.material_id, "
                    + "Stock.id, "
                    + "Stock.batch_id, "
                    + "Stock.[length], "
                    + "Stock.code, "
                    + "Stock.quantity, "
                    + "Material.material_name, "
                    + "Material.material_density "
                    + "FROM CoilType "
                    + "INNER JOIN Material "
                    + "ON Material.material_id = CoilType.material_id "
                    + "INNER JOIN Stock "
                    + "ON Stock.coil_type = CoilType.id");
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
     * This method returns all the Operators in an OperatorList from the
     * database.
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
//        System.out.println("Statistics: \n\tOperatorList size: " + ret.size());
        return ret;
    }

    /**
     * This method returns all the cuts that was executed before and was stored
     * in the ItemStock table in the database, with the Item, StockItem and
     * Operator connected to that given cut.
     *
     * @return CutList A list of all cuts.
     */
    public CutList getAllCuts() throws SQLException {
        CutList ret = new CutList();
        connection = dataSource.getConnection();
        try {
            connection.setAutoCommit(false);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT ItemStock.* FROM ItemStock");
            while (rs.next()) {
                Item sleeve = Main.allOrderData.getItemById(rs.getInt("item_id"));
                Operator op = Main.allOperatorData.getById(rs.getInt("operator_id"));
                StockItem stockItem = Main.allStockData.getById(rs.getInt("stock_id"));

                Cut cut = new Cut();
                cut.setId(rs.getInt("id"));
                cut.setSleeve(sleeve);
                cut.setStockItem(stockItem);
                cut.setOperator(op);
                cut.setTimeSpent(rs.getLong("time_spent"));
                cut.setDate(rs.getTimestamp("date").getTime());
                cut.setQuantity(rs.getInt("quantity"));
                cut.setWaste(rs.getDouble("waste"));
                ret.add(cut);
            }
            connection.commit();
        } finally {
            connection.setAutoCommit(true);
            connection.close();
        }
//        System.out.println("Statistics: \n\tCutList size: " + ret.size());
        return ret;
    }

    /**
     * This method inserts a new cut into the database table ItemStock, with the
     * Sleeve id, StockItem id, Operator id, time spent and the time of the cut.
     *
     * @param cut The cut entity that needs to be inserted.
     */
    public void insertCut(Cut cut) throws SQLException {
        connection = dataSource.getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement st = connection.prepareStatement("INSERT "
                    + "INTO ItemStock "
                    + "(ItemStock.item_id, "
                    + "ItemStock.stock_id, "
                    + "ItemStock.operator_id, "
                    + "ItemStock.time_spent, "
                    + "ItemStock.[date],"
                    + "ItemStock.quantity, "
                    + "ItemStock.waste) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)");
            st.setInt(1, cut.getSleeve().getId());
            st.setInt(2, cut.getStockItem().getId());
            st.setInt(3, cut.getOperator().getId());
            st.setLong(4, cut.getTimeSpent());
            st.setTimestamp(5, new Timestamp(cut.getDate()));
            st.setInt(6, cut.getQuantity());
            st.setDouble(7, cut.getWaste());
            st.executeUpdate();
            connection.commit();
        } finally {
            connection.setAutoCommit(true);
            connection.close();
        }
//        System.out.println("Statistics: \n\The following cut was inserted: "+cut.getId());
    }

    /**
     * 
     * @param stockItem
     * @throws SQLException 
     */
    public void updateStock(StockItem stockItem) throws SQLException {
        connection = dataSource.getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement st = connection.prepareStatement("UPDATE Stock "
                    + "SET length = ? "
                    + "WHERE id = ?");
            st.setDouble(1, stockItem.getLength());
            st.setInt(2, stockItem.getId());
            st.executeUpdate();
            connection.commit();
        } finally {
            connection.setAutoCommit(true);
            connection.close();
        }
//        System.out.println("Statistics: \n\The length of StockItem #"+"stockItem.getId()"+" was updated to: "+stockItem.getLength());
    }
}
