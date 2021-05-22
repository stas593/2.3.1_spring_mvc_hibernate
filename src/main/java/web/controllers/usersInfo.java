package web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import web.dao.UserDao;
import web.dao.UserDaoImpl;
import web.models.User;

@Controller
public class usersInfo {
    @GetMapping(value = "/")
    public String postInfo(){
        UserDao ud = new UserDaoImpl();
        User stas = new User("Stanislav", "Loparev", "yastas593@mail.ru", 22);
        ud.addUser(stas);
        return "index";
    }
}
