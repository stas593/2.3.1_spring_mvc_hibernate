package web.dao;

import web.models.User;

import javax.transaction.Transactional;
import java.util.List;

public interface UserDao {
    void addUser(User user);
    void deleteUser(long id);
    void updateUser(long id, String name, String surname, String mail, int age);
    List<User> getAllUsers();
}
