package DAO;

import ORM.Building;

import java.util.List;
import java.util.Optional;

public class BuildingDAO implements DAO<Building> {
    public BuildingDAO() {
        super();
    }

    @Override
    public Optional<Building> get(int id) {
        return Optional.empty();
    }

    @Override
    public List<Building> getAll() {
        return null;
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
