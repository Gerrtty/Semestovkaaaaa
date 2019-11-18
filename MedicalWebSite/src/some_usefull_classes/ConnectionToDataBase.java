package some_usefull_classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToDataBase {

    private static String URL = "jdbc:mysql://127.0.0.1:3306/?user=root";
    private static String USER = "root";
    private static String PASSWORD = "pass";
    private static Connection connection;

    private ConnectionToDataBase() {

    }

    public static Connection getConnection() {
        if(connection == null) {
            createConnection();
        }
        return connection;
    }

    private static void createConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Logger.green_write("Connect to data base");
        } catch (SQLException e) {
            Logger.red_write("Connection to data base failed");
        }
    }

    public static void closeConnection() {
        try {
            connection.close();
        }
        catch (SQLException e) {
            Logger.red_write("Closing connection is failed");
            e.printStackTrace();
        }
    }

}