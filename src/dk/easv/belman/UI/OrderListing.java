package dk.easv.belman.UI;

import javax.swing.JPanel;

public final class OrderListing {

    private TreeTableDemo ttd;
    private MainGui parent;

    public OrderListing(MainGui parent) {
        this.parent = parent;        
        ttd = new TreeTableDemo();
        setOrderListing();
        
    }
    
    public void setOrderListing() {
        parent.getSpnlWest().setLeftComponent(ttd.getPanel());
    }
}
