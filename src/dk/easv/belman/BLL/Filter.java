package dk.easv.belman.BLL;

import dk.easv.belman.BE.Item;
import dk.easv.belman.BE.ItemList;
import dk.easv.belman.BE.SalesOrder;
import dk.easv.belman.BE.SalesOrderList;
import dk.easv.belman.BE.StockItem;
import dk.easv.belman.BE.StockItemList;
import java.sql.Timestamp;
import java.util.Date;

public class Filter {

    private final static long WEEK_IN_LONG = 604800000;

    /**
     * This method filters a StockItemList by a selected Item/Sleeve and checks
     * for the StockItems that have the SAME MaterialID, SAME Thickness, SMALLER
     * or the SAME Width, and SMALLER or the SAME Length.
     *
     * @param sList The StockItemList that need to be filtered.
     * @param item the Item for reference.
     *
     * @return A filtered StockItemList.
     */
    public StockItemList filterBySleeve(StockItemList sList, Item item) {
        StockItemList ret = new StockItemList();

        for (StockItem s : sList.getList()) {
            if (item.getMaterialId() == s.getMaterialId() // Check for material id.
                    && item.getCircumference() <= s.getLength() // Check for length.
                    && item.getThickness() == s.getThickness() // Check for thickness.
                    && item.getWidth() <= s.getWidth()) { // Check for width.
                ret.add(s);
            }
        }
        return ret;
    }

    /**
     * This method filters a SalesOrderList by a selected StockItem and checks
     * for the Items/Sleeves that have the SAME MaterialID, SAME Thickness,
     * SMALLER or the SAME Width, and SMALLER or the SAME Circumference.
     *
     * @param sList The SalesOrderList that need to be filtered.
     * @param stockItem the StockItem for reference.
     *
     * @return CURRENTLY An ItemList with the filtered Items.
     */
    public ItemList filterByStock(SalesOrderList sList, StockItem stockItem) {
        ItemList resList = new ItemList();
        ItemList itemList = new ListManager().getItemList(sList);

        for (Item sleeve : itemList.getList()) {
            if (stockItem.getMaterialId() == sleeve.getMaterialId() // Check for material id.
                    && stockItem.getThickness() == sleeve.getThickness() // Check for thickness.
                    && sleeve.getWidth() <= stockItem.getWidth() // Check for width.
                    && sleeve.getCircumference() <= stockItem.getLength()) { // Check for circumference.
                resList.add(sleeve);
            }
        }

        return resList;
    }

    /**
     * This method makes sure that a selected sleeve can be cut from a selected
     * stock item
     *
     * @param stockItem is the selected stock item
     * @param sleeve is the selected sleeve
     * @return true if the sleeve can be cut from the stock item, false
     * otherwise
     */
    public boolean canCut(StockItem stockItem, Item sleeve) {
        if (stockItem.getMaterialId() == sleeve.getMaterialId() // Check for material id.
                && stockItem.getThickness() == sleeve.getThickness() // Check for thickness.
                && sleeve.getWidth() <= stockItem.getWidth() // Check for width.
                && sleeve.getCircumference() <= stockItem.getLength()) { // Check for circumference.
            return true;
        } else {
            return false;
        }

    }
    
//    /**
//     * This method calculates how many sleeves can be cut from the selected stock item
//     * @param stockItem is the selected stock item
//     * @param sleeve is the selected sleeve
//     * @return the number of cuts that can be done
//     */
//    public int canCutHowMany(StockItem stockItem, Item sleeve) {
//        int amount = 0;
//        double availableAmount = stockItem.getLength();
//        for(int i = 0; i < sleeve.getQuantity(); i++){
//            if(availableAmount > sleeve.getCircumference()){
//                amount++;
//                availableAmount = availableAmount-sleeve.getCircumference();
//            }
//        }
//        return amount;
//    }

    /**
     * Returns all the sales orders which has a due date within the week limit.
     *
     * @param weeks is the limit.
     * @param so The SalesOrderList we filter by week.
     * @return a list of sales Orders.
     */
    public SalesOrderList getSalesOrderList(SalesOrderList so, int weeks) {
        SalesOrderList newSo = new SalesOrderList(); // The original list shouldn't be changed, so we create an empty one.
        Date currentDate = new Date(); // We get the current Date.
        long currentDateLong = currentDate.getTime(); // Get the current time in long.
        long range = weeks * WEEK_IN_LONG; // We get our range in long, knowing how much a week in in long, we multiply it by the number of weeks entered as parameter.
        long limit = currentDateLong + range; // We get the limit-date, by deducting the range from the current time.
        for (SalesOrder order : so.getList()) { // We loop through the SalesOrderList...
            if (order.getDueDate() < limit) { // And check if it's in the range we specified or not.
                newSo.add(order); // If it is, we add it to the SalesOrderList.
            }
        }
        System.out.println("range: " + range + " / " + new Timestamp(0) + " - " + new Timestamp(range));
        System.out.println("current time: " + currentDateLong + " / " + currentDate);
        System.out.println("limit: " + limit + " / " + new Timestamp(limit));
        return newSo; // Finally, we return it.
    }
}
