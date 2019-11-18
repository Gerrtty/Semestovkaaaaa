package some_usefull_classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToDataBase {
    private static Logger logger = Logger.getLogger();

    private static String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
    private static String user = "root";
    private static String password = "pass";
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
            connection = DriverManager.getConnection(url, user, password);
            logger.green_write("Connect to data base");
        } catch (SQLException e) {
            logger.red_wrie("Connection to data base failed");
        }
    }

    public static void closeConnection() {
        try {
            connection.close();
        }
        catch (SQLException e) {
            logger.red_wrie("Closing connection is failed");
            e.printStackTrace();
        }
    }

}