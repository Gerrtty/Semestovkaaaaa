package ORM;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable {
    private int comment_id;
    private int message_id;
    private int user_id;
    private String text;
    private Date date;

    public Comment() {

    }

    public Comment(int message_id, int user_id, String text, Date date) {
        this.message_id = message_id;
        this.user_id = user_id;
        this.text = text;
        this.date = date;
    }

    public int getComment_id() {
        return comment_id;
    }

    public int getMessage_id() {
        return message_id;
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

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
