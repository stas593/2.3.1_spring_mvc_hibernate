package web.service;

import org.springframework.stereotype.Component;
import web.models.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void deleteUser(long id);
    void updateUser(long id, String name, String surname, String mail, int age);
    List<User> getAllUsers();
}
