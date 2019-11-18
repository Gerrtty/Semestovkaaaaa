package ORM;

import java.io.Serializable;

public class Message implements Serializable {

    private int message_id;
    private Text text;

    public void Message() {

    }

    public void Message(Text text) {
        this.text = text;
    }

    public int getMessage_id() {
        return message_id;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }
}
