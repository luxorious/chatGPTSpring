package com.example.chatgptspring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fullName")
    private String fullName;
    @Column(name = "login")
    private String login;
    @Column(name = "eMail")
    private String eMail;
    @Column(name = "password")
    @ElementCollection()
    private List<Integer> password;

    public User(String fullName, String login, String eMail) {
        this.fullName = fullName;
        this.login = login;
        this.eMail = eMail;
    }

//    можно ли так делать в класс сущность внедрить зависимость для зашифровки пароля?
//    результат работи данного метода сохраняет зашифрований пароль в переменную
//    типа List password через конструктор.
    public User(String fullName, String login, String eMail, String password) {
        this.fullName = fullName;
        this.login = login;
        this.eMail = eMail;
        this.password = encryptPassword(password);
    }

    private List<Integer> encryptPassword(String password){
        Encryptor pw = new Encryptor();
        return List.of(pw.encrypt(password));
    }
//////////////////////////////////////////////////////////////////////////////
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
}
