package ORM;

import java.io.Serializable;

public class Assessment implements Serializable {

    private int assessment_id;
    private int building_service_id;
    private int user_id;
    private int assessment;

    public Assessment() {

    }

    public Assessment(int building_service_id, int user_id, int assessment) {

    }

    public int getAssessment_id() {
        return assessment_id;
    }

    public int getBuilding_service_id() {
        return building_service_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getAssessment() {
        return assessment;
    }

    public void setAssessment_id(int assessment_id) {
        this.assessment_id = assessment_id;
    }

    public void setBuilding_service_id(int building_service_id) {
        this.building_service_id = building_service_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setAssessment(int assessment) {
        this.assessment = assessment;
    }
}
