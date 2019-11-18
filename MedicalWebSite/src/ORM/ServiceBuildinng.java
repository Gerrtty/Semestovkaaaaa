package ORM;

import java.io.Serializable;

public class ServiceBuildinng implements Serializable {

    private Service service;
    private Building building;
    private int service_id;
    private int building_id;

    public ServiceBuildinng() {

    }

    public ServiceBuildinng(Service service, Building building) {
        this.service = service;
        this.building = building;
        this.service_id = service.getService_id();
        this.building_id = building.getBuilding_id();
    }

    public ServiceBuildinng(int service_id, int building_id) {
        this.service_id = service_id;
        this.building_id = building_id;
    }
}
