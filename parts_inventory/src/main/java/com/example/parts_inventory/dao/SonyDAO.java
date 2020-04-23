package com.example.parts_inventory.dao;

import com.example.parts_inventory.entity.Sony;

import java.util.List;

public interface SonyDAO {
    List<Sony> findAll();
    Sony findById(int theId);
    void save(Sony newPart);
    void deleteById(int theId);
}
