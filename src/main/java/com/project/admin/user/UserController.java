package com.project.admin.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.admin.entity.User;

@Controller
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/users/new")
    public String newUser(Model model) {
        User user = new User();
        
        model.addAttribute("user", user);
        model.addAttribute("pageTitle", "Create New User");

        return "users/user_form";
    }
}
