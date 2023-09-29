package za.ac.cput.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Subscription;
import za.ac.cput.service.SubscriptionService;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/subscription")
public class SubscriptionController {
    @Autowired
    private SubscriptionService service;
    @PostMapping("/create")
    Subscription create(@RequestBody Subscription subscription){
        return service.create(subscription);
    }
    @GetMapping({"/", "/all"})
    List<Subscription> getAll(){
        return service.getAll();
    }
}
