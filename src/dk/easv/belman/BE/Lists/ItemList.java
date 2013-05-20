package dk.easv.belman.BE.Lists;

//<editor-fold defaultstate="collapsed" desc=" Imports ">
import dk.easv.belman.BE.Item;
import dk.easv.belman.GUI.Main;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
//</editor-fold>

public class ItemList extends BList<Item> {

    public ItemList filterByDone(boolean isDone) {
        ItemList ret = (ItemList) this.copy();
        for (Iterator<Item> it = new ArrayList<>(ret.getList()).iterator(); it.hasNext();) {
            Item i = it.next();
            if ((!isDone && i.isDone()) || (isDone && !i.isDone())) {
                ret.remove(i);
            }
        }
        return ret;
    }

    public ItemList filterByWeek(int weeks) {
        final long oneWeek = 1000L * 60 * 60 * 24 * 7;

        ItemList ret = (ItemList) this.copy(); // The original list shouldn't be changed, so we create an empty one.
        Date currentDate = new Date(); // We get the current Date.
        long currentDateLong = currentDate.getTime(); // Get the current time in long.
        long range = weeks * oneWeek; // We get our range in long, knowing how much a week in in long, we multiply it by the number of weeks entered as parameter.
        long limit = currentDateLong + range; // We get the limit-date, by deducting the range from the current time.

        for (Item item : this.getList()) { // We loop through the SalesOrderList...
            if (Main.allOrderData.getById(item.getSalesOrderId()).getDueDate() >= limit) { // And check if it's in the range we specified or not.
                ret.remove(item); // If it is not, we add it to the SalesOrderList.
            }
        }
        return ret; // Finally, we return it.
    }
}
