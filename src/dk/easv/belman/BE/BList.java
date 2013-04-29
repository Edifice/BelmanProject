package dk.easv.belman.BE;

import java.util.ArrayList;

public class BList<Type extends IEntity> {

    private ArrayList<Type> list;

    public BList() {
        list = new ArrayList<>();
    }

    public void setList(ArrayList<Type> list) {
        this.list = list;
    }

    public ArrayList<Type> getList() {
        return list;
    }

    public void save() {
        for (Type type : list) {
            type.save();
        }
    }

    public void update() {
        for (Type type : list) {
            type.update();
        }
    }
}
