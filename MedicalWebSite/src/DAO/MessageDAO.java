package DAO;

import ORM.Message;

import java.util.List;
import java.util.Optional;

public class MessageDAO implements DAO<Message> {
    @Override
    public Optional<Message> get(int id) {
        return Optional.empty();
    }

    @Override
    public List<Message> getAll() {
        return null;
    }

    @Override
    public void add(Message message) {

    }

    @Override
    public void update(Message message) {

    }

    @Override
    public void delete(Message message) {

    }
}
