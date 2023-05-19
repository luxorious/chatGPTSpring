package com.example.chatgptspring.service;

import com.example.chatgptspring.entity.User;
import com.example.chatgptspring.userRepository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    //    Реалізуйте клас UserService, який має конструктор, що приймає об'єкт типу UserRepository,
//    та реалізує методи для додавання, отримання списку та отримання користувача за ідентифікатором.
//    Конфігуруйте Spring таким чином, щоб він автоматично створював біни UserRepository та UserService.
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Integer id){
        return userRepository.getUserById(id);
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

}
