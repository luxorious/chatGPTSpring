package com.example.chatgptspring.controller;

import com.example.chatgptspring.entity.User;
import com.example.chatgptspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApplicationController {
    private UserService userService;

    @Autowired
    public ApplicationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/show-all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping(value = "/registration")
    public String saveInDb(@RequestBody User user){
        userService.saveUser(user);
        return "/done";
    }

    @GetMapping(value = "/users/{id}")
    public User getById(@PathVariable Integer id){
        return userService.getUserById(id);
    }
}
