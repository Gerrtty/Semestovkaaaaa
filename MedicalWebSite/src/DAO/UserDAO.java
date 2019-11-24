package DAO;

import ORM.User;
import interfaces.DAO;
import some_usefull_classes.*;

import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Optional;

public class UserDAO implements DAO<User> {

    private User user;

    private static String sql = "INSERT INTO semestrovka.User (firstName, lastName, email, password," +
            "phone, aboute_user)" +
            "VALUES (?, ?, ?, ?, ?, ?)";

    private static String userIsExists = "SELECT login FROM semestrovka.User";

    private static String authString = "SELECT login, password FROM semestrovka.User";

    private static String userByLogin = "SELECT * from semestrovka.User";


    @Override
    public Optional<User> get(int id) {
        return Optional.empty();
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    public void add(User user) {

        try {
            PreparedStatement preparedStatement = ConnectionToDataBase.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail().getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getPhone());
            preparedStatement.setString(6, user.getAbout_user());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            Logger.red_write("adding to data base failed");
        }

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    public void update() {

    }

    public User getUserByLogin(Email email) {

        try {
            Statement st = ConnectionToDataBase.getConnection().createStatement();
            ResultSet rs = st.executeQuery(userByLogin);

            while (rs.next()) {
                String login = rs.getString("email");

                if(login.equals(email.getEmail())) {
                    Logger.green_write("User is exists");

                    InputStream inputStream = null;

                    Blob blob = rs.getBlob("photo");
                    if(blob != null) {
                        inputStream = blob.getBinaryStream();
                    }

                    return new User(rs.getString("firstName"),
                                    rs.getString("lastName"),
                                    new Email(rs.getString("email")),
                                    rs.getString("password"),
                                    rs.getString("gender"),
                                    rs.getString("aboute_user"),
                                    new Phone(rs.getString("phone")));
                }
            }

            st.close();

        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        return null;

    }

}
