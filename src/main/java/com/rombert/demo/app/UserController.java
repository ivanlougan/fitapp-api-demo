package com.rombert.demo.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



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
    
    @PutMapping("/{id}")
    public UserEntity updateUser(@PathVariable Long id, @RequestParam String email, @RequestParam String user_name) {
        return userService.updateUser(id, email, user_name);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
    
}
