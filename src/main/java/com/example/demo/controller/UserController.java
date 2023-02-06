package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.service.UserService;

@Controller
@Secured({"ROLE_USER", "ROLE_ADMIN"})
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public String getPersonalData(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        return "userPage";

    }


}
