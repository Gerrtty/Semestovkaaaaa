package DAO;

import ORM.Message;
import some_usefull_classes.Text;
import ORM.User;
import interfaces.DAO;
import some_usefull_classes.ConnectionToDataBase;
import some_usefull_classes.Logger;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class MessageDAO implements DAO<Message> {

    private static String INSERT_STRING = "INSERT INTO semestrovka.Message (user_id, datetime, text," +
            "VALUES (?, ?, ?)";

    private static String GET_MESSAGE = "select * from semestrovka.User";

    @Override
    public Optional<Message> get(int id) {
        return Optional.empty();
    }

    @Override
    public List<Message> getAll() {
        return null;
    }

    @Override
    public void add(Message message) {
        try {
            PreparedStatement preparedStatement = ConnectionToDataBase.getConnection().prepareStatement(INSERT_STRING);
            preparedStatement.setInt(1, message.getText().getUser_id());
            preparedStatement.setDate(2, new Date(message.getText().getDate().getTime()));
            preparedStatement.setString(3, message.getText().getText());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            Logger.red_write("adding to data base failed");
        }
    }

    @Override
    public void update(Message message) {

    }

    @Override
    public void delete(Message message) {

    }

    public Message gerUserMessages(User user) {
        int userId = user.getId();

        try {
            Statement st = ConnectionToDataBase.getConnection().createStatement();
            ResultSet rs = st.executeQuery(GET_MESSAGE);

            while (rs.next()) {

                if(userId == user.getId()) {
                    Logger.green_write("Message is exists");


                    return new Message(new Text());
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
