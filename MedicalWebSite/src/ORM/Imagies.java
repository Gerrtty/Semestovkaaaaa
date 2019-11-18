package ORM;

import java.io.Serializable;
import java.sql.Blob;

public class Imagies implements Serializable {

    private int img_id;
    private int building_id;
    private Blob img;
    private String type;

    public Imagies() {

    }

    public Imagies(int building_id, Blob img, String type) {
        this.building_id = building_id;
        this.img = img;
        this.type = type;
    }

    public Imagies(int building_id, Blob img) {
        this.building_id = building_id;
        this.img = img;
    }

    public int getImg_id() {
        return img_id;
    }

    public int getBuilding_id() {
        return building_id;
    }

    public Blob getImg() {
        return img;
    }

    public String getType() {
        return type;
    }

    public void setImg_id(int img_id) {
        this.img_id = img_id;
    }

    public void setBuilding_id(int building_id) {
        this.building_id = building_id;
    }

    public void setImg(Blob img) {
        this.img = img;
    }

    public void setType(String type) {
        this.type = type;
    }
}
