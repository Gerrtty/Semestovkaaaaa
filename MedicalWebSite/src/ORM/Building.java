package ORM;

import java.io.Serializable;

public class Building implements Serializable {

    private int building_id;
    private Address addrees;

    public Building() {

    }

    public Building(Address addrees) {
        this.addrees = addrees;
    }

    public Address getAddrees() {
        return addrees;
    }

    public int getBuilding_id() {
        return building_id;
    }

    public void setAddrees(Address addrees) {
        this.addrees = addrees;
    }

    public void setBuilding_id(int building_id) {
        this.building_id = building_id;
    }
}
