package web.dao;

import web.models.User;

public interface UserDao {
    void addUser(User user);
    void deleteUser(User user);
    void updateUser(User user);

}
