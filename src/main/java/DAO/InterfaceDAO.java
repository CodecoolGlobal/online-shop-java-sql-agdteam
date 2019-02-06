package DAO;

import java.util.List;

public interface InterfaceDAO<T> {
    List<T> getAll();
    void add(T instance);
    void delete(T instance);
    void update(int id, T instance);
}
