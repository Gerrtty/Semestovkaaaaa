package DAO;

import ORM.ServiceBuildinng;

import java.util.List;
import java.util.Optional;

public class ServiceBuildingDAO implements DAO<ServiceBuildinng> {
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
}
