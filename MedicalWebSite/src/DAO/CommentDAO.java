package DAO;

import ORM.Comment;
import interfaces.DAO;

import java.util.List;
import java.util.Optional;

public class CommentDAO implements DAO<Comment> {
    @Override
    public Optional<Comment> get(int id) {
        return Optional.empty();
    }

    @Override
    public List<Comment> getAll() {
        return null;
    }

    @Override
    public void add(Comment comment) {

    }

    @Override
    public void update(Comment comment) {

    }

    @Override
    public void delete(Comment comment) {

    }
}
