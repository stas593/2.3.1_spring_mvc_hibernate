package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.Role;
import web.models.User;
import web.service.RoleService;
import web.service.UserService;

@Controller
@RequestMapping(value = "/admin")
public class Admin {

    @Autowired
    private UserService us;

    @Autowired
    private RoleService rs;

    @GetMapping(value = "")
    public String postInfo(Model model){
        model.addAttribute("roles", rs.getAllRoles());
        model.addAttribute("users", us.getAllUsers());
        model.addAttribute("user", new User());
        model.addAttribute("role", new Role());
        return "adminPanel";
    }


    @GetMapping(value = "/deleteUser")
    public String deleteUser(@RequestParam("id") long id){
        us.deleteUser(id);
        return "redirect: /admin";
    }

    @GetMapping(value = "/addUser")
    public String addUser(@ModelAttribute("user") User user, @RequestParam(name = "roleName") String roleName){
        user.addRoleToUser(rs.getRoleByName(roleName));
        us.addUser(user);
        return "redirect: /admin";
    }

    @GetMapping(value = "/updateUser")
    public String updateUser(@RequestParam("id") long id, Model model){
        model.addAttribute("roles", rs.getAllRoles());
        User user = us.getUser(id);
        model.addAttribute("userUp", user);
        return "update-user";
    }

    @GetMapping(value = "/saveUser")
    public String updateUser(@ModelAttribute(name = "userUp") User user, @RequestParam(name = "roleName", required = false) String roleName){
        System.out.println(user.toString());
        if(roleName == null){
            user.setRoles(us.getUser(user.getId()).getRoles());
            us.updateUser(user);
        } else {
            user.addRoleToUser(rs.getRoleByName(roleName));
            us.updateUser(user);
        }
        return "redirect: /admin";
    }
}
