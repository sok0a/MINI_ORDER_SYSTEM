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
        DB.put(entity.getId(), entity);
    }

    @Override
    public Order findById(int id) {
        return DB.get(id);
    }

    @Override
    public List<Order> findAll() {
        return new ArrayList<>(DB.values());
    }

    @Override
    public boolean update(Order entity) {
        if(DB.containsKey(entity.getId())) {
            DB.put(entity.getId(), entity);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        if(DB.containsKey(id)) {
            DB.remove(id);
            return true;
        }else{
            return false;
        }
    }
}