package dk.easv.belman.BE.Lists;

import dk.easv.belman.BE.Operator;
import dk.easv.belman.BLL.ListManager;

public class OperatorList extends BList<Operator> {

    public OperatorList() {
    }

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

    @Override
    public void update() {
        this.setList(ListManager.getAllOP().getList());
    }
}
