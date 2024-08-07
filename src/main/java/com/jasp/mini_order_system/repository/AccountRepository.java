package com.jasp.mini_order_system.repository;

import com.jasp.mini_order_system.entity.Account;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AccountRepository implements Repository<Account> {

    private static final Map<Integer, Account> DB = new ConcurrentHashMap<>();

    @Override
    public void save(Account entity) {

    }

    @Override
    public Account findById(int id) {
        return null;
    }

    @Override
    public List<Account> findAll() {
        return List.of();
    }

    @Override
    public boolean update(Account entity) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}