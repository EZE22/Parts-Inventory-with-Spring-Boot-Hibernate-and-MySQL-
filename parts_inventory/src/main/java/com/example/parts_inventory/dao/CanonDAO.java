package com.example.parts_inventory.dao;

import com.example.parts_inventory.entity.Canon;

import java.util.List;

public interface CanonDAO {
    List<Canon> findAll();
    Canon findById(int theId);
    void save(Canon newPart);
    void deleteById(int theId);
}
