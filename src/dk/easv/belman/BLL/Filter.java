package dk.easv.belman.BLL;

import dk.easv.belman.BE.Item;
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
    public SalesOrderList filterByStock(SalesOrderList ord, StockItem stockItem) {
        SalesOrderList ret = new SalesOrderList();
        for(int i = 0; i < ord.size(); i++){
        ret.add(ord.get(i));
        }
        for (Iterator<SalesOrder> it = new ArrayList<>(ret.getList()).iterator(); it.hasNext();) {
            SalesOrder so = it.next();
            for (Iterator<ProductOrder> it2 = new ArrayList<>(so.getProductOrderList().getList()).iterator(); it2.hasNext();) {
                ProductOrder po = it2.next();
                for (Iterator<Item> it3 = new ArrayList<>(po.getItemList().getList()).iterator(); it3.hasNext();) {
                    Item item = it3.next();

                    if (stockItem.getMaterialId() != item.getMaterialId()
                            && (stockItem.getThickness() != item.getThickness())
                            /*&& item.getWidth() <= stockItem.getWidth()
                            && item.getCircumference() <= stockItem.getLength()*/) {
                       ret.removeItem(item);
                    }
                }
            }
        }
//                    System.out.println(ret.getList().size());
            System.out.println(ord.getList().size());

        return ret;
    }
}
