package DAO;

import ORM.Building;
import ORM.Service;
import ORM.ServiceBuildinng;
import interfaces.DAO;
import some_usefull_classes.ConnectionToDataBase;
import some_usefull_classes.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServiceBuildingDAO implements DAO<ServiceBuildinng> {

    private static String SELECT_ALL = "SELECT * from semestrovka.ServiceBuilding";

    private static String INSERT_STRING = "INSERT INTO semestrovka.ServiceBuilding (service_id, building_id, price)" +
            "VALUES (?, ?, ?)";

    private static String SELECT_ALL_BY_BUILING_ID = "select price, description, builing_service_id from semestrovka.Building " +
            "join semestrovka.ServiceBuilding on semestrovka.Building.building_id = semestrovka.ServiceBuilding.building_id " +
            "join semestrovka.Service on semestrovka.Service.service_id = semestrovka.ServiceBuilding.service_id " +
            "where semestrovka.Building.building_id = ?";

    private static String getServiceBuilding = "select builing_service_id, price, description " +
            "from semestrovka.ServiceBuilding join semestrovka.Service on semestrovka.ServiceBuilding.service_id = " +
            "semestrovka.Service.service_id where builing_service_id = ?";

    @Override
    public Optional<ServiceBuildinng> get(int id) {
        return Optional.empty();
    }

    @Override
    public List<ServiceBuildinng> getAll() {
        return null;
    }

    public List<Service> getAllyBuildingID(Building building) {

        int id = building.getId();

        List<Service> list = new ArrayList<>();

        try {
            PreparedStatement ps = ConnectionToDataBase.getConnection().prepareStatement(SELECT_ALL_BY_BUILING_ID);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Service service = new Service();
                service.setDescription(rs.getString("description"));
                service.setPrice(rs.getInt("price"));
                service.setService_id(rs.getInt("builing_service_id"));
                list.add(service);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
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

    public ServiceBuildinng getServiceBuilding(int id) {
        ServiceBuildinng serviceBuildinng = new ServiceBuildinng();

        try {
            PreparedStatement ps = ConnectionToDataBase.getConnection().prepareStatement(getServiceBuilding);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                serviceBuildinng.setDescription(rs.getString("description"));
                serviceBuildinng.setPrice(rs.getInt("price"));
                serviceBuildinng.setService_id(rs.getInt("builing_service_id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return serviceBuildinng;
    }

}
