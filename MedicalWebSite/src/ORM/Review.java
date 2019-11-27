package ORM;


import some_usefull_classes.Text;

public class Review {
    private int review_id;
    private int building_service_id;
    private Text text;
    private String user_name;

    public int getReview_id() {
        return review_id;
    }

    public int getBuilding_service_id() {
        return building_service_id;
    }

    public Text getText() {
        return text;
    }

    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }

    public void setBuilding_service_id(int building_service_id) {
        this.building_service_id = building_service_id;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

}
