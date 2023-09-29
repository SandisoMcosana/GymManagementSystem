package za.ac.cput.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.User;
import za.ac.cput.service.UserService;
import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;
    @PostMapping("/create")
    User create(@RequestBody User user){
        return service.create(user);
    }
    @GetMapping({"/", "/all"})
    List<User> getAll(){
        return service.getAll();
    }
}
