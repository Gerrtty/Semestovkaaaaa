package DAO;

import ORM.Assessment;

import java.util.List;
import java.util.Optional;

public class AssessmentDAO implements DAO<Assessment> {

    public AssessmentDAO() {
        super();
    }

    @Override
    public Optional<Assessment> get(int id) {
        return Optional.empty();
    }

    @Override
    public List<Assessment> getAll() {
        return null;
    }

    @Override
    public void add(Assessment assessment) {

    }

    @Override
    public void update(Assessment assessment) {

    }

    @Override
    public void delete(Assessment assessment) {

    }
}
