package DAO;

import ORM.Review;

import java.util.List;
import java.util.Optional;

public class ReviewDaO implements DAO<Review> {
    @Override
    public Optional<Review> get(int id) {
        return Optional.empty();
    }

    @Override
    public List<Review> getAll() {
        return null;
    }

    @Override
    public void add(Review review) {

    }

    @Override
    public void update(Review review) {

    }

    @Override
    public void delete(Review review) {

    }
}
