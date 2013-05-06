package dk.easv.belman.BLL;

import dk.easv.belman.BE.Item;
import dk.easv.belman.BE.ProductOrder;
import dk.easv.belman.BE.SalesOrder;
import dk.easv.belman.BE.SalesOrderList;
import java.util.ArrayList;
import java.util.Iterator;

public class Filter {

    /**
     * TODO JavaDoc
     */
    public SalesOrderList filterBySleeve(SalesOrderList ord, int materialID, double thickness, double width_min, double width_max, double circumference_min, double circumference_max) {
        SalesOrderList ret = ord;
        for (Iterator<SalesOrder> it = new ArrayList<>(ord.getList()).iterator(); it.hasNext();) {
            SalesOrder so = it.next();
            System.out.println(ret.getList().size());
            for (Iterator<ProductOrder> it2 = new ArrayList<>(so.getProductOrderList().getList()).iterator(); it2.hasNext();) {
                ProductOrder po = it2.next();
                for (Iterator<Item> it3 = new ArrayList<>(po.getItemList().getList()).iterator(); it3.hasNext();) {
                    Item item = it3.next();
                    boolean wasSet = false;
                    boolean isOkay = false;
                    boolean notOkay = false;
                    if (materialID != 0) {
                        if (item.getMaterialId() == materialID) {
                            isOkay = true;
                            wasSet = true;
                            notOkay = false;
                        } else {
                            notOkay = true;
                        }
                    }
                    if (thickness != 0) {
                        if (item.getThickness() == thickness) {
                            if (!wasSet && !notOkay) {
                                isOkay = true;
                                wasSet = true;
                                notOkay = false;
                            }
                        } else {
                            isOkay = false;
                            notOkay = true;
                        }
                    }
                    if ((int)width_max != 0 && (int)width_min != 0) {
                        if (item.getWidth() <= width_max && item.getWidth() >= width_min) {
                            if (!wasSet && !notOkay) {
                                isOkay = true;
                                wasSet = true;
                            }
                        } else {
                            isOkay = false;
                        }
                    }
                    if ((int)circumference_max != 0 && (int)circumference_min != 0) {
                        if (item.getCircumference() <= circumference_max && item.getCircumference() >= circumference_min) {
                            if (!wasSet && !notOkay) {
                                isOkay = true;
                                wasSet = true;
                            }
                        } else {
                            isOkay = false;
                        }
                    }
                    if (!isOkay) {
                        ret.removeItem(item);
                    }
                }
            }
        }
        return ret;
    }
    
    /**
     * TODO JavaDoc
     */
    public SalesOrderList filterByOrder(SalesOrderList ord, int salesOrderID, int productionOrderID) {
        SalesOrderList ret = ord;
        for (Iterator<SalesOrder> it = new ArrayList<>(ord.getList()).iterator(); it.hasNext();) {
            SalesOrder so = it.next();
            System.out.println(ret.getList().size());
            for (Iterator<ProductOrder> it2 = new ArrayList<>(so.getProductOrderList().getList()).iterator(); it2.hasNext();) {
                ProductOrder po = it2.next();
                for (Iterator<Item> it3 = new ArrayList<>(po.getItemList().getList()).iterator(); it3.hasNext();) {
                    Item item = it3.next();
                    boolean wasSet = false;
                    boolean isOkay = false;
                    boolean notOkay = false;
                    if (salesOrderID != 0) {
                        if (item.getSalesOrderId()== salesOrderID) {
                            isOkay = true;
                            wasSet = true;
                            notOkay = false;
                        } else {
                            notOkay = true;
                        }
                    }
                    if (productionOrderID != 0) {
                        if (item.getProductOrderId()== productionOrderID) {
                            if (!wasSet && !notOkay) {
                                isOkay = true;
                                wasSet = true;
                                notOkay = false;
                            }
                        } else {
                            isOkay = false;
                            notOkay = true;
                        }
                    }
                    if (!isOkay) {
                        ret.removeItem(item);
                    }
                }
            }
        }
        return ret;
    }
}
