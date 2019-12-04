package ORM;

import java.io.Serializable;

public class ServiceBuildinng implements Serializable {

    private Service service;
    private Building building;
    private int service_id;
    private int building_id;
    private int price;
    private String description;

    public ServiceBuildinng() {

    }

    public ServiceBuildinng(Service service, Building building, int price) {
        this.service = service;
        this.building = building;
        this.service_id = service.getService_id();
        this.building_id = building.getId();
        this.price = price;
    }

    public ServiceBuildinng(int service_id, int building_id, int price) {
        this.service_id = service_id;
        this.building_id = building_id;
        this.price = price;
    }

    public Service getService() {
        return service;
    }

    public Building getBuilding() {
        return building;
    }

    public int getService_id() {
        return service_id;
    }

    public int getBuilding_id() {
        return building_id;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public void setBuilding_id(int building_id) {
        this.building_id = building_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
