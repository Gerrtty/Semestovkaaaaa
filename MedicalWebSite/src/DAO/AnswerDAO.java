package DAO;

import ORM.Answer;
import interfaces.DAO;
import some_usefull_classes.ConnectionToDataBase;
import some_usefull_classes.Logger;
import some_usefull_classes.Text;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnswerDAO implements DAO<Answer> {


    @Override
    public Answer get(int id) {
        return new Answer();
    }

    @Override
    public List<Answer> getAll() {
        return null;
    }

    @Override
    public void add(Answer answer) {

        String s = "INSERT INTO semestrovka.Answer (theme_id, user_id, text)" +
                "VALUES (?, ?, ?)";

        try {
            PreparedStatement preparedStatement = ConnectionToDataBase.getConnection().prepareStatement(s);
            preparedStatement.setInt(1, answer.getThemeId());
            preparedStatement.setInt(2, answer.getText().getUser_id());
            preparedStatement.setString(3, answer.getText().getText());
            preparedStatement.executeUpdate();

            Logger.green_write("Answer added to data base");

        } catch (SQLException e) {
            e.printStackTrace();
            Logger.red_write("adding to data base failed");
        }
    }

    @Override
    public void update(Answer answer) {

    }

    @Override
    public void delete(Answer answer) {

    }

    public List<Answer> getAll(int theme_id) {
        List<Answer> answers = new ArrayList<>();

        String sql = "select * from semestrovka.Answer join semestrovka.User on Answer.user_id = User.user_id where theme_id = ?";

        try {
            PreparedStatement ps = ConnectionToDataBase.getConnection().prepareStatement(sql);

            ps.setInt(1, theme_id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Answer answer = new Answer();
                Text text = new Text();
                text.setUser_id(rs.getInt("user_id"));
                text.setText(rs.getString("text"));
                answer.setText(text);
                answer.setThemeId(rs.getInt("theme_id"));
                answer.setUserName(rs.getString("firstName"));

                answers.add(answer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return answers;
    }
}
