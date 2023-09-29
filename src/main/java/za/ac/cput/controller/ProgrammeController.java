package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Programme;
import za.ac.cput.service.ProgrammeService;

import java.util.List;

@RestController
@RequestMapping("/programme")
public class ProgrammeController {
    @Autowired
    private ProgrammeService service;

    @PostMapping("/create")
    Programme create(@RequestBody Programme programme){
        return service.create(programme);
    }

    @GetMapping({"/", "/all"})
    List<Programme> getAll(){
        return service.getAll();
    }
}
