package com.jasp.mini_order_system.repository;

import com.jasp.mini_order_system.entity.Order;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OrderRepository implements Repository<Order> {

    private static final Map<Integer, Order> DB = new ConcurrentHashMap<>();


    @Override
    public void save(Order entity) {

    }

    @Override
    public Order findById(int id) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return List.of();
    }

    @Override
    public boolean update(Order entity) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}