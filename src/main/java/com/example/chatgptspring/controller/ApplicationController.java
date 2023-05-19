package com.example.chatgptspring.controller;

import com.example.chatgptspring.entity.Encryptor;
import com.example.chatgptspring.entity.User;
import com.example.chatgptspring.service.UserService;
import com.example.chatgptspring.userRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApplicationController {
    private UserService userService;
    private UserRepository userRepository;
    private Encryptor encryptor;

    @Autowired
    public ApplicationController(UserService userService, UserRepository userRepository, Encryptor encryptor) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.encryptor = encryptor;
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
    @GetMapping(value = "/save")
    public String save(){
        User user = new User("name", "login", "email", "password");
        userService.saveUser(user);
        return "/done";
    }

    @GetMapping(value = "/users/{id}")
    public User getById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @PostMapping(value = "/delete-by-login")
    @Transactional
    public String deleteByLogin(@RequestParam String login, @RequestParam String password){
        List<Integer> pass = List.of(encryptor.encrypt(password));
        User user = userRepository.getUsersByLogin(login);
        if (arePasswordsEquals(pass,user.getPassword())) {
            userRepository.delete(user);
            return "Done";
        } else {
            return "login or password not found!";
        }
    }

    private boolean arePasswordsEquals(List<Integer> list1, List<Integer> list2){
        if (list1.size()!=list2.size()){
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))){
                return false;
            }
        }
        return true;
    }

    @GetMapping(value = "/user/{login}")
    public User getByLogin(@PathVariable String login){
        return userRepository.getUsersByLogin(login);
    }
}
