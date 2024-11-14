package com.rombert.demo.app;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity saveUser(String email, String user_name) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(email);
        userEntity.setUsername(user_name);
        return userRepository.save(userEntity);
    }

    // other CRUD operations
}
