package com.jasp.mini_order_system.repository;

import java.util.List;
import java.util.Map;

public interface Repository<T> {


    void save(T entity);

    T findById(int id);

    List<T> findAll();

    boolean update(T entity);

    boolean delete(int id);

    default boolean notExists(Map<Integer, T> db, int id) {
        return !db.containsKey(id);
    }
}