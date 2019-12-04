package DAO;

import ORM.Review;
import ORM.Service;
import ORM.ServiceBuildinng;
import ORM.User;
import interfaces.DAO;
import some_usefull_classes.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReviewDaO implements DAO<Review> {

    private static String INSERT  = "INSERT INTO semestrovka.Review" +
            " (building_service_id, user_id, datetime, text)" + "VALUES (?, ?, ?, ?)";

    private static String SELECT_ALL_FOR_SERVICE_BUILDING = "select * from semestrovka.Review join semestrovka.User " +
            "on semestrovka.Review.user_id = semestrovka.User.user_id join " +
            "semestrovka.ServiceBuilding on semestrovka.ServiceBuilding.builing_service_id = semestrovka.Review.building_service_id";

    private static String SELECT_ALL = "SELECT * from semestrovka.Review";

    @Override
    public Review get(int id) {
        return new Review();
    }

    @Override
    public List<Review> getAll() {
        return null;
    }

    @Override
    public void add(Review review) {
        try {
            PreparedStatement preparedStatement = ConnectionToDataBase.getConnection().prepareStatement(INSERT);
            preparedStatement.setInt(1, review.getBuilding_service_id());
            preparedStatement.setInt(2, review.getText().getUser_id());
            preparedStatement.setDate(3, new java.sql.Date(review.getText().getDate().getTime()));
            preparedStatement.setString(4, review.getText().getText());

            preparedStatement.executeUpdate();

            Logger.green_write("Review saved in data base");

        } catch (SQLException e) {
            e.printStackTrace();
            Logger.red_write("adding to data base failed");
        }
    }

    @Override
    public void update(Review review) {

    }

    @Override
    public void delete(Review review) {

    }

    public List getAllByID(ServiceBuildinng serviceBuildinng) {

        List<Review> list = new ArrayList<>();

        int id = serviceBuildinng.getService_id();

        try {
//            PreparedStatement ps = ConnectionToDataBase.getConnection().prepareStatement(SELECT_ALL_FOR_SERVICE_BUILDING);

//            ps.setInt(1, id);

//            ResultSet rs = ps.executeQuery();

            Statement st = ConnectionToDataBase.getConnection().createStatement();
            ResultSet rs = st.executeQuery(SELECT_ALL_FOR_SERVICE_BUILDING);

            while (rs.next()) {
                int b_id = rs.getInt("builing_service_id");
                if (b_id == id) {
                    Review review = new Review();
                    Text text = new Text();
                    text.setUser_id(rs.getInt("user_id"));
                    text.setText(rs.getString("text"));
                    text.setDate((Date) rs.getDate("datetime"));
                    review.setText(text);
                    review.setUser_name(rs.getString("firstName"));

                    list.add(review);
                }
            }

            st.close();

        } catch (SQLException ex) {
            System.out.println(ex);

        }

        return list;
    }
}
