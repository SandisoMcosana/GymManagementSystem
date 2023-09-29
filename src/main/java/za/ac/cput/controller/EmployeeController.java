package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.User;
import za.ac.cput.service.EmployeeService;


import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService service;
    @PostMapping("/create")
    Employee create(@RequestBody Employee employee){
        return service.create(employee);
    }

    @GetMapping("/{id}")
    Employee read(@PathVariable Integer id) {
        System.out.println("Employee"+id);
        return service.read(id);
    }
    @PostMapping("/update")
    Employee update(@RequestBody Employee employee) {
        return service.create(employee);
    }
    @GetMapping({"/", "/all"})
    List<Employee> getAll(){
        return service.getAll();
    }
}
