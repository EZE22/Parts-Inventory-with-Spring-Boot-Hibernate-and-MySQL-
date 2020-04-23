package com.example.parts_inventory.dao;

import com.example.parts_inventory.entity.Nikon;
import java.util.List;

public interface NikonDAO {
    List<Nikon> findAll();
    Nikon findById(int theId);
    void save(Nikon newPart);
    void deleteById(int theId);
}
