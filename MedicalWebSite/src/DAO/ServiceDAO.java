package DAO;

import ORM.Service;
import interfaces.DAO;
import some_usefull_classes.ConnectionToDataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ServiceDAO implements DAO<Service> {
    @Override
    public Optional<Service> get(int id) {
        return Optional.empty();
    }

    @Override
    public List<Service> getAll() {
        return null;
    }

    @Override
    public void add(Service service) {

    }

    @Override
    public void update(Service service) {

    }

    @Override
    public void delete(Service service) {

    }

    public int getIdByDescription(String description) {
        String select = "select service_id from semestrovka.Service where description = ?";
        int id = 0;
        try {
            PreparedStatement ps = ConnectionToDataBase.getConnection().prepareStatement(select);
            ps.setString(1, description);
            ResultSet rs = ps.executeQuery();
            rs.next();
            id = rs.getInt("service_id");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }
}
