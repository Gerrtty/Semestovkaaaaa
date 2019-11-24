package ORM;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Building implements Serializable, interfaces.ImgUtil {

    private int id;
    private Address address;
    private List<Building> list_of_building;
    private static String folder = "/building/";

    public Building() {
        list_of_building = new ArrayList<>();
    }

    public Building(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

    @Override
    public String folderName() {
        return folder;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setId(int id) {
        this.id = id;
    }
}
