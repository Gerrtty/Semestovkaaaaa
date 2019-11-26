package DAO;

import ORM.ServiceBuildinng;
import interfaces.DAO;
import some_usefull_classes.ConnectionToDataBase;
import some_usefull_classes.Logger;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ServiceBuildingDAO implements DAO<ServiceBuildinng> {

    private static String SELECT_ALL = "SELECT * from semestrovka.ServiceBuilding";

    private static String INSERT_STRING = "INSERT INTO semestrovka.ServiceBuilding (service_id, building_id, price)" +
            "VALUES (?, ?, ?)";

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
        try {
            PreparedStatement preparedStatement = ConnectionToDataBase.getConnection().prepareStatement(INSERT_STRING);
            preparedStatement.setInt(1, serviceBuildinng.getService_id());
            preparedStatement.setInt(2, serviceBuildinng.getBuilding_id());
            preparedStatement.setInt(3, serviceBuildinng.getPrice());
            preparedStatement.executeUpdate();

            Logger.green_write("Service id saved in data base");


        } catch (SQLException e) {
            e.printStackTrace();
            Logger.red_write("adding to data base failed");
        }
    }

    @Override
    public void update(ServiceBuildinng serviceBuildinng) {

    }

    @Override
    public void delete(ServiceBuildinng serviceBuildinng) {

    }

}
