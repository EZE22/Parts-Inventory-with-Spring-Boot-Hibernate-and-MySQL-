package com.example.parts_inventory.rest;

import com.example.parts_inventory.dao.NikonDAOImpl;
import com.example.parts_inventory.entity.Nikon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class NikonController {

    private NikonDAOImpl nikonServiceImpl;

    @Autowired
    public NikonController(NikonDAOImpl nikonServiceImpl) {
        this.nikonServiceImpl = nikonServiceImpl;
    }

    @GetMapping("/nikonRetrieveAllParts")
    public List<Nikon> getAllParts() {
        return nikonServiceImpl.findAll();
    }

    @DeleteMapping("/nikonDeletePartById/{partId}")
    public String deletePartById(@PathVariable int partId) {
        Nikon nikon = nikonServiceImpl.findById(partId);
        if(nikon == null) {
            throw new RuntimeException("Part not found: " + partId);
        }
        nikonServiceImpl.deleteById(partId);
        return "Deleted part id: " + partId;
    }

    @PutMapping("/updateNikonPart")
    public Nikon updatePart(@RequestBody Nikon updatePart) {
        nikonServiceImpl.save(updatePart);
        return updatePart;
    }

    @PostMapping("/nikonAddNewPart")
    public Nikon addNewPart(@RequestBody Nikon newPart) {
        newPart.setId(0);
        nikonServiceImpl.save(newPart);
        return newPart;
    }
}
