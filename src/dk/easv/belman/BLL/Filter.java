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
    public StockItemList filterBySleeve(Item sleeve) {
        StockItemList ret = new StockItemList();
        for (Iterator<StockItem> it = new ArrayList<>(Main.allStockData.getList()).iterator(); it.hasNext();) {
            StockItem item = it.next();
            if (item.getMaterialId() == sleeve.getMaterialId()
                    && item.getThickness() == sleeve.getThickness()
                    && item.getWidth() >= sleeve.getWidth()
                    && item.getLength() >= sleeve.getCircumference()) {
                ret.add(item);
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
                    if(sItem.getMaterialId() == item.getMaterialId() && sItem.getThickness() == item.getThickness() && item.getWidth() <= sItem.getWidth()
                    && item.getCircumference() <= sItem.getLength()){
                    iList.add(item);   
                    }
                }
            }
        }
        
        return iList;
    }
}
