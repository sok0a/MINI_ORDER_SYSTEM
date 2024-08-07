package com.jasp.mini_order_system.repository;

import com.jasp.mini_order_system.entity.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ItemRepository implements Repository<Item> {

    private static final Map<Integer, Item> DB = new ConcurrentHashMap<>();


    @Override
    public void save(Item entity) {

    }

    @Override
    public Item findById(int id) {
        return null;
    }

    @Override
    public List<Item> findAll() {
        return List.of();
    }

    @Override
    public boolean update(Item entity) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}