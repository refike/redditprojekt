package com.greenfoxacademy.redditprojekt.redditprojekt.Controllers;

import com.greenfoxacademy.redditprojekt.redditprojekt.Repository.Model.User;
import com.greenfoxacademy.redditprojekt.redditprojekt.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    private final UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"","/"})
    public String mainpage(Model model){
        model.addAttribute("newuser", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/post";
    }
}

