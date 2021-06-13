package web.dao;

import web.models.Role;
import web.models.User;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

public interface UserDao {
    void addUser(User user);
    User getUser(long id);
    User findByLogin(String userName);
    void deleteUser(long id);
    void updateUser(User user);
    List<User> getAllUsers();
    void addRoleToUser(long userId, Role role);
}
