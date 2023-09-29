package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Manager;
import za.ac.cput.service.ManagerService;

import java.util.List;

@RestController
@CrossOrigin(origins = "Http://localhost:3000")
@RequestMapping("'/manager")
public class ManagerController {
    @Autowired
    private ManagerService service;

    @PostMapping("/create")
    Manager create(@RequestBody Manager manager){
        return service.create(manager);
    }

    @GetMapping({"/", "/all"})
    List<Manager> getAll(){
        return service.getAll();
    }
}
