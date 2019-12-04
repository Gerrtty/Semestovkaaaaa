package DAO;

import ORM.Theme;
import interfaces.DAO;
import some_usefull_classes.ConnectionToDataBase;
import some_usefull_classes.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ThemeDAO implements DAO<Theme> {

    @Override
    public Theme get(int id) {

        Theme theme = new Theme();

        String s = "SELECT * from semestrovka.Theme join semestrovka.User on User.user_id = Theme.user_id where theme_id = ?";

        try {

            PreparedStatement st = ConnectionToDataBase.getConnection().prepareStatement(s);
            st.setInt(1, id);

            ResultSet rs = st.executeQuery();

            rs.next();

            theme.setContent(rs.getString("content"));
            theme.setId(rs.getInt("theme_id"));
            theme.setUser_id(rs.getInt("user_id"));
            theme.setUser_name(rs.getString("firstName"));
            theme.setTitle(rs.getString("title"));

            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();

        }

        return theme;
    }

    @Override
    public List<Theme> getAll() {

        String s = "SELECT * from semestrovka.Theme join semestrovka.User on User.user_id = Theme.user_id";

        List<Theme> list = new ArrayList<>();

        try {

            Statement st = ConnectionToDataBase.getConnection().createStatement();
            ResultSet rs = st.executeQuery(s);

            while (rs.next()) {

                Theme theme = new Theme();
                theme.setContent(rs.getString("content"));
                theme.setId(rs.getInt("theme_id"));
                theme.setUser_id(rs.getInt("user_id"));
                theme.setUser_name(rs.getString("firstName"));
                theme.setTitle(rs.getString("title"));
                list.add(theme);
            }

            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();

        }

        return list;
    }

    @Override
    public void add(Theme theme) {

        String sql = "INSERT INTO semestrovka.Theme (user_id, title, content)" +
                "VALUES (?, ?, ?)";

        try {
            PreparedStatement preparedStatement = ConnectionToDataBase.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, theme.getUser_id());
            preparedStatement.setString(2, theme.getTitle());
            preparedStatement.setString(3, theme.getContent());

            preparedStatement.executeUpdate();

            Logger.green_write("Theme saved in data base");


        } catch (SQLException e) {
            e.printStackTrace();
            Logger.red_write("adding to data base failed");
        }

    }

    @Override
    public void update(Theme theme) {

    }

    @Override
    public void delete(Theme theme) {

    }
}
