package com.example.chatgptspring;

import com.example.chatgptspring.controller.ApplicationController;
import com.example.chatgptspring.entity.Encryptor;
import com.example.chatgptspring.entity.User;
import com.example.chatgptspring.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class ChatGptSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatGptSpringApplication.class, args);
    }
}
