package ru.mytnik.dao;

import java.util.List;

public interface DAOInterface<T> {
    
    void persist(T value);
    void delete(T value);
    void update(T value);
    T findById(Integer id);
    List<T> findAll();
}
