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
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "")
    public String postInfo(Model model){
        model.addAttribute("roles", roleService.getAllRoles());
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("user", new User());
        model.addAttribute("role", new Role());
        return "adminPanel";
    }


    @RequestMapping(value = "/deleteUser")
    public String deleteUser(@RequestParam("id") long id){
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUser(@ModelAttribute("user") User user, @RequestParam(name = "roleName") String roleName){
        user.addRoleToUser(roleService.getRoleByName(roleName));
        userService.addUser(user);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.GET)
    public String updateUser(@RequestParam("id") long id, Model model){
        model.addAttribute("roles", roleService.getAllRoles());
        User user = userService.getUser(id);
        model.addAttribute("userUp", user);
        return "update-user";
    }

    @GetMapping(value = "/saveUser")
    public String updateUser(@ModelAttribute(name = "userUp") User user, @RequestParam(name = "roleName", required = false) String roleName){
        System.out.println(user.toString());
        if(roleName == null){
            user.setRoles(userService.getUser(user.getId()).getRoles());
            userService.updateUser(user);
        } else {
            user.addRoleToUser(roleService.getRoleByName(roleName));
            userService.updateUser(user);
        }
        return "redirect:/admin";
    }
}
