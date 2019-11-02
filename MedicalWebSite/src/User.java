import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User {
    private int id; // pk
    private String email;
    private String name;
    private String sername;
    private Password password;
    private DataBase dataBase;

    public User(String email,
                String name,
                String sername,
                Password password) {

        this.email = email;
        this.name = name;
        this.sername = sername;
        this.password = password;
    }


    public void addToDataBase() {
        dataBase = new DataBase();

        String query = "User " + "(email, name, sername, password)"  + " values (?, ?, ?, ?)";

        PreparedStatement preparedStatement = dataBase.add(query);
        try {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, sername);
            preparedStatement.setString(4, password.getPassword());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        dataBase.closeConnection();

    }

    private boolean isExsists() {
        return false;
    }
}
