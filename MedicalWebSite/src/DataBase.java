import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBase {
    private String path = "jdbc:mysql://127.0.0.1:3306/?user=root";
    private String password = "pass";
    private Connection connection;

    public DataBase() {
        connect();
    }

    private void connect() {
        try {
            connection = DriverManager.getConnection(path, "root", password);
        } catch (SQLException e) {
            System.out.println("Connection to data base failed");
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public PreparedStatement add(String q) {
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement("insert into " + q);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return preparedStmt;
    }


}
