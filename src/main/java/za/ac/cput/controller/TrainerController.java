package za.ac.cput.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Trainer;
import za.ac.cput.domain.User;
import za.ac.cput.service.TrainerService;
import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/trainer")
public class TrainerController {
    @Autowired
    private TrainerService service;
    @PostMapping("/create")
    Trainer create(@RequestBody Trainer trainer){
        return service.create(trainer);
    }
    @GetMapping({"/", "/all"})
    List<Trainer> getAll(){
        return service.getAll();
    }
}
