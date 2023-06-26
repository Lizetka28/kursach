package com.example.kursach.controller;

import com.example.kursach.model.Role;
import com.example.kursach.model.User;
import com.example.kursach.servise.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class AdminController {
    private final UserService userService;
    @GetMapping("/admin")//возвращает страницу админской панели, выводит из бд данные о пользоватлях
    public String admin(Model model){
        model.addAttribute("users", userService.list());
        return "admin";
    }
    @PostMapping("/admin/user/ban/{id}")//принимает id пользователя, изменяет значение его активности, возвращает страницу админа
    public String userBan(@PathVariable("id") Long id){
        userService.banUser(id);
        return "redirect:/admin";
    }
    @GetMapping("/admin/user/edit/{user}")// принимает пользователя, возвращает страницу изменения роли пользователя
    public String userEdit(@PathVariable("user") User user, Model model){
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "user-edit";
    }
    @PostMapping("/admin/user/edit")//принимает данные из формы, меняет роль пользователя, возвращает страницу админа
    public String userEdit(@RequestParam("userId") User user, @RequestParam Map<String, String> form){
        userService.changeUserRoles(user,form);
        return "redirect:/admin";
    }
}
