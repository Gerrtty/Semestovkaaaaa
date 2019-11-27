package ORM;

import some_usefull_classes.Text;

import java.io.Serializable;

public class Message implements Serializable {

    private int id;
    private Text text;

    public Message(Text text) {
        this.text = text;
    }

    public void Message() {

    }

    public void Message(Text text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }
}
