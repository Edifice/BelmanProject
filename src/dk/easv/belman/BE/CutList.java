package dk.easv.belman.BE;

/**
 *
 *
 */
public class CutList extends BList<Cut> {

    public CutList getCutsBySleeve(Item sleeve) {
        CutList cutList = new CutList();
        for (Cut cut : this.getList()) {
            if (cut.getSleeve().getId() == sleeve.getId()) {
                cutList.add(cut);
            }
        }
        return cutList;
    }
}
