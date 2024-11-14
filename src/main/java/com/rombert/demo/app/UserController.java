package com.rombert.demo.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/api/users")
public class UserController {
    

    @Autowired
    private UserService userService;

    
    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping()
    public UserEntity createUser(@RequestParam String email,@RequestParam String user_name) {
        return userService.saveUser(email, user_name);
    }

    // other CRUD endpoints
    
}
