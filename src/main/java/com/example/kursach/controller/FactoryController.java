package com.example.kursach.controller;

import com.example.kursach.model.Factory;
import com.example.kursach.model.Sweet;
import com.example.kursach.model.User;
import com.example.kursach.servise.FactoryService;
import com.example.kursach.servise.SweetService;
import com.example.kursach.servise.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
public class FactoryController {
    private FactoryService factoryService;
    private UserService userService;
    private SweetService sweetService;
    public FactoryController(FactoryService factoryService, SweetService sweetService, UserService userService){
        this.factoryService=factoryService;
        this.sweetService= sweetService;
        this.userService=userService;
    }
    @GetMapping("/factories")//возвращает главную страницу, может принимать названия фабрик/конфет и искать их в бд, выводит данные о фабриках и конфетах из бд
    public String findAll(@RequestParam( name="name", required = false) String name, @RequestParam( name="name", required = false) String name2, Model model, Principal principal){
        List<Factory> factories=factoryService.findAll();
        model.addAttribute("factories",factories);
        model.addAttribute("factories2", factoryService.listFactory(name));
        model.addAttribute("sweets2", sweetService.listSweet(name2));
        List<Sweet> sweets=sweetService.findAll();
        model.addAttribute("sweets",sweets);
        User user = userService.getUserByPrincipal(principal);
        model.addAttribute("user",user);
        return "factory-list";
    }
    @GetMapping("/factory-create")//возвращает страницу создания фабрики
    public String createFactoryForm(Factory factory){
        return "factory-create";
    }
    @PostMapping("/factory-create")//принимает из формы данные о фабрике и создает ее в бд, возвращает на главную страницу
    public String createFactory(Factory factory){
        factoryService.saveFactory(factory);
        return "redirect:/factories";
    }
    @GetMapping("factory-delete/{id}")//принимает id фабрики, удаляет её из бд и возвращает главную страницу
    public String deleteFactory(@PathVariable("id") Long id){
        factoryService.deleteById(id);
        return "redirect:/factories";
    }
    @GetMapping("factory-update/{id}")//принимает id фабрики, возвращает страницу изменения фабрики, где выведены ее характеристики
    public String updateFactoryForm(@PathVariable("id") Long id,Model model){
        Factory factory=factoryService.findById(id);
        model.addAttribute("factory",factory);
        return "/factory-update";
    }
    @PostMapping("/factory-update")//принимает из формы данные о фабрике, изменяет ее в бд и возвращает главную страницу
    public String updateFactory(Factory factory){
        factoryService.saveFactory(factory);
        return "redirect:/factories";
    }
}
