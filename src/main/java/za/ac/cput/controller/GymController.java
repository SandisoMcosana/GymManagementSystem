package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Gym;
import za.ac.cput.service.GymService;

import java.util.List;

public class GymController {
    @Autowired
    private GymService service;
    @PostMapping("/create")
    Gym create(@RequestBody Gym gym) {
        return service.create(gym);
    }
    @GetMapping("/{id}")
    Gym read(@PathVariable Integer id) {
        return service.read(id);
    }
    @PutMapping("/update")
    public Gym updateInventory(@RequestBody Gym gym) {
        return service.update(gym);
    }
    @GetMapping("/all")
    public List<Gym> getAll() {
        return service.getAll();
    }
    @DeleteMapping("/delete/{itemId}")
    public void delete(@PathVariable Integer itemId) {
        service.delete(itemId);
    }
}
