import java.util.Date;

public class Main {
    public static void main(String[] args) {
        User user = new User("email", "Tom", "Cat" ,new Password("password"), true, 748739759);
        user.addToDataBase();
    }
}
