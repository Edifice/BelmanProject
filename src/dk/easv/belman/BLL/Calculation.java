package dk.easv.belman.BLL;

import dk.easv.belman.BE.Cut;
import dk.easv.belman.BE.StockItem;

public class Calculation {

    /**
     * This method updates the StockItem's length.
     *
     * @param cut The cut that was done, which contains the StockItem and the
     * Sleeve as well.
     * @return stockItem The updated StockItem.
     */
    public StockItem updateStockEntity(Cut cut) {
        StockItem stockItem = cut.getStockItem();
        stockItem.setLength(stockItem.getLength() - (cut.getQuantity() * cut.getSleeve().getCircumference()));
        return stockItem;
    }
}
