package dk.easv.belman.BLL;

import dk.easv.belman.BE.Item;
import dk.easv.belman.BE.ProductOrder;
import dk.easv.belman.BE.SalesOrder;
import dk.easv.belman.BE.SalesOrderList;

public class Filter {

    /**
     *
     */
    public SalesOrderList filterBySleeve(SalesOrderList ord, int... args) {
        SalesOrderList ret = ord;
        int materialID = 0, thickness = 0, width_min = 0, width_max = 0, circumference_min = 0, circumference_max = 0;
        for (int i = 0; i < args.length; ++i) {
            if (i == 0) {
                materialID = args[0];
            } else if (i == 1) {
                thickness = args[1];
            } else if (i == 2) {
                width_min = args[2];
            } else if (i == 3) {
                width_max = args[3];
            } else if (i == 4) {
                circumference_min = args[4];
            } else if (i == 5) {
                circumference_max = args[5];
            }
        }
        for (int i = 0; i < ret.getList().size(); ++i) {
            SalesOrder so = ret.get(i);
            for (int j = 0; j < so.getProductOrderList().size(); ++j) {
                ProductOrder po = so.getProductOrderList().get(j);
                for (int k = 0; k < po.getItemList().size(); ++k) {
                    Item item = po.getItemList().get(k);
                    boolean wasSet = false;
                    boolean isOkay = false;
                    if (materialID != 0) {
                        if (item.getMaterialId() == materialID) {
                            isOkay = true;
                            wasSet = true;
                        }
                    }
                    if (thickness != 0) {
                        if (item.getThickness() == thickness) {
                            if (!wasSet) {
                                isOkay = true;
                                wasSet = true;
                            }
                        } else {
                            isOkay = false;
                        }
                    }
                    if (width_max != 0 && width_min != 0) {
                        if (item.getWidth() <= width_max && item.getWidth() >= width_min) {
                            if (!wasSet) {
                                isOkay = true;
                                wasSet = true;
                            }
                        } else {
                            isOkay = false;
                        }
                    }
                    if (circumference_max != 0 && circumference_min != 0) {
                        if (item.getCircumference() <= circumference_max && item.getCircumference() >= circumference_min) {
                            if (!wasSet) {
                                isOkay = true;
                                wasSet = true;
                            }
                        } else {
                            isOkay = false;
                        }
                    }
                    if (!isOkay) {
                        /*switch (*/ret.removeItem(item); System.out.println(i+", "+j+", "+k);/*) {
                            case 0:
                                System.out.println("item match");
                                break;
                            case 1:
                                System.out.println("item not match, put have simblings");
                                break;
                            case 2:
                                System.out.println("po");
                                break PO;
                            case 3:
                                System.out.println("so");
                                break SO;
                        }*/
                    }
                }
            }
        }
        return ret;
    }
}
