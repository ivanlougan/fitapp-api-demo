package com.rombert.demo.app;

import java.util.List;
import java.util.Optional;

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

    public UserEntity updateUser(Long userId, String email, String user_name) {

        Optional<UserEntity> existingUser = userRepository.findById(userId);

        if(existingUser.isPresent()) {
            UserEntity user = existingUser.get();
            user.setEmail(email);
            user.setUsername(user_name);
            return userRepository.save(user);
        } else {
            throw new UserNotFoundException("User with id " + userId + " not found.");
        }
    }

    public void deleteUser(Long userId) {

        Optional<UserEntity> existingUser = userRepository.findById(userId);

        if (existingUser.isPresent()) {
            userRepository.deleteById(userId);
        } else {
            throw new UserNotFoundException("User with id " + userId + " not found.");
        }
    }
}
