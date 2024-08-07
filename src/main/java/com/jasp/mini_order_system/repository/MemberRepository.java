package com.jasp.mini_order_system.repository;

import com.jasp.mini_order_system.entity.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemberRepository implements Repository<Member> {

    private static final Map<Integer, Member> DB = new ConcurrentHashMap<>();


    @Override
    public void save(Member entity) {

    }

    @Override
    public Member findById(int id) {
        return null;
    }

    @Override
    public List<Member> findAll() {
        return List.of();
    }

    @Override
    public boolean update(Member entity) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}