package dk.easv.belman.BE;

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
}
