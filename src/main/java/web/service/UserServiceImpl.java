package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import web.dao.UserDao;
import web.models.User;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao ud;

    @Override
    public void addUser(User user) {
        ud.addUser(user);
    }

    @Override
    public void deleteUser(long id) {
        ud.deleteUser(id);
    }

    @Override
    public void updateUser(long id, String name, String surname, String mail, int age) {
        ud.updateUser(id, name, surname, mail, age);
    }

    @Override
    public List<User> getAllUsers() {
        return ud.getAllUsers();
    }
}
