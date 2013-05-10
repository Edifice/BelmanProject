package dk.easv.belman.BLL;

import dk.easv.belman.BE.Item;
import dk.easv.belman.BE.ItemList;
import dk.easv.belman.BE.ProductOrder;
import dk.easv.belman.BE.SalesOrder;
import dk.easv.belman.BE.SalesOrderList;
import dk.easv.belman.BE.StockItem;
import dk.easv.belman.BE.StockItemList;
import dk.easv.belman.GUI.Main;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Filter {

    /**
     * TODO JavaDoc
     */
    public StockItemList filterBySleeve(StockItemList sList, Item item) {
        StockItemList ret = new StockItemList();
        for (StockItem s : sList.getList()) {
            if (item.getMaterialId() == s.getMaterialId() && item.getCircumference() <= s.getLength() 
                    && item.getThickness() == s.getThickness() && item.getWidth() <= s.getWidth()) {
                ret.add(s);
            }
        }
        return ret;
    }

    /**
     * TODO JavaDoc
     */
    public ItemList filterByStock(SalesOrderList sList, StockItem sItem) {
        ItemList iList = new ItemList();        

        for (SalesOrder s : sList.getList()) {
            for (ProductOrder p : s.getProductOrderList().getList()) {
                for (Item item : p.getItemList().getList()) {
                    if (sItem.getMaterialId() == item.getMaterialId() && sItem.getThickness() == item.getThickness() && item.getWidth() <= sItem.getWidth()
                            && item.getCircumference() <= sItem.getLength()) {
                        iList.add(item);
                    }
                }
            }
        }

        return iList;
    }
}
