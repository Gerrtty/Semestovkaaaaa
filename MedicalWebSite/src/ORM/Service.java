package ORM;

import java.io.Serializable;

public class Service implements Serializable {

    private int service_id;
    private String description;

    public Service() {

    }

    public Service(String description) {
        this.description = description;
    }

    public int getService_id() {
        return service_id;
    }

    public String getDescription() {
        return description;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
