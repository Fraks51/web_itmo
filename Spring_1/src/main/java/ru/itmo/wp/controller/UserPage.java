package ru.itmo.wp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itmo.wp.domain.User;
import ru.itmo.wp.service.UserService;

@Controller
@RequestMapping("/user")
public class UserPage {
    private final UserService userService;

    public UserPage(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "{id}")
    public String getUser(@PathVariable String id, Model model) {
        long longID = 1;
        try {
            longID = Long.parseLong(id);
        } catch (Exception e) {
            // no Operation
        }
        User user = userService.findById(longID);
        model.addAttribute("thisUser", user);
        return "UserPage";
    }
 }
