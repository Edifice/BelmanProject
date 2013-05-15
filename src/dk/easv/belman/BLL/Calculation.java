package dk.easv.belman.BLL;

import dk.easv.belman.BE.Cut;
import dk.easv.belman.BE.Item;
import dk.easv.belman.BE.StockItem;

public class Calculation {

    /**
     * This method calculates how many sleeves can be cut from the selected
     * stock item
     *
     * @param stockItem is the selected stock item
     * @param sleeve is the selected sleeve
     * @return the number of cuts that can be done
     */
    public int canCutHowMany(StockItem stockItem, Item sleeve) {
        int amount = 0;
        double availableAmount = stockItem.getLength();
        for (int i = 0; i < sleeve.getQuantity(); i++) {
            if (availableAmount > sleeve.getCircumference()) {
                amount++;
                availableAmount = availableAmount - sleeve.getCircumference();
            }
        }
        return amount;
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

    /**
     * This method updates the StockItem's length.
     *
     * @param cut The cut that was done, which contains the StockItem and the
     * Sleeve as well.
     * @return stockItem The updated StockItem.
     */
    public StockItem updateStockEntity(Cut cut) {
        StockItem stockItem = cut.getStockItem();
        stockItem.setLength(stockItem.getLength()-(cut.getQuantity()*cut.getSleeve().getCircumference()));
        return stockItem;
    }
}
