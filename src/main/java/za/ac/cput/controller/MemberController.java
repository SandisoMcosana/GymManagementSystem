package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Member;
import za.ac.cput.service.MemberService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService service;

    @PostMapping("/create")
    Member create(@RequestBody Member member){
        return service.create(member);
    }

    @GetMapping({"/", "/all"})
    List<Member> getAll(){
        return service.getAll();
    }
}
