package com.project.admin.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @PostMapping("/users/save")
    public String saveUser(User user, RedirectAttributes redirectAttributes) {

        User savedUser = userService.save(user);

        redirectAttributes.addFlashAttribute("message", "User : " + savedUser.getFirstName() + " saved.");

        return "redirect:/index";
    }
}
