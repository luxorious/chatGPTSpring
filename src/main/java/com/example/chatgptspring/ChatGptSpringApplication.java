package com.example.chatgptspring;

import com.example.chatgptspring.entity.Encryptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class ChatGptSpringApplication {

    public static void main(String[] args) {
        Encryptor pw = new Encryptor();
        String password = "password123";
        Integer[] arr = pw.encrypt(password);
        System.out.println(Arrays.toString(arr));
        String arr1 = pw.decryptPassword(arr);
        System.out.println(arr1);
        SpringApplication.run(ChatGptSpringApplication.class, args);
    }

}
