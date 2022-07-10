package com.finance.manager.controller;

import com.finance.manager.model.User;
import com.finance.manager.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {

    private UserRepository userRepository;

    @GetMapping("/users")
    public Object all(@RequestParam(required = false) Long id, @RequestParam(required = false) String username) { //todo define return type
        if (id != null) {
            return userRepository.findById(id);
        } else if (username != null) {
            return userRepository.findByUsername(username);
        }
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public User newUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}
