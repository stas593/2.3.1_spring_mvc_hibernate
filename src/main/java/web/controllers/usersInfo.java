package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.UserDao;
import web.models.User;
import web.service.UserService;

import java.util.List;

@Controller
public class usersInfo {
    @Autowired
    private UserService us;

    @GetMapping(value = "/")
    public String postInfo(Model model){
        List<User> users = us.getAllUsers();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam int id){
        us.deleteUser(id);
        return "redirect:/";
    }
}
