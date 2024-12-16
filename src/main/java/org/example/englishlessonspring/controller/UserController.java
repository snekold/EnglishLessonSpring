package org.example.englishlessonspring.controller;

import lombok.AllArgsConstructor;
import org.example.englishlessonspring.model.entity.User;
import org.example.englishlessonspring.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/")
    public String menu() {
        return "index";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable int id) {
        return "user";
    }

    @GetMapping("/registration")
    public String getRegistration() {
        return "registration";
    }


    @PostMapping("/registration")
    public String postRegistration(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String r_password,
            Model model) {

        if(!password.equals(r_password)){
            model.addAttribute("message", "пароли не совпадают");
            return "registration";
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userService.save(user);

        return "registration";

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
