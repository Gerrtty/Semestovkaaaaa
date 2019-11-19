import ORM.User;
import some_usefull_classes.ConnectionToDataBase;
import some_usefull_classes.Email;
import some_usefull_classes.Password;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        Password password = new Password("123pass");
        System.out.println(password.getPassword());
        Password password1 = new Password("123pass");
        System.out.println(password1.getPassword());



    }
}
