package dk.easv.belman.BE.Lists;

//<editor-fold defaultstate="collapsed" desc=" Imports ">
import dk.easv.belman.BE.Operator;
import dk.easv.belman.BLL.ListManager;
//</editor-fold>

public class OperatorList extends BList<Operator> {

    //<editor-fold defaultstate="collapsed" desc=" Constructor ">
    public OperatorList() {
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Get an operator by it's id ">
    /**
     * Search the list for 1 item by id and return it.
     *
     * @param id The id of the Operator that we are looking for.
     * @return Operator
     */
    public Operator getById(int id) {
        for (Operator op : this.getList()) {
            if (op.getId() == id) {
                return op;
            }
        }
        return null;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Update function ">
    @Override
    public void update() {
        this.setList(ListManager.getAllOP().getList());
    }
    //</editor-fold>
}
