package DAO;

import ORM.Building;
import ORM.ServiceBuildinng;
import interfaces.DAO;
import some_usefull_classes.ConnectionToDataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServiceBuildingDAO implements DAO<ServiceBuildinng> {

    private static String SELECT_ALL = "SELECT * from semestrovka.ServiceBuilding";

    @Override
    public Optional<ServiceBuildinng> get(int id) {
        return Optional.empty();
    }

    @Override
    public List<ServiceBuildinng> getAll() {
        return null;
    }

    @Override
    public void add(ServiceBuildinng serviceBuildinng) {

    }

    @Override
    public void update(ServiceBuildinng serviceBuildinng) {

    }

    @Override
    public void delete(ServiceBuildinng serviceBuildinng) {

    }

    public List getAllByBuildingID(Building building) {
        List list = new ArrayList();
        int id = building.getId();
        try {
            Statement st = ConnectionToDataBase.getConnection().createStatement();
            ResultSet rs = st.executeQuery(SELECT_ALL);

            while (rs.next()) {
                ServiceBuildinng serviceBuilding = new ServiceBuildinng();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
