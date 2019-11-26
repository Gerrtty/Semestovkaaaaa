package DAO;

import ORM.Address;
import ORM.Building;
import interfaces.DAO;
import some_usefull_classes.ConnectionToDataBase;
import some_usefull_classes.Logger;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BuildingDAO implements DAO<Building> {

    private static String SELECT_ALL = "SELECT * from semestrovka.Building";

    public BuildingDAO() {
        super();
    }

    @Override
    public Optional<Building> get(int id) {
        return Optional.empty();
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

    }

    @Override
    public void update(Building building) {

    }

    @Override
    public void delete(Building building) {

    }
}
