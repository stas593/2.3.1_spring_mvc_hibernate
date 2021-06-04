package web.service;

import org.springframework.stereotype.Component;
import web.models.Role;
import web.models.User;

import java.util.List;
import java.util.Set;

public interface UserDetailService {
    void addUser(User user);
    User getUser(long id);
    User findUserByLogin(String userName);
    Role getRoleByName(String nameRole);
    void deleteUser(long id);
    void updateUser(User user);
    List<User> getAllUsers();
    List<Role> getAllRoles();
    void addRoleToUser(long userId, String nameRole);
    Set<Role> getAllRolesFromUser(long userId);
}
