import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root", "root", "pass");
            System.out.println("YYYYYYYYYYYYYY");
        } catch (SQLException e) {
            System.out.println("Connection to data base failed");
        }



        try {
            connection.close();
            System.out.println("YYYYYYYYYYYYy");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
