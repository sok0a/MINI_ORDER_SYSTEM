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
        DB.put(entity.getId(), entity);
    }

    @Override
    public Account findById(int id) {
        return DB.get(id);
    }

    @Override
    public List<Account> findAll() {
        return new ArrayList<>(DB.values());
    }

    @Override
    public boolean update(Account entity) {
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