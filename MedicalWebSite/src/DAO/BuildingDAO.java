package DAO;

import some_usefull_classes.Address;
import ORM.Building;
import interfaces.DAO;
import some_usefull_classes.ConnectionToDataBase;
import some_usefull_classes.Logger;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BuildingDAO implements DAO<Building> {

    public static int id = 10;

    private static String updatestring = "UPDATE semestrovka.Building set path = ? where building_id = ?";

    private static String SELECT_ALL = "SELECT * from semestrovka.Building";

    private static String sql = "INSERT INTO semestrovka.Building (name, town, district, street, number)" +
            "VALUES (?, ?, ?, ?, ?)";

    private static String GET_BY_ID = "SELECT * from semestrovka.Building where building_id = ?";


    public BuildingDAO() {
        super();
    }


    @Override
    public Optional<Building> get(int id) {


        return Optional.empty();
    }

    public Building getByID(int id) {

        ResultSet rs = null;

        try {
            PreparedStatement ps = ConnectionToDataBase.getConnection().prepareStatement(GET_BY_ID);

            ps.setInt(1, id);

            rs = ps.executeQuery();

            rs.next();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return createBuilding(rs);
    }

    @Override
    public List<Building> getAll() {

        List<Building> allBuildings = new ArrayList<>();

        try {
            Statement st = ConnectionToDataBase.getConnection().createStatement();
            ResultSet rs = st.executeQuery(SELECT_ALL);

            while (rs.next()) {

                Address address = new Address(rs.getString("town"),
                                              rs.getString("district"),
                                              rs.getString("street"),
                                              rs.getInt("number"));


                Building building = new Building(rs.getInt("building_id"), address);

                building.setPath(rs.getString("path"));
                building.setName(rs.getString("name"));

                allBuildings.add(building);

            }

            st.close();

            Logger.green_write("Get list of all buildings");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return allBuildings;
    }

    @Override
    public void add(Building building) {

        Address address = building.getAddress();

        try {
            PreparedStatement preparedStatement = ConnectionToDataBase.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, building.getName());
            preparedStatement.setString(2, address.getTown());
            preparedStatement.setString(3, address.getDistrict());
            preparedStatement.setString(4, address.getStreet());
            preparedStatement.setInt(5, address.getNumber());

            preparedStatement.executeUpdate();

            Logger.green_write("Building saved in data base");

            id++;

        } catch (SQLException e) {
            e.printStackTrace();
            Logger.red_write("adding to data base failed");
        }

    }

    @Override
    public void update(Building building) {

    }

    @Override
    public void delete(Building building) {

    }

    public List<Building> getBuildingsBySQLString(String sql, String s) {

        List<Building> list = new ArrayList<>();

        try {
            PreparedStatement ps = ConnectionToDataBase.getConnection().prepareStatement(sql);

            ps.setString(1, s);


            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(createBuilding(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void setPath(Building building) {
        try {
            PreparedStatement preparedStatement = ConnectionToDataBase.getConnection().prepareStatement(updatestring);
            preparedStatement.setString(1, building.getPath());
            preparedStatement.setInt(2, building.getId());
            preparedStatement.executeUpdate();
            Logger.green_write("Update successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Building createBuilding(ResultSet rs) {

        Building building = null;

        try {
            Address address = new Address(rs.getString("town"),
                    rs.getString("district"),
                    rs.getString("street"),
                    rs.getInt("number"));

            building = new Building(rs.getInt("building_id"), address);
            building.setName(rs.getString("name"));
            building.setPath(rs.getString("path"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return building;

    }
}
