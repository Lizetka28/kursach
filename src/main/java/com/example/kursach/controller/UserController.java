package com.example.kursach.controller;


import com.example.kursach.model.User;
import com.example.kursach.servise.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/")
    public String start() {
        return "start";
    }//возвращает начальную страницу

    @GetMapping("/login")//возвращает страницу входа
    public String login() {
        return "login";
    }

    @GetMapping("/registration")//возвращает страницу регистрации
    public String registration() {
        return "registration";
    }


    @PostMapping("/registration")//принимает из формы данные, создает в бд пользователя и возвращает на страницу входа
    public String createUser(User user) {
        userService.createUser(user);
        return "redirect:/login";
    }

}