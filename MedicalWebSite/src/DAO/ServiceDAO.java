package DAO;

import ORM.Service;

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
}
