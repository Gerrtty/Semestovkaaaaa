package DAO;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    Optional<T> get(int id);

    List<T> getAll();

    void add(T t);

    void update(T t);

    void delete(T t);

}
