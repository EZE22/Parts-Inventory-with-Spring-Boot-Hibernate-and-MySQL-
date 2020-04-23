package com.example.parts_inventory.rest;

import com.example.parts_inventory.entity.Canon;
import com.example.parts_inventory.dao.CanonDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class CanonController {

    private CanonDAOImpl canonService;

    @Autowired
    public CanonController(CanonDAOImpl canonService) {
        this.canonService = canonService;
    }

    @GetMapping("/canonRetrieveAllParts")
    public List<Canon> getAllParts() {
        return canonService.findAll();
    }

    @DeleteMapping("/canonDeletePartById/{partId}")
    public String deletePartById(@PathVariable int partId) {
        Canon canon = canonService.findById(partId);
        if(canon == null) {
            throw new RuntimeException("Part not found: " + partId);
        }
        canonService.deleteById(partId);
        return "Deleted part id: " + partId;
    }

    @PutMapping("/updateCanonPart")
    public Canon updateCanonPart(@RequestBody Canon updateCanonPart) {
        canonService.save(updateCanonPart);
        return updateCanonPart;
    }

    @PostMapping("/canonAddNewPart")
    public Canon addNewPart(@RequestBody Canon newPart) {
        newPart.setId(0);
        canonService.save(newPart);
        return newPart;
    }
}
