package DAO;

import ORM.Imagies;

import java.util.List;
import java.util.Optional;

public class ImagiesDAO implements DAO<Imagies> {
    @Override
    public Optional<Imagies> get(int id) {
        return Optional.empty();
    }

    @Override
    public List<Imagies> getAll() {
        return null;
    }

    @Override
    public void add(Imagies imagies) {

    }

    @Override
    public void update(Imagies imagies) {

    }

    @Override
    public void delete(Imagies imagies) {

    }
}
