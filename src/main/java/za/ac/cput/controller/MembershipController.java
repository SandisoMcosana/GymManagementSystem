package za.ac.cput.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Membership;
import za.ac.cput.service.MembershipService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/membership")
public class MembershipController {
    @Autowired
    private MembershipService service;
    @PostMapping("/create")
    Membership create(@RequestBody Membership membership){
        return service.create(membership);
    }
    @GetMapping({"/", "/all"})
    List<Membership> getAll(){
        return service.getAll();
    }
}
