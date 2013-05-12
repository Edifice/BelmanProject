package dk.easv.belman.BLL;

import dk.easv.belman.BE.Item;
import dk.easv.belman.BE.ItemList;
import dk.easv.belman.BE.ProductOrder;
import dk.easv.belman.BE.SalesOrder;
import dk.easv.belman.BE.SalesOrderList;
import dk.easv.belman.BE.StockItem;
import dk.easv.belman.BE.StockItemList;

public class Filter {

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
     * @param sItem the StockItem for reference.
     *
     * @return CURRENTLY An ItemList with the filtered Items.
     */
    public ItemList filterByStock(SalesOrderList sList, StockItem sItem) {
        ItemList resList = new ItemList();
        ItemList itemList = new ListManager().getItemList(sList);
        
        for (Item item : itemList.getList()) {
            if (sItem.getMaterialId() == item.getMaterialId() // Check for material id.
                    && sItem.getThickness() == item.getThickness() // Check for thickness.
                    && item.getWidth() <= sItem.getWidth() // Check for width.
                    && item.getCircumference() <= sItem.getLength()) { // Check for circumference.
                resList.add(item);
            }
        }
    
        return resList;
    }
}
