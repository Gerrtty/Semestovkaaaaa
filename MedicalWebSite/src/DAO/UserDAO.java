package DAO;

import ORM.User;
import some_usefull_classes.ConnectionToDataBase;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO implements DAO<User> {

    private User user;

    private static String sql = "INSERT INTO semestrovka.User (firstName, lastName, gender, email, password)"
            + "VALUES (?, ?, ?, ?, ?)";

    private String select = "SELECT login FROM java_lab_HW.User";
    private static String getId = "SELECT login, user_id FROM java_lab_HW.User";

    public static void add(User user) {
        try {
            PreparedStatement preparedStatement = ConnectionToDataBase.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getGender());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPassword().getPassword());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("adding to data base failed");
        }
    }

    public void delete() {

    }

    public boolean userIsExists() {
        return false;
    }

    public void update() {

    }
}
