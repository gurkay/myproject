package com.project.admin.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.admin.entity.User;

@Controller
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String listUsers(Model model) {

        List<User> listAllUsers = userService.listAllUsers();   

        model.addAttribute("listAllUsers", listAllUsers);
        model.addAttribute("pageTitle", "All Users");

        return "users/users";
    }

    @PostMapping("/users/save")
    public String saveUser(User user, RedirectAttributes redirectAttributes) {

        User savedUser = userService.save(user);

        redirectAttributes.addFlashAttribute("message", "User : " + savedUser.getFirstName() + " saved.");

        return "redirect:/users";
    }

    @GetMapping("/users/new")
    public String newUser(Model model) {
        User user = new User();
        
        model.addAttribute("user", user);
        model.addAttribute("pageTitle", "Create New User");

        return "users/user_form";
    }

    @GetMapping("/users/edit/{id}")
    public String editUser(@PathVariable(name = "id") Integer id, Model model) {
        User user = userService.getUserId(id);

        model.addAttribute("user", user);
        model.addAttribute("pageTitle", "Edit User ID : [" + id + "]");

        return "users/user_form";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable(name = "id") Integer id, Model model, RedirectAttributes redirectAttributes) {

        userService.delete(id);
        redirectAttributes.addFlashAttribute("message", "The user ID " + id + " has been delete successfully.");

        return "redirect:/users";
    }
}
