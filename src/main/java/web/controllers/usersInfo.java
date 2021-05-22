package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.dao.UserDao;
import web.models.User;

import java.util.List;

@Controller
public class usersInfo {

    @Autowired
    private UserDao ud;

    @GetMapping(value = "/")
    public String postInfo(Model model){
        List<User> users = ud.getAllUsers();
        model.addAttribute("users", users);
        return "index";
    }
}
