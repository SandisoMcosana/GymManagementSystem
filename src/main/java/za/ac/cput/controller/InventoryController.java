package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Inventory;
import za.ac.cput.service.InventoryService;

import java.util.List;

public class InventoryController {
    @Autowired
    private InventoryService service;


    @PostMapping("/create")
    Inventory create(@RequestBody Inventory inventory) {
        return service.create(inventory);
    }
    @GetMapping("/{id}")
    Inventory read(@PathVariable Integer id) {
        return service.read(id);
    }
    @PutMapping("/update")
    public Inventory updateInventory(@RequestBody Inventory inventory) {
        return service.update(inventory);
    }
    @GetMapping("/all")
    public List<Inventory> getAll() {
        return service.getAll();
    }
    @DeleteMapping("/delete/{itemId}")
    public void delete(@PathVariable Integer itemId) {
        service.delete(itemId);
    }

}
