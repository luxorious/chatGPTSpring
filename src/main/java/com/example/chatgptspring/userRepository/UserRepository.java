package com.example.chatgptspring.userRepository;

import com.example.chatgptspring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
//    Створіть інтерфейс UserRepository, який наслідує від JpaRepository<User, Long>.
//реалізує методи для додавання, отримання списку та отримання користувача за ідентифікатором.
    User getUserById(Integer id);

    List<User> deleteByLoginAndPassword(String login, List<Integer> password);

    List<User> getUsersByFullName(String name);

//    @Query("SELECT new User (user.fullName, user.login, user.eMail) from User user" +
//    " where ")
//   User getInfo();

}
