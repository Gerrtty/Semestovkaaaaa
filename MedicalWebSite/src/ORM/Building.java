package ORM;

import some_usefull_classes.Address;

import java.io.Serializable;


public class Building implements Serializable, interfaces.ImgUtil {

    private int id;
    private Address address;
    private static String folder = "/building/";
    private String path;
    private String name;

    public Building(int id, Address address) {
        this.id = id;
        this.address = address;
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

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
