package ORM;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Building implements Serializable {

    private int building_id;
    private Address address;
    private List<Building> list_of_building;

    public Building() {
        list_of_building = new ArrayList<>();
    }

    public Building(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public int getBuilding_id() {
        return building_id;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setBuilding_id(int building_id) {
        this.building_id = building_id;
    }
}
