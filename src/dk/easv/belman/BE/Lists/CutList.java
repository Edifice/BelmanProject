package dk.easv.belman.BE.Lists;

//<editor-fold defaultstate="collapsed" desc=" Imports ">
import dk.easv.belman.BE.Cut;
import dk.easv.belman.BE.Item;
import dk.easv.belman.BLL.ListManager;
//</editor-fold>

public class CutList extends BList<Cut> {

    //<editor-fold defaultstate="collapsed" desc=" Get a Cut by a selected sleeve ">
    public CutList getCutsBySleeve(Item sleeve) {
        CutList cutList = new CutList();
        for (Cut cut : this.getList()) {
            if (cut.getSleeve().getId() == sleeve.getId()) {
                cutList.add(cut);
            }
        }
        return cutList;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Filter by archived flag ">
    public CutList filterByArchive(boolean isArchived) {
        CutList ret = new CutList();
        for (Cut cut : this.getList()) {
            if (cut.isArchived() == isArchived) {
                ret.add(cut);
            }
        }
        return ret;

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Update function ">
    @Override
    public void update() {
        this.setList(ListManager.getAllCuts().getList());
    }
    //</editor-fold>
}
