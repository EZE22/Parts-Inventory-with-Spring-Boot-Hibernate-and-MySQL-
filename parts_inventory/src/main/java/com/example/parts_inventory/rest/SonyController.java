package com.example.parts_inventory.rest;


import com.example.parts_inventory.entity.Sony;
import com.example.parts_inventory.dao.SonyDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class SonyController {

    private final SonyDAOImpl sonyService;

    @Autowired
    public SonyController(SonyDAOImpl sonyService) {
        this.sonyService = sonyService;
    }

    @GetMapping("/getAllSonyParts")
    public List getAllSonyParts() {
        return sonyService.findAll();
    }

    @GetMapping("/getSonyPartById/{partId}")
    public Sony getPart(@PathVariable int partId) {
        Sony part = sonyService.findById(partId);
        if(part == null) {
            throw new RuntimeException("Part ID not found: " + partId);
        }
        return part;
    }

    @PostMapping("/sonyAddNewPart")
    public Sony addNewPart(@RequestBody Sony newPart) {
        newPart.setId(0);
        sonyService.save(newPart);
        return newPart;
    }

    @PutMapping("/updateSonyPart")
    public Sony updatePart(@RequestBody Sony updatePart) {
        sonyService.save(updatePart);
        return updatePart;
    }

    @DeleteMapping("/deleteSonyPart/{partId}")
    public String deletePartById(@PathVariable int partId) {
        Sony nikon = sonyService.findById(partId);
        if(nikon == null) {
            throw new RuntimeException("Part not found: " + partId);
        }
        sonyService.deleteById(partId);
        return "Deleted part id: " + partId;
    }
}
