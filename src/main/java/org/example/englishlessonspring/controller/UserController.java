package org.example.englishlessonspring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @GetMapping("/menu")
    public String menu() {
        return "menu";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable int id) {
    return "user";
    }

    @PostMapping("/auth")
    public String postAuth(
            @RequestParam String username,
            @RequestParam String password) {

        if (username.equals("admin") && password.equals("000")) {
            return "redirect:/menu";
        }
        return "login";

    }



}
