package ORM;

import java.util.Date;

public class Text {
    private int user_id;
    private String text;
    private Date date;

    public Text() {

    }

    public Text(int user_id, String text, Date date) {
        this.user_id = user_id;
        this.text = text;
        this.date = date;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }


}
